package br.com.ativade.primeiroprograma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMensagem;
    private EditText editTextTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMensagem(View view) {
        textViewMensagem = findViewById(R.id.textViewMensagem);
        editTextTextNome = findViewById((R.id.editTextTextNome));
        textViewMensagem.setText("Olá mundo - " + editTextTextNome.getText());
    }
}