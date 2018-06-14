package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;
import com.mycompany.fileprocessor.domain.entity.SaleItem;
import java.math.BigDecimal;

public class SaleItemFactory implements EntityFactory {

    public SaleItemFactory() {
    }

    @Override
    public Entity create(String registry) {
        String[] splitedRegistries = registry.split("-");
        return new SaleItem(
                new Long(splitedRegistries[0]),
                new Long(splitedRegistries[1]),
                new BigDecimal(splitedRegistries[2])
        );
        
    }
    
    
    
}
