package com.example.rosa.enjoyarts;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*para comunicar al RecyclerView del layout la cantidad de info que se utilizará para crear y rellenar cada item de la lista
actúa como puente entre la presentación y fuente de información a mostrar)
 */

//se crea adaptador
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

  /*los adaptadores para el RecycleView deben tener una clase interna que extienda de la clase RecycleViewHolder
    public class ViewHolder.
    Se crean las variables necesarias
    Se crea el constructor de la clase interna
    Se vinculan las variables creadas con los controles respectivos del layout*/

    public static class ViewHolder extends RecyclerView.ViewHolder{
     private TextView painter, workTitle;
     ImageView imgPicture;

     public ViewHolder(View itemView) {
         super(itemView);
         painter = (TextView)itemView.findViewById(R.id.tvPainter);
         workTitle = (TextView)itemView.findViewById(R.id.tvWorkTitle);
         imgPicture = (ImageView)itemView.findViewById(R.id.imgPicture);
     }
 }

 //se crea una variable tipo lista para almacenar todos los datos mostrados en cada item

    public List<PainterModel> painterList;

 //método constructor del adaptador el cual recibirá como parámetro la lista creada
    public RecyclerViewAdapter(List<PainterModel> painterList){
        this.painterList = painterList;
    }

    //método encargado de "infla" el contenido de un nuevo item para la lista.
    /*inflar es término del procedimiento que se realiza para hacer uso de un layout dentro de otro layout
    ej. en este caso el layout item_tab_color tiene como destino ser parte del layout del ActivityMain
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab_color,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return null;
    }

    //realiza las modificaciones del contenido para cada item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.painter.setText(painterList.get(position).getPainter());
        holder.workTitle.setText(painterList.get(position).getWorkTitle());
        holder.imgPicture.setImageResource(painterList.get(position).getImgPicture());
    }

    //permite determinar al adaptador la cantidad de elementos que se procesarán

    @Override
    public int getItemCount() {
        return painterList.size();
    }
}

