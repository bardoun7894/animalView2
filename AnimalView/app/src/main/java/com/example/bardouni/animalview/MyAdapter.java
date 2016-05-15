package com.example.bardouni.animalview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bardouni on 5/10/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {
    CustomFilter filter;
    Context ctx;
    ArrayList<Product> product,filterList;



    public MyAdapter(Context ctx, ArrayList<Product> product ) {

        this.ctx = ctx;
        this.product = product;
       this.filterList=product;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card,null);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        holder.nameTxt.setText(product.get(position).getName());
        holder.postTxt.setText(product.get(position).getPublicher());
        Picasso.with(holder.img.getContext())
                .load(product.get(position).getImage())
               .resize(500,300)
                .centerCrop()
                .into(holder.img);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
              Intent intent=new Intent(v.getContext(), Second.class);
              Product p =product.get(position);
              intent.putExtra("name",p.getName());
              intent.putExtra("pub", (p.getPublicher()));
              intent.putExtra("image",(p.getImage()));
              v.getContext().startActivity(intent);
 }
        });

        
    }

    @Override
    public int getItemCount() {

        return product.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
    //DISMISS
    public void dismissTvshow(int position){
        product.remove(position);
       this.notifyItemRemoved(position);
    }

}
