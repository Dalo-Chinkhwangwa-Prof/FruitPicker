package com.britishbroadcast.mylistapp.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.britishbroadcast.mylistapp.R;
import com.britishbroadcast.mylistapp.model.Fruit;
import com.britishbroadcast.mylistapp.view.adapter.FruitAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FruitAdapter.FruitDelegate {

    private ListView mainListView;

    //BaseAdapter
    private FruitAdapter fruitBaseAdapter;
    private List<Fruit> fruitList = new ArrayList<>(
            Arrays.asList(
                    new Fruit("https://i2.wp.com/ceklog.kindel.com/wp-content/uploads/2013/02/firefox_2018-07-10_07-50-11.png?fit=641%2C618&ssl=1",
                            "Apple", 90, "Really healthy"),
                    new Fruit("https://solidstarts.com/wp-content/uploads/Kiwi_edited-scaled.jpg", "Kiwi", 40, "Keeps you calm"),
                    new Fruit("https://lh3.googleusercontent.com/proxy/VuVi_mfdubjCGKudwbY4JW3hFKB0iXl1nUHhUfWZAVEkA8g0vgGa9XAc0qLXR9cIpsg19yM_qt_igcmWbyP1fgcNyg6jy523KP39XtiJeVddbrsDfmaClp8Lpw4rq7k",
                            "Water Melon", 60, "Make you smile"),
                    new Fruit("https://sites.psu.edu/lifeitmoveson/files/2017/10/orange-1hoca2l.jpg",
                            "Orange", 50, "Good for your skin + Vitamin C"),
                    new Fruit("https://images.carriercms.com/image/upload/w_500,h_400,c_fill,g_center,q_auto,f_auto/v1543516192/carrier/carrier-global/food/bananas.jpg",
                            "Banana", 30, "Good for potassium"),
                    new Fruit("https://www.freshpoint.com/wp-content/uploads/commodity-blueberry.jpg",
                            "BlueBerry", 78, "Good for immune system")
            )
    );

    //ArrayAdapter<T>
    private List<String> fruits = new ArrayList<>(
            Arrays.asList(
                    "Apples",
                    "Blue Berry",
                    "Banana",
                    "Pear",
                    "Apricot",
                    "Strawberry"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = findViewById(R.id.main_listview);
        ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(
                this,
                R.layout.fruit_item_layout,
                R.id.fruitlabel_textview,
                fruits
        );

        fruitBaseAdapter = new FruitAdapter(fruitList, this);

        mainListView.setAdapter(fruitBaseAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, fruits.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void selectFruit(Fruit fruit) {
//        Toast.makeText("", "", Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_AppCompat))
                .setTitle("Fruit Selected")
                .setMessage("The fruit you select is " + fruit.getName() + ". It has the benefits of "
                        + fruit.getBenefits() + " and consists of " + fruit.getCalories() + " calories.")
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "this was a negative choice", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "this was a neutral choice", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Great choice!!", Toast.LENGTH_SHORT)
                                .show();
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();

    }
}