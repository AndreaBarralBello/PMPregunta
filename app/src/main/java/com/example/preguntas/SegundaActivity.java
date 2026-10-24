package com.example.preguntas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity {

    //La lista de preguntas y sus respuestas las necesito para segunda y tercera activity
    //por eso public static
    public static List<Pregunta> listaPreguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Log.d("debug", "activity 2 ejecutándose");



            //Meto las preguntas de manera manual con las respuestas, además de la respuesta correcta


            listaPreguntas.add(new Pregunta(
                    "¿Cuál es la velocidad genérica máxima permitida para turismos en vías urbanas" +
                            "de un único carril por sentido de circulación en España?",
                    new String[]{"50 km/h", "30 km/h", "20 km/h", "40 km/h"},
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Cuál es la tasa máxima de alcohol en aire espirado permitida para un conductor " +
                            "general (no novel ni profesional) en España?",
                    new String[]{"0,15 mg/l", "0,25 mg/l", "0,50 mg/l", "0,00 mg/l"},
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Está permitido utilizar el teléfono móvil sosteniéndolo con la mano mientras " +
                            "se está detenido en un semáforo en rojo?",
                    new String[]{
                            "Sí, siempre que el vehículo esté completamente detenido y el motor apagado.",
                            "No, está totalmente prohibido sujetar el teléfono con la mano mientras se está al volante, incluso en semáforos en rojo o atascos.",
                            "Sí, pero solo para realizar o recibir llamadas de emergencia.",
                            "Sí, si se utiliza el altavoz del teléfono."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "En una glorieta (rotonda) sin señalizar, ¿quién tiene prioridad de paso?",
                    new String[]{
                            "El vehículo que se incorpora a la glorieta.",
                            "El vehículo que ya está circulando dentro de la glorieta.",
                            "El vehículo que se aproxima por la derecha.",
                            "El vehículo de mayor tamaño o peso."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Cuál es la distancia de seguridad mínima obligatoria que debe mantener un turismo " +
                            "respecto al vehículo que le precede cuando circula a más de 100 km/h por una autovía?",
                    new String[]{
                            "50 metros.",
                            "100 metros.",
                            "La distancia que recorra el vehículo en 4 segundos.",
                            "150 metros."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Es obligatorio el uso del cinturón de seguridad en los asientos traseros " +
                            "de un vehículo que circula por ciudad?",
                    new String[]{
                            "No, solo es obligatorio en vías interurbanas o autopistas.",
                            "Sí, es obligatorio para todos los ocupantes del vehículo, tanto en vías urbanas como interurbanas.",
                            "Solo es obligatorio si el vehículo dispone de airbag.",
                            "No, es opcional para los pasajeros mayores de 18 años en zonas urbanas."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Qué forma y color tienen las señales de tráfico que indican una prohibición en España?",
                    new String[]{
                            "Triangulares con borde rojo y fondo blanco.",
                            "Redondas con borde rojo y fondo blanco.",
                            "Cuadradas de color azul con símbolo blanco.",
                            "Rectangulares de color amarillo con borde negro."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Tienen los peatones prioridad de paso en un paso para peatones debidamente señalizado?",
                    new String[]{
                            "No, el vehículo siempre tiene la prioridad por ser más pesado.",
                            "Sí, los vehículos deben detenerse y ceder el paso a los peatones que estén cruzando o que manifiesten claramente su intención de hacerlo.",
                            "Solo si el semáforo de peatones está en verde.",
                            "Solo si no hay ningún vehículo acercándose a menos de 50 metros."
                    },
                    1
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Cuándo debe cambiar obligatoriamente de luz de carretera (largas) a luz de cruce (cortas)?",
                    new String[]{
                            "Cuando circule por una vía suficientemente iluminada o se cruce con otro vehículo a menos de 150 metros.",
                            "Únicamente cuando llueva intensamente o haya niebla.",
                            "Nunca, las luces largas alumbran más y son siempre más seguras.",
                            "Solo al entrar en un túnel, independientemente de si está iluminado o no."
                    },
                    0
            ));

            listaPreguntas.add(new Pregunta(
                    "¿Cuál es la tasa máxima de alcohol en aire espirado permitida para un conductor " +

                            "novel (con menos de dos años de permiso) o profesional en España?",
                    new String[]{"0,25 mg/l", "0,15 mg/l", "0,50 mg/l", "0,00 mg/l"},
                    1
            ));

        RecyclerView rvPreguntas = findViewById(R.id.rvPreguntas);
        rvPreguntas.setLayoutManager(new LinearLayoutManager(this));


        rvPreguntasAdaptador adaptador = new rvPreguntasAdaptador(listaPreguntas);
        rvPreguntas.setAdapter(adaptador);


        Log.d("tamaño", "lista"+listaPreguntas.size());



        }

        @Override
    protected void onResume(){
        super.onResume();

        //Al volver de la tercera pantalla, le decimos al recycleview los datos que han cambiado

            RecyclerView rvPreguntas = findViewById(R.id.rvPreguntas);
            if(rvPreguntas != null && rvPreguntas.getAdapter() != null){
                rvPreguntas.getAdapter().notifyDataSetChanged();
            }
        }
    }
