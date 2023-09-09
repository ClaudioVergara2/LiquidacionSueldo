package com.example.liquidacionsueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText sueldobase, dias, et_bono;
    TextView sueldomensual, et_imponible, et_afp, et_salud, et_descuento,et_total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sueldobase = findViewById(R.id.et_suelobase);
        dias = findViewById(R.id.et_diastra);
        sueldomensual = findViewById(R.id.tx_sueldoMensual);

        et_bono = findViewById(R.id.et_bonos);
        et_imponible = findViewById(R.id.tx_imponible);
        et_afp = findViewById(R.id.tx_afp);
        et_salud = findViewById(R.id.tx_salud);
        et_descuento = findViewById(R.id.tx_descuento);
        et_total = findViewById(R.id.tx_total);
    }

    public void CalcularSuelo(View view){
        //dejar el textView vacio para que no quede datos erroneos
        sueldomensual.setText("SUELDO MENSUAL:");

        //validar si hay datos en sueldo base y dias trabajados
        boolean error = false;
        if(sueldobase.getText().toString().length() == 0) {
            sueldobase.setError("Debe ingresar el suelo base");
            error = true;
        }
        if(dias.getText().toString().length() == 0) {
            dias.setError("Debe ingresar dias trabajos");
            error = true;
        }
        if(error) return; //si ocurre un error, detengo la ejecucion con return;

        base = Double.valueOf(sueldobase.getText().toString());
        ditra = Integer.valueOf(dias.getText().toString());

        error = false;
        if(base < 326500) {
            sueldobase.setError("Debe ser mayor o igual a 326500");
            error = true;
        }
        if(ditra < 0 || ditra > 30) {
            dias.setError("Debe estar entre 0 y 30");
            error = true;
        }
        if(error) return;

        double sueldo = base/30 * ditra;
        sueldomensual.setText("SUELDO MENSUAL:  "+ Math.round(sueldo));
    }

    double base, sueldomen, imponible = 0, bono = 0, afp, salud, desctos, total;
    int ditra;
    public void CalcularImponible(View view){
        if(et_bono.getText().length()>0){
            bono = Double.valueOf(et_bono.getText().toString());
        }
        if(bono > sueldomen * 0.5){
            et_bono.setError("bono supera lo permitido");
            return;
        }
        imponible = sueldomen + bono;
        et_imponible.setText("SUELDO IMPONIBLE: "+ String.format("%.Of", imponible));
        afp = imponible * 0.13;
        et_afp.setText("13% AFP: "+ String.format("%.Of", afp));
        salud = imponible * 0.7;
        et_salud.setText("7% SALUD: "+ String.format("%.Of", salud));
        desctos = afp + salud;
        et_descuento.setText("TOTAL DESCUENTOS: "+ String.format("%.Of", desctos));
        total = imponible - desctos;
        et_descuento.setText("TOTAL A PAGAR: "+ String.format("%.Of", total));
    }

    public void Reset(View view){
        sueldomen = 0;
        ditra = 0;
        bono = 0;
        imponible = 0;
        afp = 0;
        salud = 0;
        desctos = 0;
        total = 0;
        sueldobase.setText("");
        dias.setText("");
        et_bono.setText("");
        sueldomensual.setText("SUELDO MENSUAL:");
        et_imponible.setText("SUELDO IMPONIBLE:");
        et_afp.setText("13% AFP:");
        et_salud.setText("7% SALUD:");
        et_descuento.setText("TOTAL DESCUENTOS:");
        et_total.setText("TOTAL A PAGAR:");
    }
}