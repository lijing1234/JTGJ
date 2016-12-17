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

package com.sunjiajia.androidnewwidgetsdemo.pdf.hangyedongtai;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sunjiajia.androidnewwidgetsdemo.R;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

public class HangyedongtaiPdfActivity extends AppCompatActivity {
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
        toolbar.setTitle("行业动态");
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
                FILE_NAME = "/JT/pdf/行业动态/28-16万亿大健康产业，抓住财富的好时机!.pdf";

                break;
            case 1:
                FILE_NAME = "/JT/pdf/行业动态/hd27.pdf";

                break;
            case 2:

                FILE_NAME = "/JT/pdf/行业动态/hd26.pdf";
                break;
            case 3:

                FILE_NAME = "/JT/pdf/行业动态/hd25.pdf";
                break;
            case 4:
                FILE_NAME = "/JT/pdf/行业动态/hd24.pdf";

                break;
            case 5:
                FILE_NAME = "/JT/pdf/行业动态/hd23.pdf";

                break;
            case 6:
                FILE_NAME = "/JT/pdf/行业动态/hd22.pdf";

                break;
            case 7:
                FILE_NAME = "/JT/pdf/行业动态/hd21.pdf";

                break;
            case 8:
                FILE_NAME = "/JT/pdf/行业动态/hd20.pdf";

                break;
            case 9:
                FILE_NAME = "/JT/pdf/行业动态/hd19.pdf";

                break;
            case 10:
                FILE_NAME = "/JT/pdf/行业动态/hd18.pdf";

                break;
            case 11:
                FILE_NAME = "/JT/pdf/行业动态/hd17.pdf";

                break;
            case 12:
                FILE_NAME = "/JT/pdf/行业动态/hd16.pdf";

                break;
            case 13:
                FILE_NAME = "/JT/pdf/行业动态/hd15.pdf";

                break;
            case 14:

                FILE_NAME = "/JT/pdf/行业动态/hd14.pdf";
                break;
            case 15:

                FILE_NAME = "/JT/pdf/行业动态/hd13.pdf";
                break;
            case 16:

                FILE_NAME = "/JT/pdf/行业动态/hd12.pdf";
                break;
            case 17:

                FILE_NAME = "/JT/pdf/行业动态/hd11.pdf";
                break;
            case 18:
                FILE_NAME = "/JT/pdf/行业动态/hd10.pdf";

                break;
            case 19:

                FILE_NAME = "/JT/pdf/行业动态/hd09.pdf";
                break;
            case 20:

                FILE_NAME = "/JT/pdf/行业动态/hd08.pdf";
                break;
            case 21:
                FILE_NAME = "/JT/pdf/行业动态/hd07.pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/行业动态/hd06.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/行业动态/hd05.pdf";
                break;
            case 24:

                FILE_NAME = "/JT/pdf/行业动态/hd04.pdf";
                break;
            case 25:

                FILE_NAME = "/JT/pdf/行业动态/hd03.pdf";
                break;
            case 26:
                FILE_NAME = "/JT/pdf/行业动态/hd02.pdf";

                break;
            case 27:
                FILE_NAME = "/JT/pdf/行业动态/hd01.pdf";

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
