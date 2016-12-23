/*
 *
 *  *
 *  *  *
 *  *  *  * ===================================
 *  *  *  * Copyright (c) 2016.
 *  *  *  * 作者：安卓猴
 *  *  *  * 微博：@安卓猴
 *  *  *  * 博客：http://sunjiajia.com
 *  *  *  * Github：https://github.com/opengit
 *  *  *  *
 *  *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  *  * ===================================
 *  *  *
 *  *  *
 *  *
 *
 */

package com.sunjiajia.androidnewwidgetsdemo.picture.rongyuzixun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.sunjiajia.androidnewwidgetsdemo.bean.Imageinfo;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MypdfRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RongYuZiZhiDetailPdfActivity extends AppCompatActivity implements MypdfRecyclerViewAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Imageinfo> list1;
    MypdfRecyclerViewAdapter mypdfRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rong_yu_zi_zhi_detail_pdf);
        mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        String position = getIntent().getStringExtra("a");


//        Log.e("position", position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("权威检测报告");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.id_rongyurecyclerview);


        Imageinfo hangyedongtai1 = new Imageinfo();
        hangyedongtai1.imagename = "产品检测报告";
        hangyedongtai1.image = R.drawable.jc;
        Imageinfo hangyedongtai2 = new Imageinfo();
        hangyedongtai2.imagename = "天保得乐、雪莲保养贴、雪莲要垫荧光剂检测最新报告";
        hangyedongtai2.image = R.drawable.jc;
        Imageinfo hangyedongtai3 = new Imageinfo();
        hangyedongtai3.imagename = "天保得乐、雪莲生态保养检测报告";
        hangyedongtai3.image = R.drawable.jc;
        Imageinfo hangyedongtai4 = new Imageinfo();
        hangyedongtai4.imagename = "卫生检测报告";
        hangyedongtai4.image = R.drawable.jc;
        Imageinfo hangyedongtai5 = new Imageinfo();
        hangyedongtai5.imagename = "新加坡TÜV SÜD PSB检测";
        hangyedongtai5.image = R.drawable.jc;

        list1 = new ArrayList<Imageinfo>();
        list1.add(0, hangyedongtai1);
        list1.add(1, hangyedongtai2);
        list1.add(2, hangyedongtai3);
        list1.add(3, hangyedongtai4);
        list1.add(4, hangyedongtai5);
        mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, RongYuZiZhiDetailPdfActivity.this);
        mypdfRecyclerViewAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
        mypdfRecyclerViewAdapter.notifyDataSetChanged();
        mRecyclerView.setLayoutManager(mLayoutManager);

    }


    @Override
    public void onItemClick(View view, int position) {


        Intent intent = new Intent(this, RongYuZiZhiDetailPdfShowActivity.class);

        intent.putExtra("a", position);


        startActivity(intent);


    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
