package com.mycompany.fileprocessor.domain.service;

import com.mycompany.fileprocessor.domain.entity.Client;
import com.mycompany.fileprocessor.domain.entity.Entity;
import com.mycompany.fileprocessor.domain.entity.Sale;
import com.mycompany.fileprocessor.domain.entity.SaleItem;
import com.mycompany.fileprocessor.domain.entity.Salesman;
import com.mycompany.fileprocessor.domain.factories.ClientFactory;
import com.mycompany.fileprocessor.domain.factories.EntityFactory;
import com.mycompany.fileprocessor.domain.factories.SaleFactory;
import com.mycompany.fileprocessor.domain.factories.SalesmanFactory;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterService {

    private List<Entity> registers;

    public RegisterService() {
        registers = new ArrayList();
    }

    public void registerAll(List<String> lines){
        lines.stream().forEach(line -> register(line));
    }
    public void register(String line) {
        EntityFactory factory = getCorrespondentFactory(line);
        registers.add(factory.create(line));
    }

    public void clear(){
        registers.clear();
    }
    
    public List<Client> getClients() {
        return registers.stream()
                .filter(reg -> reg instanceof Client)
                .map(reg -> (Client) reg)
                .collect(Collectors.toList());
    }
    
    public List<Salesman> getSalesmen() {
        return registers.stream()
                .filter(reg -> reg instanceof Salesman)
                .map(reg -> (Salesman) reg)
                .collect(Collectors.toList());
    }
    
    public List<Sale> getSales() {
        return registers.stream()
                .filter(reg -> reg instanceof Sale)
                .map(reg -> (Sale) reg)
                .collect(Collectors.toList());
    }

    public Long getMostExpensiveSaleId() {
        BigDecimal mostExpensivePrice = BigDecimal.ZERO;
        Long mostExpensiveSaleId = 0L;
        List<Sale> sales = getSales();
        for (Sale sale : sales) {
            BigDecimal purchaseTotal = purchaseTotal(sale);
            if (mostExpensivePrice.compareTo(purchaseTotal) <= 0) {
                mostExpensiveSaleId = sale.getId();
                mostExpensivePrice = purchaseTotal;
            }
        }
        return mostExpensiveSaleId;
    }
    
    public String getWorstSalesman(){
        List<Sale> sales = getSales();
        BigDecimal worstSalePrice = purchaseTotal(sales.get(0));
        Sale worstSale = sales.get(0);
        for(Sale sale : sales) {
            if(worstSalePrice.compareTo(purchaseTotal(sale)) < 0){
            } else {
                worstSalePrice = purchaseTotal(sale);
                worstSale = sale;
            }
        }
        
        return worstSale.getSalesmanName();
    }
    
    public String getReportResult(){
        return String.format("%dç%dç%02dç%s", 
                getClients().size(),
                getSalesmen().size(),
                getMostExpensiveSaleId(),
                getWorstSalesman()
                );
    }

    private EntityFactory getCorrespondentFactory(String line) {
        String type = line.substring(0, 3);
        EntityFactory factory;

        switch (type) {
            case "001":
                factory = new SalesmanFactory();
                break;
            case "002":
                factory = new ClientFactory();
                break;
            case "003":
                factory = new SaleFactory();
                break;
            default:
                throw new InvalidParameterException("Registro inválido");
        }
        return factory;
    }

    private BigDecimal purchaseTotal(Sale sale) {
        BigDecimal purchaseTotal = BigDecimal.ZERO;
        for (SaleItem item : sale.getItems()) {
            purchaseTotal = purchaseTotal.add(item.getPrice());
        }
        return purchaseTotal;
    }
}
