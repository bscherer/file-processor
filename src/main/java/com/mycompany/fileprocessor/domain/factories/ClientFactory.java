package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Client;
import com.mycompany.fileprocessor.domain.entity.Entity;

public class ClientFactory implements EntityFactory {

    @Override
    public Entity create(String register) {
        String[] splitedRegistries = register.split("ç");
        return new Client(splitedRegistries[1], splitedRegistries[2], splitedRegistries[3]);
    }
    
}
