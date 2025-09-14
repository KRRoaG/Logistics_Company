package com.solvd.logistic.anottation;

@ShippingType("standard")
public class StandardShipping {
    public int shippingPriority(){
        System.out.println("Processing standard shipping");
        return 2;
    }

}
