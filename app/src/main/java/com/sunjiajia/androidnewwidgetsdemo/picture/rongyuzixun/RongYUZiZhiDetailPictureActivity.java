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

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyGalleryRecyclerViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyStaggeredViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai.GalleryActivity;
import com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai.GalleryDetailActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RongYUZiZhiDetailPictureActivity extends AppCompatActivity implements MyGalleryRecyclerViewAdapter.OnItemClickListener {
    Gallery g = null;
    ArrayList<String> it = new ArrayList<String>();
    ;// 遍历符合条件的列表
    public String actionUrl = null;
    private String FILE_NAME = "Pictures/图片素材/pc01";

    private final String SD_PATH = android.os.Environment

            .getExternalStorageDirectory().getAbsolutePath();
    Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyGalleryRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;
    private static final int SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        int posi = getIntent().getIntExtra("a", 1);

        Log.e("posi", String.valueOf(posi));
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_galleryrecyclerview);

        switch (posi) {
            case 0:
                toolbar.setTitle("权威检测报告");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "JT/Pictures/荣誉资质/05权威检测报告";

                break;
            case 1:
                toolbar.setTitle("产品荣誉");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "JT/Pictures/荣誉资质/04产品荣誉";

                break;
            case 2:
                toolbar.setTitle("企业荣誉");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "JT/Pictures/荣誉资质/03企业荣誉";

                break;
            case 3:
                toolbar.setTitle("企业经营资质");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "JT/Pictures/荣誉资质/02企业经营资质";

                break;
            case 4:
                toolbar.setTitle("企业商标专利");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "JT/Pictures/荣誉资质/01企业商标专利";
                break;
        }
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
        Intent intent = new Intent(RongYUZiZhiDetailPictureActivity.this, GalleryDetailActivity.class);
        intent.putExtra("a", it.get(position));
        intent.putExtra("c", position);
        intent.putStringArrayListExtra("b", it);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }


}
