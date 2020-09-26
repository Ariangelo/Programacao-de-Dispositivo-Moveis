package br.com.atividade.lojadecarnes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public void clickBtnCalcular(View view) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        double precoFinal = 0;
        EditText editTextPeso = findViewById(R.id.editTextPeso);
        Spinner spinner = findViewById(R.id.spinner);
        double peso = Double.parseDouble(editTextPeso.getText().toString());
        switch (spinner.getSelectedItemPosition()) {
            case 0: precoFinal = peso * 4.6;
                break;
            case 1: precoFinal = peso * 30;
                break;
            case 2: precoFinal = peso * 11.5;
                break;
            case 3: precoFinal = peso * 17.8;
                break;
            default:
                break;
        }
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Preço  a  pagar");
        alerta.setMessage("Valor final  = " + format.format(precoFinal));
        alerta.setNeutralButton("Sair", null);
        alerta.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}