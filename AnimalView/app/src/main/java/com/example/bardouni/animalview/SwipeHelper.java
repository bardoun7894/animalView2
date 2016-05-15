package com.example.bardouni.animalview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

/**
 * Created by bardouni on 5/12/2016.
 */
public class SwipeHelper extends ItemTouchHelper.SimpleCallback{
    MyAdapter adapter;
    ArrayList<Product> p ;

    public SwipeHelper(MyAdapter adapter) {
        super(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.LEFT);
        this.adapter = adapter;
    }

    public SwipeHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.dismissTvshow(viewHolder.getAdapterPosition());
    }
}
