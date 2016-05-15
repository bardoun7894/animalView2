package com.example.bardouni.animalview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    ImageView img;
    ItemClickListener itemClickListener;
    TextView nameTxt,postTxt ;
    public MyHolder(View itemView) {
        super(itemView);
        this.img= (ImageView) itemView.findViewById(R.id.ivImage);
        this.postTxt= (TextView) itemView.findViewById(R.id.ivpublicher);
        this.nameTxt= (TextView) itemView.findViewById(R.id.tvText);
      itemView.setOnClickListener(this);

    }

  @Override
  public void onClick(View v) {
    this.itemClickListener.onItemClick(v,getLayoutPosition());
 }

    public void setItemClickListener(ItemClickListener ic){
     this.itemClickListener=ic;

 }

}