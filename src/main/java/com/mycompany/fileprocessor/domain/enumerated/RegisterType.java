package com.mycompany.fileprocessor.domain.enumerated;

public enum RegisterType {
    SALESMAN("001"), CLIENT("002"), SALE("003");
    
    private final String value;
    
    RegisterType(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
