package com.example.tcstestapp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<DashboardMenu> menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = new ArrayList<>();
        menuList.add(new DashboardMenu(R.drawable.ac_balance_icon_img_foreground, "Choice 1"));
        menuList.add(new DashboardMenu(R.drawable.status_icon_img_foreground, "Choice 2"));
        menuList.add(new DashboardMenu(R.drawable.feedback_icon_img_foreground, "Choice 3"));
        menuList.add(new DashboardMenu(R.drawable.ac_balance_icon_img_foreground, "Choice 4"));
        menuList.add(new DashboardMenu(R.drawable.status_icon_img_foreground, "Choice 5"));
        menuList.add(new DashboardMenu(R.drawable.ac_balance_icon_img_foreground, "Choice 6"));
        menuList.add(new DashboardMenu(R.drawable.feedback_icon_img_foreground, "Choice 7"));
        menuList.add(new DashboardMenu(R.drawable.status_icon_img_foreground, "Choice 8"));
        menuList.add(new DashboardMenu(R.drawable.ac_balance_icon_img_foreground, "Choice 9"));
        menuList.add(new DashboardMenu(R.drawable.feedback_icon_img_foreground, "Choice 10"));

        RecyclerView recyclerView = findViewById(R.id.Dashboard_RecyclerView01);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter  rva = new RecyclerViewAdapter(this, menuList);
        if(getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }else
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(rva);
    }

    public void goToStatusActivity(View view) {
        Intent in = new Intent(this, StatusActivity.class);
        startActivity(in);
    }
}
