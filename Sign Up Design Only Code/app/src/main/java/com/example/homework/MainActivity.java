package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import android.text.Layout;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.CharSequence;
import java.util.Locale;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private LinearLayout bodyContainer;
    private LinearLayout adEditTextContainer;
    private LinearLayout soyadEditTextContainer;
    private LinearLayout buttonContainer;
    private LinearLayout textViewContainer;
    private Button kaydetButton;
    private TextView infoTextView;
    private EditText adEditText;
    private EditText soyadEditText;
    private String ad, soyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFunc();
        addViewFunc();
    }

    private void initFunc()
    {
        // CONTAINERS INIT
        bodyContainer = new LinearLayout(this);
        adEditTextContainer = new LinearLayout(this);
        soyadEditTextContainer = new LinearLayout(this);
        buttonContainer = new LinearLayout(this);
        textViewContainer = new LinearLayout(this);

        bodyContainer.setOrientation(LinearLayout.VERTICAL);
        adEditTextContainer.setOrientation(LinearLayout.HORIZONTAL);
        soyadEditTextContainer.setOrientation(LinearLayout.HORIZONTAL);
        buttonContainer.setOrientation(LinearLayout.HORIZONTAL);
        textViewContainer.setOrientation(LinearLayout.HORIZONTAL);

        LayoutParams paramsBody = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        LayoutParams paramsAd = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT); // yataylamasına match parent, dikeylemesine wrap content
        LayoutParams paramsSoyad = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LayoutParams paramsButton = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LayoutParams paramsTextView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        bodyContainer.setGravity(Gravity.CENTER_VERTICAL);
        adEditTextContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        soyadEditTextContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        buttonContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        textViewContainer.setGravity(Gravity.CENTER_HORIZONTAL);

        bodyContainer.setLayoutParams(paramsBody);
        adEditTextContainer.setLayoutParams(paramsAd);
        soyadEditTextContainer.setLayoutParams(paramsSoyad);
        buttonContainer.setLayoutParams(paramsButton);
        textViewContainer.setLayoutParams(paramsTextView);


        // EDIT TEXTS INIT
        adEditText = new EditText(this);
        soyadEditText = new EditText(this);

        LayoutParams paramsAdText = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LayoutParams paramsSoyadText = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        adEditText.setLayoutParams(paramsAdText);
        adEditText.setBackgroundColor(Color.RED);
        adEditText.setTextColor(Color.BLACK);
        adEditText.setTextSize(20);
        adEditText.setHint("Adınızı Giriniz");
        adEditText.setBackgroundResource(android.R.drawable.edit_text);

        soyadEditText.setLayoutParams(paramsSoyadText);
        soyadEditText.setBackgroundColor(Color.RED);
        soyadEditText.setTextColor(Color.BLACK);
        soyadEditText.setTextSize(20);
        soyadEditText.setHint("Soyadınızı Giriniz");
        soyadEditText.setBackgroundResource(android.R.drawable.edit_text);


        // TEXTVIEW INIT
        infoTextView = new TextView(this);

        LayoutParams paramsTextView2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        infoTextView.setLayoutParams(paramsTextView2);
        infoTextView.setTextColor(Color.RED);
        infoTextView.setTextSize(25);
        infoTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        // BUTTONS INIT
        kaydetButton = new Button(this);

        LayoutParams paramsButton2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        kaydetButton.setLayoutParams(paramsButton2);

        String kaydet = kaydetButton.getText().toString();
        kaydetButton.setText("Kayıt Ol");
        kaydetButton.setBackgroundColor(Color.parseColor("#4caf50"));
        kaydetButton.setTextColor(Color.WHITE);
        kaydetButton.setTextSize(25);
        kaydetButton.setPadding(50,10,50,10);
        kaydetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                printInfoMessage();
            }
        });
    }

    private void addViewFunc()
    {
        setContentView(bodyContainer);
        bodyContainer.addView(adEditTextContainer);
        bodyContainer.addView(soyadEditTextContainer);
        bodyContainer.addView(buttonContainer);
        bodyContainer.addView(textViewContainer);
        adEditTextContainer.addView(adEditText);
        soyadEditTextContainer.addView(soyadEditText);
        buttonContainer.addView(kaydetButton);
        textViewContainer.addView(infoTextView);
    }

    private void printInfoMessage()
    {
        if (!(adEditText.getText().toString().isEmpty() && soyadEditText.getText().toString().isEmpty())) {
            ad = adEditText.getText().toString().substring(0, 1).toUpperCase(Locale.ROOT) + adEditText.getText().toString().substring(1).toLowerCase(); // Ad
            soyad = soyadEditText.getText().toString().toUpperCase(Locale.ROOT);// SOYAD
            infoTextView.setText("\nKaydınız Gerçekleşti: " + ad + " " + soyad);
            Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show();
            ad = "";
            soyad = "";
            adEditText.setText("");
            soyadEditText.setText("");
        }
        else
        {
            infoTextView.setText("Lütfen ad veya soyad giriniz!");
            Toast.makeText(getApplicationContext(), "Lütfen ad veya soyad giriniz!", Toast.LENGTH_LONG).show();
        }
    }
}