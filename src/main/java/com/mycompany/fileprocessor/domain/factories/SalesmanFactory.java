package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;
import com.mycompany.fileprocessor.domain.entity.Salesman;
import java.math.BigDecimal;

public class SalesmanFactory implements EntityFactory {

    @Override
    public Entity create(String registry) {
        String[] splitedRegistry = registry.split("ç");
        return new Salesman(
                splitedRegistry[1],
                splitedRegistry[2],
                new BigDecimal(splitedRegistry[3])
        );
    }

}
