package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;
import com.mycompany.fileprocessor.domain.entity.Sale;
import com.mycompany.fileprocessor.domain.entity.SaleItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaleFactory implements EntityFactory {

    @Override
    public Entity create(String registry) {
        String[] splitedRegistries = registry.split("ç");
        Sale sale = new Sale(
                new Long(splitedRegistries[1]),
                createSaleItems(splitedRegistries[2]),
                splitedRegistries[3]        
        );        
        return sale;
    }
    
    private List<SaleItem> createSaleItems(String itemsRegistry){
        List<SaleItem> saleItems = new ArrayList();
        List<String> items = Arrays.asList(itemsRegistry.replace("[", "").replace("]", "").split(","));
        EntityFactory saleItemsFactory = new SaleItemFactory();
        for(String item : items) {
            saleItems.add((SaleItem) saleItemsFactory.create(item));
        }
        return saleItems;
    }
    
}
