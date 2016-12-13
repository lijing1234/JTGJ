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

package com.sunjiajia.androidnewwidgetsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class PdfActivity extends AppCompatActivity implements DownloadFile.Listener {
    PDFPagerAdapter adapter=null;
    RemotePDFViewPager remotePDFViewPager;
    RemotePDFViewPager remotePDFViewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("pdf");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//
        remotePDFViewPager =
                new RemotePDFViewPager(this, "http://172.17.20.44:8080/script/img02.pdf", this);
        remotePDFViewPager = (RemotePDFViewPager) findViewById(R.id.pdfViewPager);


    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        Log.e("url",url);
        Log.e("destinationPath",destinationPath);
//        FileUtil.extractFileNameFromURL("http://172.17.20.44:8080/script/02.pdf")
        if(adapter==null){

                adapter = new PDFPagerAdapter(this, destinationPath);
                remotePDFViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();


        }

    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter != null) {
            Log.e("onDestroy", "onDestroy");
            adapter.close();
        }

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }
}
