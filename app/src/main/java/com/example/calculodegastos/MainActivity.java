package com.example.calculodegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtPuntoSalida;
    private EditText txtDestino;
    private EditText txtHoraSalida;
    private EditText txtCombustible;
    private EditText txtDistancia;
    private EditText txtHoraLlegada;
    private EditText txtTotal;
    private Button CalcularTiempo;
    private Button CalcularTotal;

    private void Iniciar(){
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtPuntoSalida = (EditText)findViewById(R.id.txtSalida);
        txtDestino = (EditText)findViewById(R.id.txtDestino);
        txtHoraSalida = (EditText)findViewById(R.id.txtHoraSalida);
        txtCombustible = (EditText)findViewById(R.id.txtCombustible);
        txtDistancia = (EditText)findViewById(R.id.txtDistancia);
        txtHoraLlegada = (EditText)findViewById(R.id.txtHoraLlegada);
        txtTotal = (EditText)findViewById(R.id.txtTotal);

        //Boton
        CalcularTiempo = (Button) findViewById(R.id.btnCalcularTiempo);
        CalcularTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CalcularTiempo();}
        });
        CalcularTotal = (Button)findViewById(R.id.btnTotal);
        CalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CalcularTotal(); }
        });


    }
    private void CalcularTiempo(){
        int dkm = Integer.parseInt(txtDistancia.getText().toString());

        int Seg = (dkm * 3600)/100;
        int Horas = Seg /3600;
        int Min = (Seg - Horas * 3600) / 60;
        int SegR = Seg - Horas *3600 - Min *60;

        txtHoraLlegada.setText(String.valueOf(Horas + "Hora" + Min +"Min" + SegR + "Seg" ));
    }
    private void CalcularTotal(){
        int cc = Integer.parseInt(txtCombustible.getText().toString());
        int dkm = Integer.parseInt(txtDistancia.getText().toString());

        int Rendi = 16;
        int ct = (dkm / Rendi) * cc;

        txtTotal.setText(String.valueOf("$ " + ct + ".00"));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }
}