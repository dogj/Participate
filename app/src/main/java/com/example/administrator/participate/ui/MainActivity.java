package com.example.administrator.participate.ui;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.animation.Interpolator;
import android.widget.Toast;

import com.example.administrator.participate.R;
import com.example.administrator.participate.adapter.Adapter;
import com.example.administrator.participate.model.Data;
import com.example.administrator.participate.model.ListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Toolbar toolbar;
    SwipeRefreshLayout swipeRefreshLayout;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.SR_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(Data.getListData(), this);
        swipeRefreshLayout.setOnRefreshListener(this);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){


            LinearLayoutManager mLayoutManager =(LinearLayoutManager) recyclerView.getLayoutManager();
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                Toast.makeText(MainActivity.this,""+mLayoutManager.findLastVisibleItemPosition(),Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this,""+adapter.getItemCount(),Toast.LENGTH_SHORT).show();
                 if(mLayoutManager.findLastVisibleItemPosition()==(adapter.getItemCount()-1)){
                     Toast.makeText(MainActivity.this,"刷新了"+mLayoutManager.findLastCompletelyVisibleItemPosition(),Toast.LENGTH_SHORT).show();
                     List<ListItem> data;
                     data = Data.add();
                     adapter.additem(data);
                     adapter.notifyDataSetChanged();

                 }

            }
        });

        adapter.setOnItemClickListener(new Adapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onRefresh() {



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//                swipeRefreshLayout.setRefreshing(false);
//
//            }
//        }, 3000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<ListItem> data;
                data = Data.add();
                adapter.additem(data);
                swipeRefreshLayout.setRefreshing(false);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"刷新了2个于顶部",Toast.LENGTH_SHORT).show();
//                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                adapter = new Adapter(adapter.listData, MainActivity.this);
//                recyclerView.setAdapter(adapter);
                }

            }, 2000);
    }





    }

//adapter的notify就是告诉adapter数据改变了，无需自己再添加后面的语句了会自动跑回去的。