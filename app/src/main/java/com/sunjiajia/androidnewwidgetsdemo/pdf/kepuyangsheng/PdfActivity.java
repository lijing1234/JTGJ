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

package com.sunjiajia.androidnewwidgetsdemo.pdf.kepuyangsheng;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sunjiajia.androidnewwidgetsdemo.R;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class PdfActivity extends AppCompatActivity {
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
        toolbar.setTitle("科普养生");
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
                FILE_NAME = "/JT/pdf/科普养生/kp62.pdf";

                break;
            case 1:

                FILE_NAME = "/JT/pdf/科普养生/kp61.pdf";
                break;
            case 2:
                FILE_NAME = "/JT/pdf/科普养生/kp60.pdf";

                break;
            case 3:
                FILE_NAME = "/JT/pdf/科普养生/kp59.pdf";

                break;
            case 4:
                FILE_NAME = "/JT/pdf/科普养生/kp59.pdf";

                break;
            case 5:

                FILE_NAME = "/JT/pdf/科普养生/kp57.pdf";
                break;
            case 6:

                FILE_NAME = "/JT/pdf/科普养生/56私处干净=没有妇科病？这种想法大错特错！.pdf";
                break;
            case 7:
                FILE_NAME = "/JT/pdf/科普养生/kp55.pdf";

                break;
            case 8:
                FILE_NAME = "/JT/pdf/科普养生/kp54.pdf";

                break;
            case 9:

                FILE_NAME = "/JT/pdf/科普养生/kp53.pdf";
                break;
            case 10:
                FILE_NAME = "/JT/pdf/科普养生/kp52.pdf";

                break;
            case 11:
                FILE_NAME = "/JT/pdf/科普养生/kp51.pdf";

                break;
            case 12:
                FILE_NAME = "/JT/pdf/科普养生/kp50.pdf";

                break;
            case 13:

                FILE_NAME = "/JT/pdf/科普养生/kp49.pdf";
                break;
            case 14:
                FILE_NAME = "/JT/pdf/科普养生/kp48.pdf";

                break;
            case 15:

                FILE_NAME = "/JT/pdf/科普养生/47你每天是怎么醒的？这么醒来对身体伤害非常大，几乎人人中招！.pdf";
                break;
            case 16:

                FILE_NAME = "/JT/pdf/科普养生/kp46.pdf";
                break;
            case 17:
                FILE_NAME = "/JT/pdf/科普养生/kp45.pdf";

                break;
            case 18:

                FILE_NAME = "/JT/pdf/科普养生/kp44.pdf";
                break;
            case 19:

                FILE_NAME = "/JT/pdf/科普养生/kp43.pdf";
                break;
            case 20:

                FILE_NAME = "/JT/pdf/科普养生/kp42.pdf";
                break;
            case 21:
                FILE_NAME = "/JT/pdf/科普养生/kp41.pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/科普养生/kp40.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/科普养生/39-40岁以后为何会有老人臭？其实真的不是你的错！.pdf";
                break;
            case 24:
                FILE_NAME = "/JT/pdf/科普养生/38-26岁白领患卵巢癌飙泪演讲，年轻人养生真的很重要！！.pdf";

                break;
            case 25:
                FILE_NAME = "/JT/pdf/科普养生/37-“大姨妈”迟迟不走，你造为什么吗？.pdf";

                break;
            case 26:
                FILE_NAME = "/JT/pdf/科普养生/36-6个超赞的子宫保养常识，请收好！.pdf";

                break;
            case 27:
                FILE_NAME = "/JT/pdf/科普养生/kp35.pdf";

                break;
            case 28:

                FILE_NAME = "/JT/pdf/科普养生/kp34.pdf";
                break;
            case 29:
                FILE_NAME = "/JT/pdf/科普养生/kp33.pdf";

                break;
            case 30:
                FILE_NAME = "/JT/pdf/科普养生/kp32.pdf";

                break;
            case 31:

                FILE_NAME = "/JT/pdf/科普养生/kp31.pdf";

                break;
            case 32:
                FILE_NAME = "/JT/pdf/科普养生/kp30.pdf";

                break;
            case 33:

                FILE_NAME = "/JT/pdf/科普养生/kp29.pdf";
                break;
            case 34:
                FILE_NAME = "/JT/pdf/科普养生/kp28.pdf";

                break;
            case 35:

                FILE_NAME = "/JT/pdf/科普养生/kp27.pdf";
                break;
            case 36:
                FILE_NAME = "/JT/pdf/科普养生/kp26.pdf";

                break;
            case 37:
                FILE_NAME = "/JT/pdf/科普养生/kp25.pdf";

                break;
            case 38:
                FILE_NAME = "/JT/pdf/科普养生/kp24.pdf";

                break;
            case 39:

                FILE_NAME = "/JT/pdf/科普养生/kp23.pdf";
                break;
            case 40:
                FILE_NAME = "/JT/pdf/科普养生/kp22.pdf";

                break;
            case 41:

                FILE_NAME = "/JT/pdf/科普养生/kp21.pdf";
                break;
            case 42:
                FILE_NAME = "/JT/pdf/科普养生/kp20.pdf";

                break;
            case 43:
                FILE_NAME = "/JT/pdf/科普养生/kp19.pdf";

                break;
            case 44:
                FILE_NAME = "/JT/pdf/科普养生/kp18.pdf";

                break;
            case 45:
                FILE_NAME = "/JT/pdf/科普养生/kp17.pdf";

                break;
            case 46:
                FILE_NAME = "/JT/pdf/科普养生/kp16.pdf";

                break;
            case 47:
                FILE_NAME = "/JT/pdf/科普养生/kp15.pdf";

                break;
            case 48:
                FILE_NAME = "/JT/pdf/科普养生/kp14.pdf";

                break;
            case 49:
                FILE_NAME = "/JT/pdf/科普养生/kp13.pdf";

                break;
            case 50:

                FILE_NAME = "/JT/pdf/科普养生/kp12.pdf";
                break;
            case 51:
                FILE_NAME = "/JT/pdf/科普养生/kp11.pdf";

                break;
            case 52:
                FILE_NAME = "/JT/pdf/科普养生/kp10.pdf";

                break;
            case 53:
                FILE_NAME = "/JT/pdf/科普养生/kp09.pdf";

                break;
            case 54:


                FILE_NAME = "/JT/pdf/科普养生/kp08.pdf";
                break;
            case 55:
                FILE_NAME = "/JT/pdf/科普养生/kp07.pdf";

                break;
            case 56:
                FILE_NAME = "/JT/pdf/科普养生/kp06.pdf";

                break;
            case 57:

                FILE_NAME = "/JT/pdf/科普养生/05-99%的女人都做错了！！太可怕了…….pdf";
                break;
            case 58:

                FILE_NAME = "/JT/pdf/科普养生/04-75%的人都亚健康，快来测测你得多少分？超过80就得去医院.pdf";
                break;
            case 59:
                FILE_NAME = "/JT/pdf/科普养生/03-10个让身体早衰的坏习惯，你占了几个？.pdf";

                break;
            case 60:

                FILE_NAME = "/JT/pdf/科普养生/02-7种异常白带表现到底代表啥？女人一定要提高警惕！.pdf";

                break;
            case 61:

                FILE_NAME = "/JT/pdf/科普养生/01-5个痛经认知误区，让女人越来越痛！.pdf";
                break;


            default:
                break;


        }

        try {
            pdfViewPager = new PDFViewPager(this, geStorageDirectory());
            pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);
            adapter = new PDFPagerAdapter(this, geStorageDirectory());
            pdfViewPager.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (Exception e) {


        }


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
