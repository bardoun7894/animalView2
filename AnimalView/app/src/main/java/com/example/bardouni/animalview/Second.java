package com.example.bardouni.animalview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Second extends AppCompatActivity {
  TextView name2,pub2;
    ImageView img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.name2= (TextView)findViewById(R.id.tname);
        this.img2= (ImageView)findViewById(R.id.iImage);
        this.pub2= (TextView)findViewById(R.id.tpublicher);

     name2.setText(getIntent().getStringExtra("name"));
      pub2.setText(getIntent().getStringExtra("pub"));
     Picasso.with(img2.getContext())
            .load(getIntent().getStringExtra("image"))
             .resize(500,300)
             .centerCrop()
            .into(img2);






    }

}
