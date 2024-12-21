package com.example.cantina_ifpr;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, Integer> selectedItems = new HashMap<String, Integer>();
    Map<String, Double> itemsValue = new HashMap<String, Double>();

    private CheckBox cbCoxinha, cbDoguinho, cbPaoDeQueijo, cbHamburgao;
    private CheckBox cbCafe200, cbCafe20, cbCoca200, cbCoca1;
    private EditText etCoxinha, etDoguinho, etPaoDeQueijo, etHamburgao;
    private EditText etCafe200, etCafe20, etCoca200, etCoca1;
    private RadioGroup radioGroup;
    private RadioButton rbEntrega, rbRetirar;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        itemsValue.put("Coxinha", 6d);
        itemsValue.put("Hamburgao", 5d);
        itemsValue.put("Pao De Queijo", 6d);
        itemsValue.put("Doguinho", 2d);
        itemsValue.put("Cafe 25", 2.5d);
        itemsValue.put("Cafe 200", 7.5d);
        itemsValue.put("Coca 200" , 3d);
        itemsValue.put("Coca 1", 8d);
        itemsValue.put("Entrega", 20d);


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
                if(cbCoxinha.isChecked()){
                    selectedItems.put("Coxinha", 1);
                    etCoxinha.setText("1");
                } else {
                    etCoxinha.setText("");
                    selectedItems.remove("Coxinha");
                }
                updateTotal();
            }
        });
        etCoxinha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etCoxinha.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Coxinha");
                    updateTotal();
                    return;
                }
                if(!cbCoxinha.isChecked()) cbCoxinha.setChecked(true);
                selectedItems.put("Coxinha", Integer.parseInt(value));
                updateTotal();
            }
        });
        cbDoguinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbDoguinho.isChecked()){
                    selectedItems.put("Doguinho", 1);
                    etDoguinho.setText("1");
                } else {
                    etDoguinho.setText("");
                    selectedItems.remove("Doguinho");
                }
                updateTotal();

            }
        });
        etDoguinho.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etDoguinho.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Doguinho");
                    updateTotal();
                    return;
                }
                selectedItems.put("Doguinho", Integer.parseInt(value));
                if(!cbDoguinho.isChecked()) cbDoguinho.setChecked(true);
                updateTotal();
            }
        });
        cbPaoDeQueijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbPaoDeQueijo.isChecked()){
                    selectedItems.put("Pao De Queijo", 1);
                    etPaoDeQueijo.setText("1");
                } else {
                    etPaoDeQueijo.setText("");
                    selectedItems.remove("Pao De Queijo");
                }
                updateTotal();
            }
        });
        etPaoDeQueijo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etPaoDeQueijo.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Pao De Quejo");
                    updateTotal();
                    return;
                }
                selectedItems.put("Pao De Queijo", Integer.parseInt(value));
                if(!cbPaoDeQueijo.isChecked()) cbPaoDeQueijo.setChecked(true);
                updateTotal();
            }
        });
        cbHamburgao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbHamburgao.isChecked()){
                    selectedItems.put("Hamburgao", 1);
                    etHamburgao.setText("1");
                } else {
                    etHamburgao.setText("");
                    selectedItems.remove("Hamburgao");
                }
                updateTotal();
            }
        });
        etHamburgao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etHamburgao.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Hamburgao");
                    updateTotal();
                    return;
                }
                selectedItems.put("Hamburgao", Integer.parseInt(value));
                if(!cbHamburgao.isChecked()) cbHamburgao.setChecked(true);
                updateTotal();
            }
        });
        cbCafe200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCafe200.isChecked()){
                    selectedItems.put("Cafe 200", 1);
                    etCafe200.setText("1");
                } else {
                    etCafe200.setText("");
                    selectedItems.remove("Cafe 200");
                }
                updateTotal();
            }
        });
        etCafe200.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etCafe200.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Cafe 200");
                    updateTotal();
                    return;
                }
                selectedItems.put("Cafe 200", Integer.parseInt(value));
                if(!cbCafe200.isChecked()) cbCafe200.setChecked(true);
                updateTotal();
            }
        });
        cbCafe20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCafe20.isChecked()){
                    selectedItems.put("Cafe 25", 1);
                    etCafe20.setText("1");
                } else {
                    etCafe20.setText("");
                    selectedItems.remove("Cafe 25");
                }
                updateTotal();
            }
        });
        etCafe20.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etCafe20.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Cafe 25");
                    updateTotal();
                    return;
                }
                selectedItems.put("Cafe 25", Integer.parseInt(value));
                if(!cbCafe20.isChecked()) cbCafe20.setChecked(true);
                updateTotal();
            }
        });
        cbCoca200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCoca200.isChecked()){
                    selectedItems.put("Coca 200", 1);
                    etCoca200.setText("1");
                } else {
                    etCoca200.setText("");
                    selectedItems.remove("Coca 200");
                }
                updateTotal();
            }
        });
        etCoca200.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etCoca200.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Coca 200");
                    updateTotal();
                    return;
                }
                selectedItems.put("Coca 200", Integer.parseInt(value));
                if(!cbCoca200.isChecked()) cbCoca200.setChecked(true);
                updateTotal();
            }
        });
        cbCoca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCoca1.isChecked()){
                    selectedItems.put("Coca 1", 1);
                    etCoca1.setText("1");
                } else {
                    etCoca1.setText("");
                    selectedItems.remove("Coca 1 ");
                }
                updateTotal();
            }
        });
        etCoca1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = etCoca1.getText().toString();
                if(value.isEmpty() || value.equals("0")){
                    selectedItems.remove("Coca 1");
                    updateTotal();
                    return;
                }
                selectedItems.put("Coca 1", Integer.parseInt(value));
                if(!cbCoca1.isChecked()) cbCoca1.setChecked(true);
                updateTotal();
            }
        });

        rbEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbEntrega.isChecked()){
                    selectedItems.put("Entrega", 1);
                    updateTotal();
                }
            }
        });
        rbRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbRetirar.isChecked()){
                    selectedItems.remove("Entrega");
                    updateTotal();
                }
            }
        });
    }
    private void updateTotal()
    {
        double currentTotal = 0;
        for (String k : selectedItems.keySet()){
            currentTotal += (itemsValue.get(k) * selectedItems.get(k));
        }
        tvTotal.setText(String.valueOf(currentTotal));
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

        //Definindo opcoes de quantidade para cada item
        etCoxinha = findViewById(R.id.etCoxinha);
        etDoguinho = findViewById(R.id.etDoguinho);
        etPaoDeQueijo  = findViewById(R.id.etPaoDeQueijo);
        etHamburgao = findViewById(R.id.etHamburgao);
        etCafe200 = findViewById(R.id.etCafe200);
        etCafe20 = findViewById(R.id.etCafe25);
        etCoca200  = findViewById(R.id.etCoca200);
        etCoca1 = findViewById(R.id.etCoca1);

        //Definindo opcoes de frete
        radioGroup = findViewById(R.id.cbContainer);
        rbEntrega  = findViewById(R.id.rbEntrega);
        rbRetirar  = findViewById(R.id.rbRetirar);
    }

}