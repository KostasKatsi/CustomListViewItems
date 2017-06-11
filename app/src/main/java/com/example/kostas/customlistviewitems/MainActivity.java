package com.example.kostas.customlistviewitems;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Car> myCars = new ArrayList<Car>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        populateCarList();
        populateListView();
    }



    private void populateCarList() {
        myCars.add(new Car("Ford", 1940, R.drawable.help, "Needing work"));
        myCars.add(new Car("Toyota", 1944, R.drawable.heart, "Needing work"));
        myCars.add(new Car("Honda", 1999, R.drawable.fish, "Needing work"));
        myCars.add(new Car("Porche", 2005, R.drawable.lightning, "Needing work"));
        myCars.add(new Car("Jeep", 2000, R.drawable.star, "Needing work"));
        myCars.add(new Car("Rust-Bucket", 2010, R.drawable.bug, "Needing work"));
        myCars.add(new Car("Moon Lander", 1971, R.drawable.up, "Needing work"));
    }

    private void populateListView() {
        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Car>{

        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view, myCars);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // /Make sure we haev a view to work with
            View itemView = convertView;
            if (itemView==null)
            {
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }

            //Find the car
            Car currentCar = myCars.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentCar.getIconID());
            TextView make = (TextView) itemView.findViewById(R.id.txtMake);
            make.setText(currentCar.getMake());
            TextView year = (TextView) itemView.findViewById(R.id.txtYear);
            year.setText(Integer.toString(currentCar.getYear()));
            TextView condition = (TextView) itemView.findViewById(R.id.txtCondition);
            condition.setText(currentCar.getCondition());

            return itemView;
        }
    }
}
