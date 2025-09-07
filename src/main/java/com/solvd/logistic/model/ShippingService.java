package com.solvd.logistic.model;

import com.solvd.logistic.service.Shipping;
import com.solvd.logistic.exceptions.ShippingNotFoundException;

import java.util.List;

public class ShippingService {
    private List<Shipping> shippings;

    public ShippingService(List<Shipping> shippings){
        this.shippings = shippings;
    }

    public Shipping findShippingByNumber (String number) throws ShippingNotFoundException{
        for (Shipping s : shippings){
            if (s.getPack().getShipNumber().equals(number)){
                return s;
            }
        }
        throw new ShippingNotFoundException("The shipment with number  " + number + " was not found");
    }

}
