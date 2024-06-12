package com.example.rapideats.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public FoodListAdapter(ArrayList<Foods> items){
        this.items = items;
    }

    @NonNull
    @Override
    public FoodListAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.viewholder_list_food,parent,false);
        return new viewholder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.viewholder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.timeTxt.setText(items.get(position).getTimeValue()+" min");
        holder.priceTxt.setText("$"+items.get(position).getPrice());
        holder.rateTxt.setText(""+items.get(position).getStar());

        Glide.with(context)
                .load(items.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners( 30))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView titleTxt,priceTxt,rateTxt,timeTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            titleTxt=itemView.findViewById(R.id.titleTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            rateTxt=itemView.findViewById(R.id.rateTxt);
            timeTxt=itemView.findViewById(R.id.timeTxt);
            pic=itemView.findViewById(R.id.img);
        }
    }
}
