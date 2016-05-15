package com.example.bardouni.animalview;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by bardouni on 5/11/2016.
 */
public class CustomFilter extends Filter {
MyAdapter adapter;
    ArrayList<Product> filterList;

    public CustomFilter(ArrayList<Product> filterList,MyAdapter adapter) {
        this.filterList=filterList;
        this.adapter=adapter;

    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        if(constraint!=null && constraint.toString().length()> 0 ){

            String Sfilter=constraint.toString().toLowerCase();

         final  ArrayList<Product> filterproducts=new ArrayList<>();



            for(int i=0;i<filterList.size();i++){
                //CHECK
                if(filterList.get(i).getName().toLowerCase().contains(Sfilter)){
                 //Add playerd to filtering
                    filterproducts.add(filterList.get(i));

                }
            }
         results.count=filterproducts.size();
            results.values=filterproducts;
        }else{
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.product= (ArrayList<Product>) results.values;
        adapter.notifyDataSetChanged();

    }
}
