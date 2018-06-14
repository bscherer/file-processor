/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Salesman;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bscherer
 */
public class SalesmanFactoryTest {
    
    public SalesmanFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateSalesmanByString(){
        //001ç1234567891234çPedroç50000
        Salesman expectedSalesman = new Salesman("1234567891234", "Pedro",new BigDecimal(5000));
        String expectedSalesmanRegistry = String.format("001ç%sç%sç%s",
                expectedSalesman.getCpf(),
                expectedSalesman.getName(),
                expectedSalesman.getSalary());
        
        EntityFactory factory = new SalesmanFactory();
        Salesman salesman = (Salesman) factory.create(expectedSalesmanRegistry);
        assertEquals(salesman.getCpf(), expectedSalesman.getCpf());
        assertEquals(salesman.getName(), expectedSalesman.getName());
        assertEquals(salesman.getSalary(), expectedSalesman.getSalary());
        
    }
}
