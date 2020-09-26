package br.com.atividade.lojadejogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private double totalGasto = 0;
    private double desconto = 10;
    NumberFormat formato = NumberFormat.getCurrencyInstance();

    TextView lblTotal;

    public void checkboxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    totalGasto += 159.90;
                else
                    totalGasto -= 159.90;
                break;
            case R.id.checkBox2:
                if (checked)
                    totalGasto += 99.90;
                else
                    totalGasto -= 99.90;
                break;
            case R.id.checkBox3:
                if (checked)
                    totalGasto += 259.90;
                else
                    totalGasto -= 259.90;
                break;
        }

        lblTotal.setText("Total = " + formato.format(totalGasto * (1 - desconto / 100)));
    }

    public void radioButtonClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    desconto = 10;
                break;
            case R.id.radioButton2:
                if (checked)
                    desconto = 5;
                break;
            case R.id.radioButton3:
                if (checked)
                    desconto = 0;
                break;
        }
        lblTotal.setText("Total = " + formato.format(totalGasto * (1 - desconto / 100)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTotal = findViewById(R.id.labelTotal);
    }
}