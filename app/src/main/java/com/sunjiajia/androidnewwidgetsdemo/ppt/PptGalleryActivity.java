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

package com.sunjiajia.androidnewwidgetsdemo.ppt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Gallery;

import com.sunjiajia.androidnewwidgetsdemo.FileComparator;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyGalleryRecyclerViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyStaggeredViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai.GalleryDetailActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PptGalleryActivity extends AppCompatActivity implements MyGalleryRecyclerViewAdapter.OnItemClickListener {
    Gallery g = null;

    ;// 遍历符合条件的列表
    public String actionUrl = null;
    private String FILE_NAME = "Pictures/图片素材/pc01";

    private final String SD_PATH = android.os.Environment

            .getExternalStorageDirectory().getAbsolutePath();
    ArrayList<String> it ;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyGalleryRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;
    private static final int SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String position = getIntent().getStringExtra("a");
        Log.e("position", position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_galleryrecyclerview);
        toolbar.setTitle("图片");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (position.equals("0")) {

            FILE_NAME = "JT/ppt/11635营销宝典";

        } else if (position.equals("1")) {

            FILE_NAME = "JT/ppt/10金天国际 基础训";
        } else if (position.equals("2")) {

            FILE_NAME = "JT/ppt/09生态保养咨询过程中需掌握的技巧和方法";
        } else if (position.equals("3")) {
            FILE_NAME = "JT/ppt/08专业咨询需掌握的基础知识";

        } else if (position.equals("4")) {
            FILE_NAME = "JT/ppt/07讲师基本素质";

        } else if (position.equals("5")) {
            FILE_NAME = "JT/ppt/06讲师训班前训";

        } else if (position.equals("6")) {

            FILE_NAME = "JT/ppt/05十大亮点";
        } else if (position.equals("7")) {
            FILE_NAME = "JT/ppt/04十大举措";

        } else if (position.equals("8")) {
            FILE_NAME = "JT/ppt/03模式篇";

        } else if (position.equals("9")) {
            FILE_NAME = "JT/ppt/02产品篇";

        } else if (position.equals("10")) {
            FILE_NAME = "JT/ppt/01企业篇";

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
         it = new ArrayList<String>(files.length);

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            Log.e("file", String.valueOf(file));
            String ss = file.getName();
            Log.e("ss", ss);
            String rel = ss.trim().substring(3, ss.lastIndexOf("."));
            Log.e("rel", rel);
            int dd = Integer.parseInt(rel) - 1;
            Log.e("rel", String.valueOf(dd));
            if (dd == it.size()) {
                if (getImageFile(file.getPath())) {
                    it.add(dd, file.getPath());
                }

            } else {
                for (int j = 0; j < files.length; j++) {
                    File fi = files[j];
                    Log.e("file", String.valueOf(fi));
                    String s = fi.getName();
                    Log.e("ss", ss);
                    String re = s.trim().substring(3, s.lastIndexOf("."));
                    Log.e("re", re);
                    int d = Integer.parseInt(re) - 1;
                    if (d == it.size()) {
                        it.add(d, fi.getPath());
                    }
                }
            }

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
                || end.equals("jpeg") || end.equals("bmp") || end.equals("JPG")) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(PptGalleryActivity.this, GalleryDetailActivity.class);
        intent.putExtra("a", it.get(position));
        intent.putExtra("c", position);
        intent.putStringArrayListExtra("b", it);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }


}
