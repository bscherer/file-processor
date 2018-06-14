package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;


public interface EntityFactory {
    
    public Entity create(String registry);
    
}
