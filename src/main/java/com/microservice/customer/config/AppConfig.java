package com.microservice.customer.config;

import java.util.ArrayList;
import java.util.List;

enum CustomerType {

    PERSONAL("PERSONAL"), EMPRESARIAL("EMPRESARIAL"), 
    PERSONAL_VIP("PERSONAL_VIP"), EMPRESARIAL_PYME("EMPRESARIAL_PYME");

    private String type;

    CustomerType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}


public class AppConfig {

    public List<String> getCustomerTypes(){
        List<String> types = new ArrayList<>();
        CustomerType[] customerTypes = CustomerType.values();
        for (CustomerType type:customerTypes){
            types.add(type.getType());
        }
        return  types;
    }


}
