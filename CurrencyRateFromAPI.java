package edu.illinois.cs.cs125.mp7_zhaohan2;

import java.net.URI;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




public class CurrencyRateFromAPI {



    public CurrencyRateFromAPI() {
    }

    String webpage = "https://free.currencyconverterapi.com/api/v5/convert";



    public float getRate(final String currency1, final String currency2) {
        float rate = 1;
        if (currency1 == null || currency2 == null) {
            return 0;
        } else if (currency1 == currency2) {
            return rate;
        } else {
            /*
            try {

                URIBuilder builder = new URIBuilder(webpage);

                String parameter1 = currency1 + "_" + currency2;
                builder.setParameter("q", currency1 + "_" + currency2 );
                builder.setParameter("compact", "y");

                URI uri = builder.build();
                System.out.println(uri);
                HttpPost request = new HttpPost(uri);

                HttpResponse response = httpclient.execute(request);
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    // Format and display the JSON response.
                    String jsonString = EntityUtils.toString(entity);
                    JsonParser parser = new JsonParser();
                    JsonObject rootObj = parser.parse(jsonString).getAsJsonObject();
                    JsonObject locObj = rootObj.getAsJsonObject(parameter1);
                    rate = locObj.get("val").getAsFloat();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //rate = get ratio from API*/
        }

        return rate;
    }
}
