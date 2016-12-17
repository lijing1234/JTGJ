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

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sunjiajia.androidnewwidgetsdemo.R;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

public class RongYuZiZhiDetailPdfShowActivity extends AppCompatActivity {

    PDFPagerAdapter adapter = null;
    PDFViewPager pdfViewPager1;
    PDFViewPager pdfViewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

//        String position = getIntent().getStringExtra("a");

        int posi = getIntent().getIntExtra("a", 1);
//        Log.e("position", position);
         toolbar = (Toolbar) findViewById(R.id.id_toolbar);


        switch (posi) {
            case 0:
                toolbar.setTitle("产品检测报告");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "/JT/Pictures/荣誉资质/05权威检测报告/产品检测报告.pdf";

                break;
            case 1:
                toolbar.setTitle("天保得乐、雪莲保养贴、雪莲要垫荧光剂检测最新报告");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "/JT/Pictures/荣誉资质/05权威检测报告/天保得乐、雪莲保养贴、雪莲要垫荧光剂检测最新报告.pdf";
                break;
            case 2:
                toolbar.setTitle("天保得乐、雪莲生态保养检测报告");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "/JT/Pictures/荣誉资质/05权威检测报告/天保得乐、雪莲生态保养检测报告.pdf";

                break;
            case 3:
                toolbar.setTitle("卫生检测报告");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                FILE_NAME = "/JT/Pictures/荣誉资质/05权威检测报告/卫生检测报告.pdf";

                break;
            case 4:
                toolbar.setTitle("新加坡TÜV SÜD PSB检测");
                setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                FILE_NAME = "/JT/Pictures/荣誉资质/05权威检测报告/新加坡TÜV SÜD PSB检测.pdf";
                break;

            default:
                break;


        }

//        pdfViewPager1 = new PDFViewPager(this, geStorageDirectory());
        pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);
//        pdfViewPager.setId(R.id.pdfViewPager);

        adapter = new PDFPagerAdapter(this, geStorageDirectory());
        pdfViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private String geStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? sdPath + FILE_NAME : dataPath + FILE_NAME;


    }

    private String sdPath = Environment.getExternalStorageDirectory().getPath();
    private String FILE_NAME = "/Movies/02.pdf";
    private String dataPath = null;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter != null) {
            Log.e("onDestroy", "onDestroy");
//            adapter.close();
            ((PDFPagerAdapter) pdfViewPager.getAdapter()).close();
        }

    }

}