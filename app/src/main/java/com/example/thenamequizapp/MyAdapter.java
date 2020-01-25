package com.example.thenamequizapp;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.content.DialogInterface;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import android.util.Log;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<String> data1;
    List<Drawable> images;


    /**
     * Constructor for the adapter.
     *
     * @param ct
     * @param s1
     * @param img
     */
    public MyAdapter(Context ct, List<String> s1, List<Drawable> img) {
        context = ct;
        data1 = s1;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    /**
     * Sets the individual elements in the list.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.myText.setText(data1.get(position));
        holder.myImage.setImageDrawable(images.get(position));


        /**
         * When long clicking the element a dialog pops up, and you can delete the element.
         */
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                System.out.println("You longed clicked with: " + position);
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                Log.e("Answer", "Yes");
                                data1.remove(position);
                                images.remove(position);
                                notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                Log.e("Answer", "No");
                                break;
                        }
                    }
                };
                AlertDialog.Builder ab = new AlertDialog.Builder(context);
                ab.setMessage("Are you sure to delete?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            }
        });


    }

    /**
     * returns the size of the list.
     *
     * @return The size of the list
     */

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText = itemView.findViewById(R.id.person_name);
            myImage = itemView.findViewById(R.id.person_image);
        }
    }
}
