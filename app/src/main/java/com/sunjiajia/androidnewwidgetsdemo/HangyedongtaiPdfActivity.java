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

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

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
        toolbar.setTitle("pdf");
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
                FILE_NAME = "/JT/pdf/行业动态/01“大健康产业”蛋糕有多大？一组数据告诉你！.pdf";

                break;
            case 1:

                FILE_NAME = "/JT/pdf/行业动态/02成功的直销人必须具备的六种能力.pdf";
                break;
            case 2:
                FILE_NAME = "/JT/pdf/行业动态/03从习大大和李总理在“全国卫生与健康大会”上的讲话剖析健康产业发展新趋势.pdf";

                break;
            case 3:
                FILE_NAME = "/JT/pdf/行业动态/04老百姓关心的健康问题，总书记这样说 ——专家解读习总书记在全国卫生与健康大会上讲话精神.pdf";

                break;
            case 4:

                FILE_NAME = "/JT/pdf/行业动态/05全民健康升至国家战略！拒绝直销大健康产业，就是拒绝财富和健康！.pdf";
                break;
            case 5:

                FILE_NAME = "/JT/pdf/行业动态/06未来五年，团队+系统+趋势=成功.pdf";
                break;
            case 6:
                FILE_NAME = "/JT/pdf/行业动态/07赢在金天——趋势篇.pdf";

                break;
            case 7:

                FILE_NAME = "/JT/pdf/行业动态/08赢在金天——创新篇.pdf";
                break;
            case 8:
                FILE_NAME = "/JT/pdf/行业动态/09赢在金天——实力篇（一）.pdf";

                break;
            case 9:
                FILE_NAME = "/JT/pdf/行业动态/10赢在金天——实力篇（二）.pdf";

                break;
            case 10:
                FILE_NAME = "/JT/pdf/行业动态/11赢在金天——保障篇.pdf";

                break;
            case 11:
                FILE_NAME = "/JT/pdf/行业动态/12赢在金天——责任篇.pdf";

                break;
            case 12:

                FILE_NAME = "/JT/pdf/行业动态/13这样的团队，将无所不能！.pdf";
                break;
            case 13:
                FILE_NAME = "/JT/pdf/行业动态/14政治局审议通过”健康中国2030”纲要.pdf";

                break;
            case 14:
                FILE_NAME = "/JT/pdf/行业动态/15习大大、李总理等这样评价健康产业！.pdf";

                break;
            case 15:
                FILE_NAME = "/JT/pdf/行业动态/16健康需求消费或将爆发，新兴健康产业成消费爆发点！.pdf";

                break;
            case 16:

                FILE_NAME = "/JT/pdf/行业动态/17凭什么说中国大健康产业正在经历黄金时期？.pdf";
                break;
            case 17:

                FILE_NAME = "/JT/pdf/行业动态/18成为风潮的大健康产业，好在哪里？.pdf";
                break;
            case 18:
                FILE_NAME = "/JT/pdf/行业动态/19大健康产业为什么将成热门投资领域？.pdf";

                break;
            case 19:
                FILE_NAME = "/JT/pdf/行业动态/20治未病提上国家议程，大健康产业将迎来资本盛宴！.pdf";

                break;
            case 20:
                FILE_NAME = "/JT/pdf/行业动态/21马云进军大健康产业，你看到机会了吗.pdf";

                break;
            case 21:
                FILE_NAME = "/JT/pdf/行业动态/22为什么女性生殖健康产业是未来十年最有前景的项目？.pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/行业动态/23注意：大健康已上升为国家战略！.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/行业动态/24十八个著名的心理学效应，生活中你一定用的到！.pdf";
                break;
            case 24:
                FILE_NAME = "/JT/pdf/行业动态/25一等人在保养、二等人健身锻炼、三等人进医院！.pdf";

                break;
            case 25:
                FILE_NAME = "/JT/pdf/行业动态/26女性生殖健康问题有多严重？生殖健康产业市场空间有多大？.pdf";

                break;
            case 26:

                FILE_NAME = "/JT/pdf/行业动态/27“治未病”是趋势，将影响13亿国人生活！.pdf";
                break;
            case 27:

                FILE_NAME = "/JT/pdf/行业动态/28-16万亿大健康产业，抓住财富的好时机!.pdf";
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
