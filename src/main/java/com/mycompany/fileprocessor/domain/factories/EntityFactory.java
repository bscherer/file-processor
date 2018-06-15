package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;


public interface EntityFactory {
    
    /**
     *
     * @param registry
     * @return
     */
    abstract Entity create(String registry);
    
}
