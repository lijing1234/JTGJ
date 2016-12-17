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

package com.sunjiajia.androidnewwidgetsdemo.pdf.qiyezizhi;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sunjiajia.androidnewwidgetsdemo.R;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

public class QiyezixunPdfActivity extends AppCompatActivity {
    PDFPagerAdapter adapter = null;
    PDFViewPager pdfViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

//        String position = getIntent().getStringExtra("a");

        int posi = getIntent().getIntExtra("a", 1);
//        Log.e("position", position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("企业资质");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (posi) {
            case 0:

                FILE_NAME = "/JT/pdf/企业资讯/qy45.pdf";
                break;
            case 1:

                FILE_NAME = "/JT/pdf/企业资讯/qy44.pdf";
                break;
            case 2:

                FILE_NAME = "/JT/pdf/企业资讯/qy43.pdf";
                break;
            case 3:
                FILE_NAME = "/JT/pdf/企业资讯/qy42.pdf";

                break;
            case 4:
                FILE_NAME = "/JT/pdf/企业资讯/qy40.pdf";

                break;
            case 5:

                FILE_NAME = "/JT/pdf/企业资讯/qy40.pdf";
                break;
            case 6:
                FILE_NAME = "/JT/pdf/企业资讯/qy39.pdf";

                break;
            case 7:

                FILE_NAME = "/JT/pdf/企业资讯/qy38.pdf";
                break;
            case 8:

                FILE_NAME = "/JT/pdf/企业资讯/qy37.pdf";
                break;
            case 9:

                FILE_NAME = "/JT/pdf/企业资讯/qy36.pdf";
                break;
            case 10:
                FILE_NAME = "/JT/pdf/企业资讯/qy35.pdf";

                break;
            case 11:

                FILE_NAME = "/JT/pdf/企业资讯/qy34.pdf";
                break;
            case 12:
                FILE_NAME = "/JT/pdf/企业资讯/qy33.pdf";

                break;
            case 13:
                FILE_NAME = "/JT/pdf/企业资讯/qy32.pdf";

                break;
            case 14:
                FILE_NAME = "/JT/pdf/企业资讯/31【周年盛典】聆听领袖智慧箴言，见证生态保养产业化未来.pdf";

                break;
            case 15:

                FILE_NAME = "/JT/pdf/企业资讯/qy30.pdf";
                break;
            case 16:

                FILE_NAME = "/JT/pdf/企业资讯/qy29.pdf";
                break;
            case 17:

                FILE_NAME = "/JT/pdf/企业资讯/28“筑梦金天 荣耀尊享”红酒晚宴---致英雄与王者的尊贵之礼！.pdf";
                break;
            case 18:
                FILE_NAME = "/JT/pdf/企业资讯/27金天国际公益纪实，用爱点燃生命，照亮梦想，让更多生命充满活力！.pdf";

                break;
            case 19:

                FILE_NAME = "/JT/pdf/企业资讯/qy26.pdf";
                break;
            case 20:

                FILE_NAME = "/JT/pdf/企业资讯/qy25.pdf";
                break;
            case 21:
                FILE_NAME = "/JT/pdf/企业资讯/qy24.pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/企业资讯/qy23.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/企业资讯/qy22.pdf";
                break;
            case 24:
                FILE_NAME = "/JT/pdf/企业资讯/qy21.pdf";

                break;
            case 25:
                FILE_NAME = "/JT/pdf/企业资讯/qy20.pdf";

                break;
            case 26:

                FILE_NAME = "/JT/pdf/企业资讯/qy19.pdf";
                break;
            case 27:

                FILE_NAME = "/JT/pdf/企业资讯/qy18.pdf";
                break;
            case 28:

                FILE_NAME = "/JT/pdf/企业资讯/qy17.pdf";
                break;
            case 29:

                FILE_NAME = "/JT/pdf/企业资讯/qy16.pdf";
                break;
            case 30:
                FILE_NAME = "/JT/pdf/企业资讯/qy15.pdf";

                break;
            case 31:

                FILE_NAME = "/JT/pdf/企业资讯/qy14.pdf";
                break;
            case 32:

                FILE_NAME = "/JT/pdf/企业资讯/qy13.pdf";
                break;
            case 33:
                FILE_NAME = "/JT/pdf/企业资讯/qy12.pdf";
                break;
            case 34:

                FILE_NAME = "/JT/pdf/企业资讯/qy11.pdf";
                break;
            case 35:
                FILE_NAME = "/JT/pdf/企业资讯/qy10.pdf";

                break;
            case 36:
                FILE_NAME = "/JT/pdf/企业资讯/qy09.pdf";

                break;
            case 37:

                FILE_NAME = "/JT/pdf/企业资讯/qy08.pdf";
                break;
            case 38:
                FILE_NAME = "/JT/pdf/企业资讯/qy07.pdf";

                break;
            case 39:
                FILE_NAME = "/JT/pdf/企业资讯/qy06.pdf";

                break;
            case 40:
                FILE_NAME = "/JT/pdf/企业资讯/qy05.pdf";

                break;
            case 41:
                FILE_NAME = "/JT/pdf/企业资讯/qy04.pdf";

                break;
            case 42:

                FILE_NAME = "/JT/pdf/企业资讯/qy03.pdf";
                break;
            case 43:
                FILE_NAME = "/JT/pdf/企业资讯/qy02.pdf";

                break;
            case 44:
                FILE_NAME = "/JT/pdf/企业资讯/qy01.pdf";

                break;


            default:
                break;


        }


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
