/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileprocessor.domain.factories;

import com.mycompany.fileprocessor.domain.entity.Client;
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
public class ClientFactoryTest {
    
    public ClientFactoryTest() {
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
    public void testCreateClientByString(){
        Client expectedClient = new Client("2345675434544345","Jose da Silva","Rural");
        String expectedClientRegister = String.format("002ç%sç%sç%s", expectedClient.getCnpj(), expectedClient.getName(), expectedClient.getBusinessArea());
        
        EntityFactory factory = new ClientFactory();
        Client client = (Client) factory.create(expectedClientRegister);
        assertEquals(client.getCnpj(), expectedClient.getCnpj());
        assertEquals(client.getName(), expectedClient.getName());
        assertEquals(client.getBusinessArea(), expectedClient.getBusinessArea());
    }
}
