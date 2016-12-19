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

package com.sunjiajia.androidnewwidgetsdemo.picture.huiyiwuliao;

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

public class
HuiYiWuLiaoActivity extends AppCompatActivity implements MypdfRecyclerViewAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Imageinfo> list1;
    int posi;
    MypdfRecyclerViewAdapter mypdfRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hui_yi_wu_liao);
        mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        String position = getIntent().getStringExtra("a");


//        Log.e("position", position);
        posi = getIntent().getIntExtra("a", 1);
//        Log.e("position", position);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_Huiyirecyclerview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);


        switch (posi) {
            case 0:
                toolbar.setTitle("公益讲座");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                Imageinfo gongyijiangzuo1 = new Imageinfo();
                gongyijiangzuo1.imagename = "X展架";
                gongyijiangzuo1.image = R.drawable.kp01;
                Imageinfo gongyijiangzuo2 = new Imageinfo();
                gongyijiangzuo2.imagename = "参会证";
                gongyijiangzuo2.image = R.drawable.kp02;
                Imageinfo gongyijiangzuo3 = new Imageinfo();
                gongyijiangzuo3.imagename = "公益讲座背景墙";
                gongyijiangzuo3.image = R.drawable.kp01;
                Imageinfo gongyijiangzuo4 = new Imageinfo();
                gongyijiangzuo4.imagename = "幻灯片背景";
                gongyijiangzuo4.image = R.drawable.kp02;
                Imageinfo gongyijiangzuo5 = new Imageinfo();
                gongyijiangzuo5.imagename = "科普讲座门票";
                gongyijiangzuo5.image = R.drawable.kp01;
                Imageinfo gongyijiangzuo6 = new Imageinfo();
                gongyijiangzuo6.imagename = "条幅";
                gongyijiangzuo6.image = R.drawable.kp01;
                list1 = new ArrayList<Imageinfo>();
                list1.add(0, gongyijiangzuo1);
                list1.add(1, gongyijiangzuo2);
                list1.add(2, gongyijiangzuo3);
                list1.add(3, gongyijiangzuo4);
                list1.add(4, gongyijiangzuo5);
                list1.add(5, gongyijiangzuo6);
                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, HuiYiWuLiaoActivity.this);
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;

            case 1:


                toolbar.setTitle("店主培训会");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                Imageinfo hangyedongtai1 = new Imageinfo();
                hangyedongtai1.imagename = "X展架";
                hangyedongtai1.image = R.drawable.kp01;
                Imageinfo hangyedongtai2 = new Imageinfo();
                hangyedongtai2.imagename = "参会证";
                hangyedongtai2.image = R.drawable.kp02;
                Imageinfo hangyedongtai3 = new Imageinfo();
                hangyedongtai3.imagename = "店长培训背景墙";
                hangyedongtai3.image = R.drawable.kp01;
                Imageinfo hangyedongtai4 = new Imageinfo();
                hangyedongtai4.imagename = "幻灯片背景";
                hangyedongtai4.image = R.drawable.kp02;
                Imageinfo hangyedongtai5 = new Imageinfo();
                hangyedongtai5.imagename = "结业证书";
                hangyedongtai5.image = R.drawable.kp01;
                Imageinfo hangyedongtai6 = new Imageinfo();
                hangyedongtai6.imagename = "酒店温馨提示";
                hangyedongtai6.image = R.drawable.kp01;
                Imageinfo hangyedongtai7 = new Imageinfo();
                hangyedongtai7.imagename = "考核荣誉证书";
                hangyedongtai7.image = R.drawable.kp01;
                Imageinfo hangyedongtai8 = new Imageinfo();
                hangyedongtai8.imagename = "条幅";
                hangyedongtai8.image = R.drawable.kp01;


                list1 = new ArrayList<Imageinfo>();
                list1.add(0, hangyedongtai1);
                list1.add(1, hangyedongtai2);
                list1.add(2, hangyedongtai3);
                list1.add(3, hangyedongtai4);
                list1.add(4, hangyedongtai5);
                list1.add(5, hangyedongtai6);
                list1.add(6, hangyedongtai7);
                list1.add(7, hangyedongtai8);

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, HuiYiWuLiaoActivity.this);
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
        }


    }

    @Override
    public void onItemClick(View view, int position) {
        if (posi == 0) {
            Intent intent = new Intent(this, HuiYiWuLiaoDetail2Activity.class);
            intent.putExtra("a", position);

            startActivity(intent);

        } else {
            Intent intent = new Intent(this, HuiYiWuLiaoDetailActivity.class);
            intent.putExtra("a", position);

            startActivity(intent);

        }


    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
