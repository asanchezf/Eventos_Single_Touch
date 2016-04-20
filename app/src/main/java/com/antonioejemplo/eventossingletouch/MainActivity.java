package com.antonioejemplo.eventossingletouch;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
/*PARA CONTROLAR LOS EVENTOS QUE SE PRODUCEN SOBRE LA PANTALLA TACTIL DEL DISPOSITIVO SE UTILIZA
* LA INTERFAZ OnTouchListener. ES OBLIGATORIO SOBREESCRIBIR EL MÉTODO onTouch(). En este método
* se podrá saber qué método/acción se está desencadenando...*/

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView textoprueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoprueba=(TextView)findViewById(R.id.txtprueba);

        //Se implementa la Interfaz. Se utiliza un manejador genérico: Delegate...
        textoprueba.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
    //Este método es obligatorio pq impoementamos la interfaz OntouchListener.

         //Para saber qué tipo de evento se está desencadenando;
        int accion= MotionEventCompat.getActionMasked(event);
        int coordenadaX= (int) event.getX();
        int coordenadaY= (int) event.getY();

        switch (accion){

            //Al pulsar por primera vez en la pantalla con el dedo
            case MotionEvent.ACTION_DOWN:
                textoprueba.setText("La pulsación ACTION_DOWN está en las coordenadas: "+" X="+coordenadaX+" Y:"+coordenadaY);
             return true;

            //Una vez que se ha pulsado en la pantalla nos movemos con el dedo
            case MotionEvent.ACTION_MOVE:
                textoprueba.setText("La pulsación ACTION_MOVE está en las coordenadas: "+" X="+coordenadaX+" Y:"+coordenadaY);
                return true;

            //Una vez que levantamos el dedo de la pantalla.
            case MotionEvent.ACTION_UP:
                textoprueba.setText("La pulsación ACTION_UP está en las coordenadas: "+" X="+coordenadaX+" Y:"+coordenadaY);
                return true;

            //Al cancelar un movimiento en mitad
            case MotionEvent.ACTION_CANCEL:
                textoprueba.setText("La pulsación ACTION_CANCEL está en las coordenadas: "+" X="+coordenadaX+" Y:"+coordenadaY);
                return true;

            //Movimiento en los límites externos del objeto
            case MotionEvent.ACTION_OUTSIDE:
                textoprueba.setText("La pulsación ACTION_OUTSIDE está en las coordenadas: "+" X="+coordenadaX+" Y:"+coordenadaY);
                return true;

            default:
            return true;




        }




    }
}
