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

package com.sunjiajia.androidnewwidgetsdemo.pdf.slide;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sunjiajia.androidnewwidgetsdemo.R;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

public class SlidePdfActivity extends AppCompatActivity {
    PDFPagerAdapter adapter = null;
    PDFViewPager pdfViewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

//        String position = getIntent().getStringExtra("a");

        int posi = getIntent().getIntExtra("a", 1);
        Log.e("position", String.valueOf(posi));
       toolbar = (Toolbar) findViewById(R.id.id_toolbar);



        switch (posi) {
            case 0:
                toolbar.setTitle("金天国际新版工具流正式上线");
                FILE_NAME = "/JT/pdf/轮播图/【工具致胜】金天国际新版工具流正式上线！.pdf";
                break;
            case 1:
                toolbar.setTitle("2016年APEC工商领导人峰会");
                FILE_NAME = "/JT/pdf/轮播图/金天国际荣耀受邀出席2016年APEC工商领导人峰会.pdf";
                break;
            case 2:
                toolbar.setTitle("“活力金天，助力中国”");
                FILE_NAME = "/JT/pdf/轮播图/【金天专题】“活力金天，助力中国”金天国际25周年梦想盛典暨公益筑梦远航精彩回顾.pdf";
                break;



            default:
                break;


        }
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pdfViewPager = new PDFViewPager(this, geStorageDirectory());
        pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);
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
