package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;
import com.mycompany.fileprocessor.domain.entity.Salesman;
import java.math.BigDecimal;

public class SalesmanFactory implements EntityFactory {

    @Override
    public Entity create(String register) {
        String[] splitedRegister = register.split("ç");
        return new Salesman(
                splitedRegister[1],
                splitedRegister[2],
                new BigDecimal(splitedRegister[3])
        );
    }

}
