package br.com.atividade.telas.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.NumberFormat;

import br.com.atividade.telas.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    EditText editTextPeso;
    Spinner spinner;
    Button btnCadastro;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dashboard_fragment, container, false);
        btnCadastro = root.findViewById(R.id.btnCarne);
        btnCadastro.setOnClickListener(this);
        editTextPeso = root.findViewById(R.id.editTextPeso);
        spinner = root.findViewById(R.id.spinner);
        return root;
    }

    @Override
    public void onClick(View v) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        double precoFinal = 0;
        EditText editTextPeso = getActivity().findViewById(R.id.editTextPeso);
        Spinner spinner = getActivity().findViewById(R.id.spinner);
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
        AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
        alerta.setTitle("Preço  a  pagar");
        alerta.setMessage("Valor final  = " + format.format(precoFinal));
        alerta.setNeutralButton("Sair", null);
        alerta.show();
    }
}