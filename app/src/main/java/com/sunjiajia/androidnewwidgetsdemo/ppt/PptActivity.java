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

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.itsrts.pptviewer.PPTViewer;
import com.sunjiajia.androidnewwidgetsdemo.R;


public class PptActivity extends AppCompatActivity {

    PPTViewer pptViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);

        String  position = getIntent().getStringExtra("a");
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("ppt");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pptViewer = (PPTViewer) findViewById(R.id.pptviewer);
        pptViewer.setNext_img(R.drawable.next)
                .setSettings_img(R.drawable.settings)
                .setPrev_img(R.drawable.prev)
                .setZoomin_img(R.drawable.zoomin)
                .setZoomout_img(R.drawable.zoomout);

        if(position.equals("0")){

            FILE_NAME = "/JT/ppt/11-635营销宝典.ppt";

        }else if (position.equals("1")){

            FILE_NAME = "/JT/ppt/10金天国际 基础训.ppt";
        }else if (position.equals("2")){

            FILE_NAME = "/JT/ppt/09生态保养咨询过程中需掌握的技巧.ppt";
        }else if (position.equals("3")){
            FILE_NAME = "/JT/ppt/08专业咨询需掌握的基础知识.ppt";

        }else if (position.equals("4")){
            FILE_NAME = "/JT/ppt/07讲师基本素质.ppt";

        }else if (position.equals("5")){
            FILE_NAME = "/JT/ppt/06讲师训班前训.ppt";

        }else if (position.equals("6")){
            FILE_NAME = "/JT/ppt/05十大亮点.ppt";

        }else if (position.equals("7")){
            FILE_NAME = "/JT/ppt/04十大举措.ppt";

        }else if (position.equals("8")){
            FILE_NAME = "/JT/ppt/03模式篇.pptx";

        }else if (position.equals("9")){
            FILE_NAME = "/JT/ppt/02产品篇.ppt";

        }else if (position.equals("10")) {
            FILE_NAME = "/JT/ppt/01企业篇.ppt";

        }
        pptViewer.loadPPT(this, geStorageDirectory());


    }

    private String geStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? sdPath + FILE_NAME : dataPath + FILE_NAME;


    }

    private String sdPath = Environment.getExternalStorageDirectory().getPath();
    private String FILE_NAME = "/ppt/ppt01.ppt";
    private String dataPath = null;
}
