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

package com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import android.widget.Gallery;


import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyGalleryRecyclerViewAdapter;

import com.sunjiajia.androidnewwidgetsdemo.adapter.MyStaggeredViewAdapter;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

public class GalleryActivity extends AppCompatActivity implements MyGalleryRecyclerViewAdapter.OnItemClickListener {
    Gallery g = null;
    ArrayList<String> it = new ArrayList<String>();
    ;// 遍历符合条件的列表
    public String actionUrl = null;
    private String FILE_NAME = "Pictures/图片素材/pc01";

    private final String SD_PATH = android.os.Environment

            .getExternalStorageDirectory().getAbsolutePath();


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyGalleryRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;
    private static final int SPAN_COUNT = 2;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String position = getIntent().getStringExtra("a");
        Log.e("position", position);
         toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_galleryrecyclerview);


        if (position.equals("0")) {

            FILE_NAME = "JT/Pictures/图片素材/08金天国际25周年梦想盛典暨公益筑梦远航";
            toolbar.setTitle("25周年梦想盛典暨公益筑梦远航");
        } else if (position.equals("1")) {

            FILE_NAME = "JT/Pictures/图片素材/07金天国际宿迁智能化产业园落成典礼";
            toolbar.setTitle("宿迁智能化产业园落成典礼");
        } else if (position.equals("2")) {

            FILE_NAME = "JT/Pictures/图片素材/06金天国际2015年度优秀领导人表彰暨获牌盛典";
            toolbar.setTitle("2015年度优秀领导人表彰暨获牌盛典");
        } else if (position.equals("3")) {
            FILE_NAME = "JT/Pictures/图片素材/05金天国际直销启动暨“和谐与活力”公益盛典";
            toolbar.setTitle("直销启动暨“和谐与活力”公益盛典");

        } else if (position.equals("4")) {
            FILE_NAME = "JT/Pictures/图片素材/04培训基地";
            toolbar.setTitle("培训基地");

        } else if (position.equals("5")) {
            FILE_NAME = "JT/Pictures/图片素材/03星湖半岛";
            toolbar.setTitle("星湖半岛");

        } else if (position.equals("6")) {

            FILE_NAME = "JT/Pictures/图片素材/02生产基地";
            toolbar.setTitle("生产基地");
        } else if (position.equals("7")) {
            FILE_NAME = "JT/Pictures/图片素材/01办公环境";
            toolbar.setTitle("办公环境");

        }
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLayoutManager =
                new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);

        mRecyclerViewAdapter = new MyGalleryRecyclerViewAdapter(getSD(), this);
        mRecyclerViewAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.notifyDataSetChanged();
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    //遍历SD卡中某一路径下指定类型的图片
    private List<String> getSD() {

        File f = new File(SD_PATH + "//" + FILE_NAME);
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (getImageFile(file.getPath()))
                it.add(file.getPath());

            Log.e("sds",String.valueOf(it.get(i)));
        }
        return it;
    }

    //指定遍历文件类型
    private boolean getImageFile(String fName) {
        boolean re;
        String end = fName
                .substring(fName.lastIndexOf(".") + 1, fName.length())
                .toLowerCase();
        if (end.equals("jpg") || end.equals("gif") || end.equals("png")
                || end.equals("jpeg") || end.equals("bmp")) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(GalleryActivity.this, GalleryDetailActivity.class);
        intent.putExtra("a", it.get(position));
        intent.putExtra("c", position);
        intent.putStringArrayListExtra("b", it);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }


}
