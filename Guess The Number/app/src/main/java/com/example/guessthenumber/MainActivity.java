package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtKalanHak, txtSonuc;
    private EditText editTxtSayi;
    private String gelenDeger;
    private Button restartButton, checkButton;
    private int kalanHak = 3, randomSayi;
    private Random rndNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak = (TextView)findViewById(R.id.txtViewKalanHak);
        txtSonuc = (TextView)findViewById(R.id.txtViewSonuc);
        editTxtSayi = (EditText)findViewById(R.id.editTxtSayi);
        restartButton = (Button)findViewById(R.id.btnRestart);
        checkButton = (Button)findViewById(R.id.btnTahminEt);

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(10);
        System.out.println("\nRandom Sayı: \n" + randomSayi);
    }

    public void btnTahminEt(View v)
    {
        gelenDeger = editTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger))
        {
            if (kalanHak > 0)
            {
                if (gelenDeger.equals(String.valueOf(randomSayi)))
                {
                    sonucGoster("Good Job! You are excellent.");
                    v.setEnabled(false);
                    restartButton.setVisibility(View.VISIBLE);
                    checkButton.setEnabled(false);
                }
                else
                {
                    kalanHak--;
                    txtSonuc.setText("Wrong!");
                }

                txtKalanHak.setText("Kalan Hak: " + kalanHak);
                if (kalanHak == 0) {
                    sonucGoster("Game Over!\nThe Number is: " + randomSayi);
                    restartButton.setVisibility(View.VISIBLE);
                }
            }
            else
                txtSonuc.setText("Game ended.");
        }
        else
            txtSonuc.setText("Please enter value!");
    }

    public void btnRestart(View v)
    {
        kalanHak = 3;
        txtKalanHak.setText("Kalan Hak: " + kalanHak);
        randomSayi = rndNumber.nextInt(5);
        checkButton.setEnabled(true);
        editTxtSayi.setText("");
        editTxtSayi.setEnabled(true);
        txtSonuc.setText("");
        restartButton.setVisibility(View.GONE);
        System.out.println("\nRandom Sayı: " + randomSayi + "\n");
    }

    private void sonucGoster(String message)
    {
        editTxtSayi.setEnabled(false);
        checkButton.setEnabled(false);
        txtSonuc.setText(message);
    }
}