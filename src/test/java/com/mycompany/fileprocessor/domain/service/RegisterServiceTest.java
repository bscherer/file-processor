package com.mycompany.fileprocessor.domain.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterServiceTest {

    private static List<String> lines;
    private static RegisterService service;
    
    public RegisterServiceTest() {

    }

    @BeforeClass
    public static void setUpClass() {
         service = new RegisterService();
        
        lines = new ArrayList();
        lines.add("001ç1234567891234çPedroç50000");
        lines.add("001ç3245678865434çPauloç40000.99");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("002ç2345675433444345çEduardo PereiraçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        service.registerAll(lines);
    }

    @After
    public void tearDown() {
        service.clear();
    }

    @Test
    public void testClientsRegisterHasBeenCreated() {        
        assertEquals(service.getClients().size(), 2);
    }
    
    @Test
    public void testSalesmenHasBeenCreated(){
        assertEquals(service.getSalesmen().size(), 2);
    }

    @Test
    public void testSalesHasBeenCreated() {
        assertEquals(service.getSales().size(), 2);
    }
    
    @Test
    public void testGetMostExpensiveSaleId(){
        assertEquals(service.getMostExpensiveSaleId(), new Long(10));
    }
    
    @Test
    public void testGetWorstSalesman() {
        assertEquals(service.getWorstSalesman(), "Paulo");
    }
    
    @Test
    public void testGetReportResult(){
        assertEquals(service.getReportResult(),"2ç2ç10çPaulo");
    }
}
