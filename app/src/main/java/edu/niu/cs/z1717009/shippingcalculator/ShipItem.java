package edu.niu.cs.z1717009.shippingcalculator;

/**
 * Created by z1717009 on 2/2/2016.
 */
public class ShipItem {

    // Constants
    static final double BASE_AMOUNT = 3;
    static final double ADDITIONAL_COST = 0.50;
    static final int BASE_WEIGHT=16;
    static final double EXTRA_OUNCES=4;

    // Instance Variables

    private Integer weight;
    private double baseCost,addedCost,shippingCost;

    // Constructor
    public ShipItem(){
        weight = 0;
        baseCost = BASE_AMOUNT;
        addedCost = 0;
        shippingCost = 0.0;
    }

    public void setWeight( int newWeight) {
        weight = newWeight;
        computeCost();
    }

    public void computeCost() {
        addedCost = 0.0;
        baseCost = BASE_AMOUNT;

        if(baseCost<=0) {
            baseCost = 0;
        }
        else if (weight>BASE_WEIGHT){
            addedCost = (Math.ceil( (double)(weight-BASE_WEIGHT)/EXTRA_OUNCES ))* ADDITIONAL_COST;
        }
        shippingCost = baseCost+addedCost;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getAddedCost() {
        return addedCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

}
