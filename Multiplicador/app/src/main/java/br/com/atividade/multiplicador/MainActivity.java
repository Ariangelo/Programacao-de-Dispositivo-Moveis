package br.com.atividade.multiplicador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickBtnMultiplicar(View view) {

        EditText numero1 = findViewById(R.id.editTextNumero1);
        EditText numero2 = findViewById(R.id.editTextNumero2);

        double num1 = Double.parseDouble(numero1.getText().toString());
        double num2 = Double.parseDouble(numero2.getText().toString());

        double resultado = num1 * num2;

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Informação");
        alerta.setMessage("Valor da multiplicação = " + resultado);
        alerta.setNeutralButton("Sair", null);
        alerta.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}