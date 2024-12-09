package com.example.cantina_ifpr;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCoxinha, cbDoguinho, cbPaoDeQueijo, cbHamburgao;
    private CheckBox cbCafe200, cbCafe20, cbCoca200, cbCoca1;
    private TextView tvTotal;
    private double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setDefaultValues();
        setDefaultListeners();

    }

    private void setDefaultListeners()
    {
        cbCoxinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCoxinha.isChecked()) total += 6;
                else total -= 6;
                updateTotal();

            }
        });
        cbDoguinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbDoguinho.isChecked()) total += 2;
                else total -= 2;
                updateTotal();

            }
        });
        cbPaoDeQueijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbPaoDeQueijo.isChecked()) total += 6;
                else total -= 6;
                updateTotal();

            }
        });
        cbHamburgao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbHamburgao.isChecked()) total += 5;
                else total -= 5;
                updateTotal();

            }
        });
        //private CheckBox cbCafe200, cbCafe20, cbCoca200, cbCoca1;
        cbCafe200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCafe200.isChecked()) total += 7;
                else total -= 7;
                updateTotal();

            }
        });
        cbCafe20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCafe20.isChecked()) total += 2.5;
                else total -= 2.5;
                updateTotal();

            }
        });
        cbCoca200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCoca200.isChecked()) total += 3;
                else total -= 3;
                updateTotal();
            }
        });
        cbCoca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCoca1.isChecked()) total += 7.5;
                else total -= 7.5;
            }
        });
    }

    private void updateTotal()
    {
        tvTotal.setText(String.valueOf(total));
    }


    private void setDefaultValues()
    {
        cbCoxinha = findViewById(R.id.cbCoxinha);
        cbDoguinho = findViewById(R.id.cbDoguinho);
        cbPaoDeQueijo = findViewById(R.id.cbPaodeQueijo);
        cbHamburgao = findViewById(R.id.cbHamburgao);
        cbCafe20 = findViewById(R.id.cbCafe20);
        cbCafe200 = findViewById(R.id.cbCafe200);
        cbCoca200 = findViewById(R.id.cbCoca200);
        cbCoca1 = findViewById(R.id.cbCoca1);
        tvTotal = findViewById(R.id.textViewTotalValue);
    }

}