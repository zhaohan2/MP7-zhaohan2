package edu.illinois.cs.cs125.mp7_zhaohan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Spinner originalCurrencyInput, targetCurrencyInput;
    String originalCurrency;
    String targetCurrency;
    Button convertButton;
    EditText originalNumber;
    float originalAmount;
    float targetAmount;
    float ratio;
    TextView tgt;
    TextView rate;
    String parameter1 = "USD_USD";
    String webpage =
            "https://free.currencyconverterapi.com/api/v5/convert?q=USD_USD&compact=y";

    public static RequestQueue requestQueue;


    public static JsonObjectRequest objectRequest;


    public static String webpage0;

    ArrayAdapter<String> adapter;

    String currencys[] = {"USD", "CNY", "EUR", "JPY", "AUD", "TWD", "HKD", "CAD"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "App Started");

        webpage0 = "https://free.currencyconverterapi.com/api/v5/convert?q=";

        requestQueue = Volley.newRequestQueue(this);





        tgt = findViewById(R.id.TargetNumber);
        rate = findViewById(R.id.Rate);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, currencys);

        originalCurrencyInput = findViewById(R.id.OriginalCurrency);
        targetCurrencyInput = findViewById(R.id.TargetCurrency);

        originalCurrencyInput.setAdapter(adapter);
        targetCurrencyInput.setAdapter(adapter);
        originalCurrencyInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                originalCurrency = parent.getItemAtPosition(position).toString();
                if (originalCurrency == targetCurrency) {
                    ratio = 1;
                }
                if (originalCurrency != null && targetCurrency != null) {
                    parameter1 = originalCurrency + "_" + targetCurrency;
                    webpage = webpage0 + parameter1 + "&compact=y";
                    objectRequest = new JsonObjectRequest(
                            Request.Method.GET,
                            webpage,
                            null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.e("REST response", response.toString());
                                    Log.e("parameter1", parameter1);
                                    Log.e("originalAmount", String.valueOf(originalAmount));
                                    Log.e("finalAmount", String.valueOf(targetAmount));
                                    //try {
                                    // Format and display the JSON response.
                                    String jsonString = response.toString();
                                    JsonParser parser = new JsonParser();
                                    JsonObject rootObj = parser.parse(jsonString).getAsJsonObject();
                                    JsonObject root2Obj = rootObj.get(parameter1).getAsJsonObject();
                                    ratio = root2Obj.get("val").getAsFloat();
                                    rate.setText(String.valueOf(ratio));
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("REST response", error.toString());
                                }
                            });


                    RequestQueue mQueue = requestQueue;
                    mQueue.add(objectRequest);
                    Log.e("URL", webpage);
                    Log.e("Rate", String.valueOf(ratio));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        targetCurrencyInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                targetCurrency = parent.getItemAtPosition(position).toString();
                if (originalCurrency == targetCurrency) {
                    ratio = 1;
                }
                if (originalCurrency != null && targetCurrency != null) {
                    parameter1 = originalCurrency + "_" + targetCurrency;
                    webpage = webpage0 + parameter1 + "&compact=y";
                    objectRequest = new JsonObjectRequest(
                            Request.Method.GET,
                            webpage,
                            null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.e("REST response", response.toString());
                                    Log.e("parameter1", parameter1);
                                    Log.e("originalAmount", String.valueOf(originalAmount));
                                    Log.e("finalAmount", String.valueOf(targetAmount));
                                    //try {
                                    // Format and display the JSON response.
                                    String jsonString = response.toString();
                                    JsonParser parser = new JsonParser();
                                    JsonObject rootObj = parser.parse(jsonString).getAsJsonObject();
                                    JsonObject root2Obj = rootObj.get(parameter1).getAsJsonObject();
                                    ratio = root2Obj.get("val").getAsFloat();
                                    rate.setText(String.valueOf(ratio));
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("REST response", error.toString());
                                }
                            });


                    RequestQueue mQueue = requestQueue;
                    mQueue.add(objectRequest);
                    Log.e("URL", webpage);
                    Log.e("Rate", String.valueOf(ratio));
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        originalNumber = findViewById(R.id.OriginalNumber);



        convertButton = findViewById(R.id.Convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(TAG, "Button clicked");
                    if (findViewById(R.id.OriginalNumber).toString() != null) {

                        originalAmount = Float.parseFloat(originalNumber.getText().toString());

                        /*objectRequest = new JsonObjectRequest(
                                Request.Method.GET,
                                webpage,
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Log.e("REST response", response.toString());
                                        Log.e("parameter1", parameter1);
                                        Log.e("originalAmount", String.valueOf(originalAmount));
                                        Log.e("finalAmount", String.valueOf(targetAmount));
                                        //try {
                                        // Format and display the JSON response.
                                        String jsonString = response.toString();
                                        JsonParser parser = new JsonParser();
                                        JsonObject rootObj = parser.parse(jsonString).getAsJsonObject();
                                        JsonObject root2Obj = rootObj.get(parameter1).getAsJsonObject();
                                        ratio = root2Obj.get("val").getAsFloat();
                                        rate.setText(String.valueOf(ratio));*/
                                        originalAmount = Integer.valueOf(originalNumber.getText().toString());
                                        targetAmount = originalAmount * ratio;
                                        tgt.setText(String.valueOf(targetAmount));
                                        /*Log.e("json", jsonString);
                                        Log.e("ratio",String.valueOf(ratio));
                        /*} catch (NullPointerException e) {
                            Log.d("API", "Nurupo");
                        }*/
                                  /*  }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.e("REST response", error.toString());
                                    }
                                });


                        RequestQueue mQueue = requestQueue;
                        mQueue.add(objectRequest);*/
                    }
                } catch (NullPointerException e) {
                    Log.d("click", "Nurupo");
                }
            }
        });

    }
}
