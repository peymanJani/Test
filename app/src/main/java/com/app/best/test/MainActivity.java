package com.app.best.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Adapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    String[] img = {"https://kasbokarnews.ir/wp-content/uploads/2018/06/20180614102203.jpg","http://alavi.ir/ab/wp-content/uploads/sites/7/2016/08/006.jpg"};
    CarouselView carouselView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCarsoulView();

        expListView = (ExpandableListView) findViewById(R.id.Expandablelist);

        // preparing list data
        prepareListData();

        listAdapter = new Adapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void setCarsoulView() {
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(img.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get().load(img[position]).fit().centerCrop().into(imageView);
        }
    };



    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("نمایش ویژگی های آیتیک");
        listDataHeader.add("نمایش شرایط استفاده از آیتیک");

        // Adding child data
        List<String> films = new ArrayList<String>();
        films.add("سربداران");
        films.add("خواب و بیدار");
        films.add("دزد و پلیس");


        List<String> Directors = new ArrayList<String>();
        Directors.add("ابراهیم حاتمی کیا");
        Directors.add("مهران مدیری");
        Directors.add("مهران غفوریان");




        listDataChild.put(listDataHeader.get(0), films); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Directors);

    }
}
