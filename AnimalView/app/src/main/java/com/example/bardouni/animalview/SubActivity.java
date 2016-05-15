package com.example.bardouni.animalview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity implements Response.Listener<String> {
    RecyclerView recyclerView;

    SearchView sv;

    final String TAG = this.getClass().getSimpleName();
     Context ctx;
    ListView lvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);




        String url = "http://mbardouni.netau.net/costumer/feed.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, this, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error while reading data", Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        lvProduct = (ListView)findViewById(R.id.lvProduct);
        recyclerView= (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        sv= (SearchView) findViewById(R.id.search);
       sv.getQuery();



    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, response);

   final  ArrayList<Product> productList = new JsonConverter<Product>().toArrayList(response, Product.class);

      final MyAdapter adapter=new MyAdapter(ctx , productList);
        recyclerView.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        ItemTouchHelper.Callback callback=new SwipeHelper(adapter);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);


    }


}
