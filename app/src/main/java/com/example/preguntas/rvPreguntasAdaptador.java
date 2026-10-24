package com.example.preguntas;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class rvPreguntasAdaptador extends RecyclerView.Adapter <rvPreguntasAdaptador.ViewHolder>{

    //Necesitamos los datos
    List<Pregunta> listaPreguntas;

    public rvPreguntasAdaptador(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    @NonNull
    @Override
    public rvPreguntasAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pregunta, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    //Rellena cada fila con los datos de la pregunta: pone el enunciado y decide qué icono poner
    //según la respuesta
    //También aquí conectamos con la pantalla 3
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Coge la pregunta de esa posicion
        Pregunta pregunta = listaPreguntas.get(position);
        //cambia el texto con el get
        holder.txtPregunta.setText(pregunta.getEnunciadoPregunta());

        //para el icono
        if(!pregunta.estaContestada()){
            holder.ivEstado.setImageResource(R.drawable.sinresponder);
        }else if (pregunta.esCorrecta()){
            holder.ivEstado.setImageResource(R.drawable.respuestacorrecta);
        }else {
            holder.ivEstado.setImageResource(R.drawable.respuestaincorrecta);
        }

        //Ahora, cuando pulsemos cualquier fila, abrimos la tercera activity, en esta posición

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), TerceraActivity.class);
                intent.putExtra("posicion", holder.getAbsoluteAdapterPosition());
                holder.itemView.getContext().startActivity(intent);

                Log.i("andrea", "posicion al pulsar"+holder.getAbsoluteAdapterPosition());
                Log.i("andrea", "enunciado pregunta"+pregunta.getEnunciadoPregunta());
            }
        });
    }

    //Devulve la cantidad de items(preguntas)
    @Override
    public int getItemCount() {
        return listaPreguntas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPregunta;
        ImageView ivEstado;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPregunta = itemView.findViewById(R.id.txtPregunta);
            ivEstado = itemView.findViewById(R.id.ivEstado);
        }

        
    }
    
   

}
