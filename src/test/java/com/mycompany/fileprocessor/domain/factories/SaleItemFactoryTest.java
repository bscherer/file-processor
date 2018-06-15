package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.SaleItem;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleItemFactoryTest {
    
    public SaleItemFactoryTest() {
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
    public void testCreateSaleItemByString(){
    //[Item ID-Item Quantity-Item Price]
    //[1-10-100,2-30-2.50,3-40-3.10]
        SaleItem expectedSaleItem = new SaleItem(1L,10L,new BigDecimal(100));
        String expectedSaleItemRegister = String.format("%s-%s-%s",
                expectedSaleItem.getId().toString(),
                expectedSaleItem.getQuantity().toString(),
                expectedSaleItem.getUnitPrice().toString());
        EntityFactory factory = new SaleItemFactory();
        SaleItem saleItem = (SaleItem)factory.create(expectedSaleItemRegister);
        assertEquals(saleItem.getId(), expectedSaleItem.getId());
        assertEquals(saleItem.getQuantity(), expectedSaleItem.getQuantity());
        assertEquals(saleItem.getUnitPrice(), expectedSaleItem.getUnitPrice());
        
    }
}
