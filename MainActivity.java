package edu.illinois.cs.cs125.mp7_zhaohan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity{

    int originalAmount, targetAmount, ratio;
    String originalCurrency, targetCurrency;

    EditText originalAmountInput;
    Spinner originalCurrencyInput;
    Spinner targetCurrencyInput;
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Currency, android.R.layout.simple_spinner_dropdown_item);


    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originalAmountInput = findViewById(R.id.OriginalNumber);
        originalCurrencyInput = findViewById(R.id.OriginalCurrency);
        targetCurrencyInput = findViewById(R.id.TargetCurrency);
        originalCurrencyInput.setAdapter(adapter);
        targetCurrencyInput.setAdapter(adapter);
        originalCurrencyInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                originalCurrency = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        targetCurrencyInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                targetCurrency = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertButton = findViewById(R.id.Convert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalAmount = Integer.valueOf(originalAmountInput.getText().toString());
            }
        });
    }
}
