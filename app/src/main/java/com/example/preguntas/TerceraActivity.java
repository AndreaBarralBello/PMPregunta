package com.example.preguntas;

import android.os.Bundle;
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

        //Muestro el contenido en la tercera pantalla
        txtIndice.setText(posicion + 1);
        txtPregunta.setText(preguntaActual.getEnunciadoPregunta());

        String[] respuesta = preguntaActual.getRespuestas();

        //Las respuestas son un string de respuestas
        btna.setText("A. " + respuesta[0]);
        btnb.setText("B. " + respuesta[1]);
        btnc.setText("C. " + respuesta[2]);
        btnd.setText("D. " + respuesta[3]);

    }
        //Creo un método para evaluar el estado de la respuesta: sin contestar, correcta, incorrecta

        public void estadoRespuesta (int indiceRespuesta){

        //para la respuesta seleccionada
            preguntaActual.setRespuestaSeleccionada(indiceRespuesta);


        }

    }
}