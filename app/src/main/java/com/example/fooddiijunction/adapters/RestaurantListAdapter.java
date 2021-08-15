package com.example.fooddiijunction.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddiijunction.MainActivity;

import com.example.fooddiijunction.R;
import com.example.fooddiijunction.model.RestaurantModel;

import java.text.BreakIterator;
import java.util.List;


import static com.example.fooddiijunction.R.id.*;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder> {



    private  List<RestaurantModel> restaurantModelList;
    private final RestaurantListClickListener clickListener;

 public RestaurantListAdapter(List<RestaurantModel> restaurantModelList, MainActivity clickListener){
      this.restaurantModelList=restaurantModelList;
this.clickListener= (RestaurantListClickListener) clickListener;


  }
  public void updateData(List<RestaurantModel> restaurantModelList){
     this.restaurantModelList =restaurantModelList;
     notifyDataSetChanged();

    }



   @NonNull

    @Override
    public RestaurantListAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
 View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);

  return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RestaurantListAdapter.MyViewHolder holder, int position) {

holder.restaurantName.setText(restaurantModelList.get(position).getName());
holder.restaurantAddress.setText("Address: " + restaurantModelList.get(position).getAddress());
holder.restaurantHours.setText("Today's hours :" + restaurantModelList.get(position).getHours().getTodayHours());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        clickListener.onItemClick(restaurantModelList.get(position));
    }
});
Glide.with(holder.thumbImage).load(restaurantModelList.get(position).getImage()).into(holder.thumbImage);





    }



    @Override
    public int getItemCount() {


          if(restaurantModelList!=null)
        return restaurantModelList.size();
          else return 0;

    }




    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView restaurantName;
        TextView restaurantAddress;
        TextView restaurantHours;
        ImageView thumbImage;

         public MyViewHolder(View view){
             super(view);
             restaurantName = view.findViewById(R.id.restaurantName);
             restaurantHours=view.findViewById(R.id.restaurantHours);
             restaurantAddress=view.findViewById(R.id.restaurantAddress);
             thumbImage=view.findViewById(thumbimage);




         }

    }public interface RestaurantListClickListener {
        public  void onItemClick(RestaurantModel restaurantModel);

    }


}
