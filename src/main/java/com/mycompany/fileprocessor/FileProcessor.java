package com.mycompany.fileprocessor;

import com.mycompany.fileprocessor.domain.service.RegisterService;

public class FileProcessor {
    
    public static void main(String[] args) {
        RegisterService service = new RegisterService();
        
        service.register("001ç1234567891234çPedroç50000");
        service.register("001ç3245678865434çPauloç40000.99");
        service.register("002ç2345675434544345çJose da SilvaçRural");
        service.register("002ç2345675433444345çEduardo PereiraçRural");
        service.register("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        service.register("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        
        service.getWorstSalesman();
    }
    
}
