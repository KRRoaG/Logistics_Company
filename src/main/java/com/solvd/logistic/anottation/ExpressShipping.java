package com.solvd.logistic.anottation;


@ShippingType("express")
public class ExpressShipping {
    public int shippingPriority(){
        System.out.println("Processing express shipping");
        return 1;
    }
}
