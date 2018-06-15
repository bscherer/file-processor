package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Entity;


public interface EntityFactory {
    
    /**
     *
     * @param register
     * @return
     */
    abstract Entity create(String register);
    
}
