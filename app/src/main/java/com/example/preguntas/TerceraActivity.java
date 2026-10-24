package com.example.preguntas;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TerceraActivity extends AppCompatActivity {


    int posicion;
    Pregunta preguntaActual;

    TextView txtIndice;
    TextView txtPregunta;

    Button btna;
    Button btnb;
    Button btnc;
    Button btnd;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        //Referencia a las vistas
        txtIndice = findViewById(R.id.txtIndice);
        txtPregunta = findViewById(R.id.txtPregunta);

        btna = findViewById(R.id.btna);
        btnb = findViewById(R.id.btnb);
        btnc = findViewById(R.id.btnc);
        btnd = findViewById(R.id.btnd);
        btnVolver = findViewById(R.id.btnVolver);


        //Recibo la información por Intent
        posicion = getIntent().getIntExtra("posicion", 0);
        preguntaActual = SegundaActivity.listaPreguntas.get(posicion);


        Log.d("Andrea", "JUSTO ANTES DE PINTAR -> posicion: " + posicion);
        Log.d("Andrea", "JUSTO ANTES DE PINTAR -> preguntaActual: " + preguntaActual.getEnunciadoPregunta());

        //Muestro el contenido en la tercera pantalla
        txtIndice.setText(String.valueOf(posicion + 1));
        txtPregunta.setText(preguntaActual.getEnunciadoPregunta());

        String[] respuesta = preguntaActual.getRespuestas();
        Log.d("Andrea", "DESPUÉS de setText -> indice: " + txtIndice.getText().toString());
        Log.d("Andrea", "DESPUÉS de setText -> pregunta: " + txtPregunta.getText().toString());
        //Las respuestas son un string de respuestas
        btna.setText("A. " + respuesta[0]);
        btnb.setText("B. " + respuesta[1]);
        btnc.setText("C. " + respuesta[2]);
        btnd.setText("D. " + respuesta[3]);

        //botón volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cierra la tercera activity y vuelve a la segunda
                finish();
            }
        });

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadoRespuesta(0);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadoRespuesta(1);
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadoRespuesta(2);
            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estadoRespuesta(3);
            }


        });
    }

        //Creo un método para evaluar el estado de la respuesta: sin contestar, correcta, incorrecta

        public void estadoRespuesta (int indiceRespuesta){

        //para la respuesta seleccionada
            preguntaActual.setRespuestaSeleccionada(indiceRespuesta);

            int respuestaCorrectaPreguntaActual = preguntaActual.getRespuestaCorrecta();

          //ahora necesitamos guardar el botón pulsado y compararlo si es la
            //respuesta correcta o no, y pintar el color verde o rojo
            Button botonPulsado;
            switch (indiceRespuesta){
                case 0: botonPulsado = btna;
                break;
                case 1: botonPulsado = btnb;
                break;
                case 2: botonPulsado = btnc;
                break;
               default : botonPulsado = btnd;

            }

            //ahora, una vez sabemos qué índice es cada botón, pintamos en verde
            //si es correcto o en rojo si no lo es
            if(indiceRespuesta == respuestaCorrectaPreguntaActual){
                botonPulsado.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            } else{
                botonPulsado.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }


        }


}
