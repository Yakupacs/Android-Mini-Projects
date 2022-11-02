package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstNumber, editTextSecondNumber;
    private TextView textViewSonuc;
    private String s1, s2;
    private float num1, num2, result;
    private Calculate calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFirstNumber = (EditText)findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = (EditText)findViewById(R.id.editTextSecondNumber);
        textViewSonuc = (TextView)findViewById(R.id.textViewSonuc);
    }

    public void btnHesapla(View button)
    {
        s1 = editTextFirstNumber.getText().toString();
        s2 = editTextSecondNumber.getText().toString();

        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2))
        {
            num1 = Float.valueOf(s1);
            num2 = Float.valueOf(s2);

            calculate = new Calculate(num1, num2);

            switch (button.getId())
            {
                case R.id.buttonToplama:
                    result = calculate.result("+");
                    break;
                case R.id.buttonEksi:
                    result = calculate.result("-");
                    break;
                case R.id.buttonCarpim:
                    result = calculate.result("*");
                    break;
                case R.id.buttonBolum:
                    result = calculate.result("/");
            }
            textViewSonuc.setText("Result: " + result);

        }
        else
            textViewSonuc.setText("Must enter two numbers!");
    }
}