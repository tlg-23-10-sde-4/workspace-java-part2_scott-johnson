package com.javatunes.billing;

public class TaxCalculatorFactory {

    // prevent instantiation from outside, this is an all-static class


    private TaxCalculatorFactory() {
    }


    /*
     *Consider implementing a 'cache' of TaxCalculator objects;
     * if i have not previously created the object i.e (USATax) then
     * ill creat it here , with new, add it to my cache, and return it
     *
     * however if my cache already contains it. then i just fetch it from the cache
     * and return it. no need to create another one
     *
     * HINT: you could use a simple Map<Location, TaxCalculator> for the cache.
     * it would be a 3-row Map, each row has Location and TaxCalculator
     */
    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
                break;
        }

        return calc;
    }
}