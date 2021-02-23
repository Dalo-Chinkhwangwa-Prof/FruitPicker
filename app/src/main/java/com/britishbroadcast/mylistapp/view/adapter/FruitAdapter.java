package com.britishbroadcast.mylistapp.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.britishbroadcast.mylistapp.R;
import com.britishbroadcast.mylistapp.model.Fruit;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private List<Fruit> fruitList;
    private FruitDelegate fruitDelegate;

    public interface FruitDelegate {
        void selectFruit(Fruit fruit);
    }

    public FruitAdapter(List<Fruit> fruitList, FruitDelegate fruitDelegate) {
        this.fruitList = fruitList;
        this.fruitDelegate = fruitDelegate;
    }

    @Override
    public int getCount() { //You have to return the size of the items you have
        return fruitList.size();
    }

    @Override
    public Fruit getItem(int position) { //get object at position
        return fruitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View fruitView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fruit_item_layout, viewGroup, false);

        TextView textView = fruitView.findViewById(R.id.fruitlabel_textview);
        textView.setText(fruitList.get(position).getName());

        TextView calorieVew = fruitView.findViewById(R.id.calories_textview);
        calorieVew.setText("" + fruitList.get(position).getCalories());

        TextView descView = fruitView.findViewById(R.id.description_textview);
        descView.setText(fruitList.get(position).getBenefits());

        ImageView fruitImage = fruitView.findViewById(R.id.fruit_imageview);

        Glide.with(fruitView)
                .setDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(fruitList.get(position).getImage())
                .into(fruitImage);

//        fruitView.setOnClickListener(v -> { lambda
//
//        });

        fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("TAG_X", ""+fruitImage.getBackground().
//                if(fruitImage.getBackground() == fruitView.getContext().getDrawable(R.drawable.image_circle_bg_alt))
                fruitImage.setBackground(fruitView.getContext().getDrawable(R.drawable.image_circle_bg));
                fruitDelegate.selectFruit(fruitList.get(position));
//                else
//                    fruitImage.setBackground(fruitView.getContext().getDrawable(R.drawable.image_circle_bg_alt));
            }
        });


        return fruitView;
    }
}
