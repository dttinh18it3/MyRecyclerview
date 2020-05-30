package com.example.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Model> itemList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name, tv_description;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            image = itemView.findViewById(R.id.image);
        }
    }
    public Adapter(Context context, List<Model> list) {
        this.context = context;
        this.itemList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.tv_name.setText(itemList.get(i).getName());
        viewHolder.tv_description.setText(itemList.get(i).getDecription());
        viewHolder.image.setImageResource(itemList.get(i).getImage());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail_name = itemList.get(i).getName();
                String detail_decriptions = itemList.get(i).getDecription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) viewHolder.image.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                final byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Name", detail_name);
                intent.putExtra("Description", detail_decriptions);
                intent.putExtra("Image", bytes);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        System.out.println("SIze " + itemList.size());
        return itemList.size();
    }


}
