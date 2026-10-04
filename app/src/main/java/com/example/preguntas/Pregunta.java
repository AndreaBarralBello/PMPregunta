package com.example.preguntas;

public class Pregunta {

    String enunciadoPregunta;
    String[] respuestas;
    int respuestaCorrecta;
    int respuestaSeleccionada;



    public Pregunta() {
    }



    public Pregunta(String enunciadoPregunta, String[] respuestas, int respuestaCorrecta) {
        this.enunciadoPregunta = enunciadoPregunta;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaSeleccionada = -1;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getRespuestaSeleccionada() {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(int respuestaSeleccionada) {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public String getEnunciadoPregunta() {
        return enunciadoPregunta;
    }

    public void setEnunciadoPregunta(String enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }

    //método que indique si la respuesta seleccionada es la correcta o no

    //primero si la respuesta se contestó
    public boolean estaContestada(){
        //es decir, si no tiene el valor del constructor, es true, esta contestada
    return respuestaSeleccionada != -1;

    }

    //una vez que sabemos que la respuesta esta contestada, si es true or false
    public boolean esCorrecta(){
        return respuestaSeleccionada == respuestaCorrecta;
    }

}
