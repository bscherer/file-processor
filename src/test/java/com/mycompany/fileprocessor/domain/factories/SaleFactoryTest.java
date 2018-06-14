package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Sale;
import com.mycompany.fileprocessor.domain.entity.SaleItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleFactoryTest {

    public SaleFactoryTest() {
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
    public void testCreateSaleByRegistry() {
        //003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
        //003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro

        Sale expectedSale = new Sale(10L, new ArrayList(), "Pedro");
        expectedSale.addItens(new SaleItem(1L, 10L, new BigDecimal(100)));
        expectedSale.addItens(new SaleItem(2L, 30L, new BigDecimal(2.50)));
        expectedSale.addItens(new SaleItem(3L, 40L, new BigDecimal(3.10)));
        String expectedSaleRegistry = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        EntityFactory factory = new SaleFactory();
        Sale sale = (Sale) factory.create(expectedSaleRegistry);
        assertEquals(sale.getId(), expectedSale.getId());
        assertEquals(sale.getSalesmanName(), expectedSale.getSalesmanName());

    }
}
