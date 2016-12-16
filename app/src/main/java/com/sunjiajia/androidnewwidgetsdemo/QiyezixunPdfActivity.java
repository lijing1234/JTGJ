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
                FILE_NAME = "/JT/pdf/企业资讯/01金天国际集团捐款800万元建立.pdf";

                break;
            case 1:

                FILE_NAME = "/JT/pdf/企业资讯/02热烈祝贺金天国际烟台金蕊、烟台天伦同获“重合同守信用企业”荣誉.pdf";
                break;
            case 2:
                FILE_NAME = "/JT/pdf/企业资讯/03恭贺生态保养技术取得重大突破.pdf";

                break;
            case 3:
                FILE_NAME = "/JT/pdf/企业资讯/04金天国际董事局主席祖明军先生当选中国“双反”联盟副理事长.pdf";

                break;
            case 4:

                FILE_NAME = "/JT/pdf/企业资讯/05《反侵权假冒年度报告》首版发行 祖明军入选双反行业专家.pdf";
                break;
            case 5:

                FILE_NAME = "/JT/pdf/企业资讯/06金天国际直销许可获商务部正式公示.pdf";
                break;
            case 6:
                FILE_NAME = "/JT/pdf/企业资讯/07金天国际大中华区总裁祖威被评为十大维权打假优秀卫士.pdf";

                break;
            case 7:

                FILE_NAME = "/JT/pdf/企业资讯/08“金天国际江苏智能化产业园开业典礼”亮点剖析.pdf";
                break;
            case 8:
                FILE_NAME = "/JT/pdf/企业资讯/09金天国际宿迁智能化产业园落成典礼圆满落幕.pdf";

                break;
            case 9:
                FILE_NAME = "/JT/pdf/企业资讯/10全国助残日：金天国际再次献爱烟台残障儿童.pdf";

                break;
            case 10:
                FILE_NAME = "/JT/pdf/企业资讯/11北京科博会开幕, 金天国际“智造”受热捧!.pdf";

                break;
            case 11:
                FILE_NAME = "/JT/pdf/企业资讯/12生态保养产业化又一壮举，“金天国际星湖半岛”项目正式启动！.pdf";

                break;
            case 12:

                FILE_NAME = "/JT/pdf/企业资讯/13热烈庆祝金天国际直销启动暨“和谐与活力”公益盛典圆满落幕.pdf";
                break;
            case 13:
                FILE_NAME = "/JT/pdf/企业资讯/14金天国际被增选为“北京民营经济发展促进会副会长单位”.pdf";

                break;
            case 14:
                FILE_NAME = "/JT/pdf/企业资讯/15“生态金天，活力绽放”暨金天国际星湖半岛旅游研讨会圆满落幕！.pdf";

                break;
            case 15:
                FILE_NAME = "/JT/pdf/企业资讯/16政府领导莅临金天国际江苏生态保养智能化产业园参观指导.pdf";

                break;
            case 16:

                FILE_NAME = "/JT/pdf/企业资讯/17烟台市经济观摩活动组莅临金天国际参观考察.pdf";
                break;
            case 17:

                FILE_NAME = "/JT/pdf/企业资讯/18金天国际生态港湾立体养生产业基地正式启动.pdf";
                break;
            case 18:
                FILE_NAME = "/JT/pdf/企业资讯/19金天国际2016新品发布会成功举办.pdf";

                break;
            case 19:
                FILE_NAME = "/JT/pdf/企业资讯/20祖明军董事长出席环骆马湖旅游产业联盟成立大会.pdf";

                break;
            case 20:
                FILE_NAME = "/JT/pdf/企业资讯/21金天国际璀璨活力之星生态保养师海选大赛华东.pdf";

                break;
            case 21:
                FILE_NAME = "/JT/pdf/企业资讯/22金天国际三维动态式特许专营模式.pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/企业资讯/23金天国际中心店招募公告.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/企业资讯/24金天国际璀璨活力之星生态保养师晋级培训会成功举办.pdf";
                break;
            case 24:
                FILE_NAME = "/JT/pdf/企业资讯/25金天国际璀璨活力之星生态保养师大赛复赛成功举办.pdf";

                break;
            case 25:
                FILE_NAME = "/JT/pdf/企业资讯/26金天国际璀璨活力之星生态保养师大赛决赛成功举办.pdf";

                break;
            case 26:

                FILE_NAME = "/JT/pdf/企业资讯/27金天国际公益纪实，用爱点燃生命，照亮梦想，让更多生命充满活力！.pdf";
                break;
            case 27:

                FILE_NAME = "/JT/pdf/企业资讯/28“筑梦金天 荣耀尊享”红酒晚宴---致英雄与王者的尊贵之礼！.pdf";
                break;
            case 28:

                FILE_NAME = "/JT/pdf/企业资讯/29【金天专题】“活力金天，助力中国”金天国际25周年梦想盛典暨公益筑梦远航精彩回顾.pdf";
                break;
            case 29:

                FILE_NAME = "/JT/pdf/企业资讯/30【央视特别报道】金天国际护苗计划：圆贫困残障儿童学习梦.pdf";
                break;
            case 30:

                FILE_NAME = "/JT/pdf/企业资讯/31【周年盛典】聆听领袖智慧箴言，见证生态保养产业化未来.pdf";
                break;
            case 31:

                FILE_NAME = "/JT/pdf/企业资讯/32【周年盛典】助力全民健康，推动全面小康！金天国际公益筑梦扬帆远航！.pdf";
                break;
            case 32:

                FILE_NAME = "/JT/pdf/企业资讯/33产业筑梦，共创共赢 ——金天国际2016领袖训成功举办.pdf";
                break;
            case 33:
                FILE_NAME = "/JT/pdf/企业资讯/34【工具致胜】金天国际新版工具流正式上线！.pdf";
                break;
            case 34:
                FILE_NAME = "/JT/pdf/企业资讯/35金天国际荣耀受邀出席2016年APEC工商领导人峰会.pdf";

                break;
            case 35:
                FILE_NAME = "/JT/pdf/企业资讯/36【聚焦APEC】金天国际代表祖明军出席中厄经贸合作论坛并发表主题演讲.pdf";

                break;
            case 36:
                FILE_NAME = "/JT/pdf/企业资讯/37【聚焦APEC】金天国际祖明军出席秘鲁投资环境介绍会.pdf";

                break;
            case 37:
                FILE_NAME = "/JT/pdf/企业资讯/38聚焦APEC，领略金天国际创新之道——技术创新.pdf";

                break;
            case 38:
                FILE_NAME = "/JT/pdf/企业资讯/39【聚焦APEC】APEC峰会盛大开启，金天国际屹立世界经济舞台！.pdf";

                break;
            case 39:
                FILE_NAME = "/JT/pdf/企业资讯/40【聚焦APEC】金天国际祖明军受邀出席APEC欢迎晚宴.pdf";

                break;
            case 40:
                FILE_NAME = "/JT/pdf/企业资讯/40【聚焦APEC】金天国际祖明军受邀出席APEC欢迎晚宴.pdf";

                break;
            case 41:
                FILE_NAME = "/JT/pdf/企业资讯/42【聚焦APEC】领略金天国际创新之道—— 模式创新.pdf";

                break;
            case 42:
                FILE_NAME = "/JT/pdf/企业资讯/43【聚焦APEC】习主席讲话引领未来经济， 金天国际“生态养生”惠及全球.pdf";

                break;
            case 43:
                FILE_NAME = "/JT/pdf/企业资讯/44【聚焦APEC】领略金天国际创新之道—— 产业创新.pdf";

                break;
            case 44:
                FILE_NAME = "/JT/pdf/企业资讯/45金天国际祖明军APEC荣耀之旅回顾.pdf";

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
