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


    ArrayAdapter<String> adapter;

    String currencys[] = {"USD", "CHY", "EUR", "JPY", "AUD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "App Started");

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
                    rate.setText(String.valueOf(ratio));
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
                    rate.setText(String.valueOf(ratio));
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
                Log.d(TAG, "Button clicked");
                if (findViewById(R.id.OriginalNumber).toString() != null) {
                    originalAmount = Integer.valueOf(originalNumber.getText().toString());
                    CurrencyRateFromAPI calculator = new CurrencyRateFromAPI();
                    ratio = calculator.getRate(originalCurrency,targetCurrency);
                    targetAmount = originalAmount * ratio;
                    tgt.setText(String.valueOf(targetAmount));
                }
            }
        });

    }
}
