package edu.illinois.cs.cs125.mp7_zhaohan2;

public class CurrencyRateFromAPI {


    public CurrencyRateFromAPI() {
    }

    public float getRate(final String currency1, final String currency2) {
        float rate = 1;
        if (currency1 == null || currency2 == null) {
            return 0;
        } else if (currency1 == currency2) {
            return rate;
        } else {
            //rate = get ratio from API
        }
        return rate;
    }
}
