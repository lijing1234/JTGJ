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

import android.os.Environment;
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
                FILE_NAME = "/JT/pdf/科普养生/01-5个痛经认知误区，让女人越来越痛！.pdf";

                break;
            case 1:

                FILE_NAME = "/JT/pdf/科普养生/02-7种异常白带表现到底代表啥？女人一定要提高警惕！.pdf";
                break;
            case 2:
                FILE_NAME = "/JT/pdf/科普养生/03-10个让身体早衰的坏习惯，你占了几个？.pdf";

                break;
            case 3:
                FILE_NAME = "/JT/pdf/科普养生/04-75%的人都亚健康，快来测测你得多少分？超过80就得去医院.pdf";

                break;
            case 4:

                FILE_NAME = "/JT/pdf/科普养生/05-99%的女人都做错了！！太可怕了…….pdf";
                break;
            case 5:

                FILE_NAME = "/JT/pdf/科普养生/06备孕很久还没怀上，别怕，你可能被假性不孕蒙住了！.pdf";
                break;
            case 6:
                FILE_NAME = "/JT/pdf/科普养生/07被乳腺癌盯上的10种女人，不看后悔去吧！.pdf";

                break;
            case 7:

                FILE_NAME = "/JT/pdf/科普养生/08放倒男人的“新五毒”，看看你占了多少？.pdf";
                break;
            case 8:
                FILE_NAME = "/JT/pdf/科普养生/09撩人的味道，女人身上为什么会有体香？.pdf";

                break;
            case 9:
                FILE_NAME = "/JT/pdf/科普养生/10难怪你越来越老，就因为你老做这些事！.pdf";

                break;
            case 10:
                FILE_NAME = "/JT/pdf/科普养生/11女人保养的方子，全了！赶紧收藏起来吧！.pdf";

                break;
            case 11:
                FILE_NAME = "/JT/pdf/科普养生/12女人要懂得保护子宫，才能避免容颜早衰.pdf";

                break;
            case 12:

                FILE_NAME = "/JT/pdf/科普养生/13女人一生能承受几次人流？.pdf";
                break;
            case 13:
                FILE_NAME = "/JT/pdf/科普养生/14排毒——女人一生需要做的功课.pdf";

                break;
            case 14:
                FILE_NAME = "/JT/pdf/科普养生/15盘点女性患癌的11个信号，一定要提高警惕！.pdf";

                break;
            case 15:
                FILE_NAME = "/JT/pdf/科普养生/16切记！女人这样做竟会导致子宫移位，再不注意就晚了！.pdf";

                break;
            case 16:

                FILE_NAME = "/JT/pdf/科普养生/17清宫排阴毒，女人美丽的秘密！.pdf";
                break;
            case 17:

                FILE_NAME = "/JT/pdf/科普养生/18让女性月经彻底失调的7个坏习惯，第2条恐怕你就不知道。.pdf";
                break;
            case 18:
                FILE_NAME = "/JT/pdf/科普养生/19湿气重、危害大，湿气重易导致哪些妇科病？.pdf";

                break;
            case 19:
                FILE_NAME = "/JT/pdf/科普养生/20十女九寒！宫寒太可怕！忽视更可怕！！.pdf";

                break;
            case 20:
                FILE_NAME = "/JT/pdf/科普养生/21想漂亮？养颜先排毒 脸部10种情况暗示你该排毒.pdf";

                break;
            case 21:
                FILE_NAME = "/JT/pdf/科普养生/22阴道炎反复发作，都是因为女人忽略了这些…….pdf";

                break;
            case 22:
                FILE_NAME = "/JT/pdf/科普养生/23阴道炎你知道多少？它比你想象的更可怕！.pdf";

                break;
            case 23:

                FILE_NAME = "/JT/pdf/科普养生/24月经是女性健康的晴雨表，女性必知！.pdf";
                break;
            case 24:
                FILE_NAME = "/JT/pdf/科普养生/25月经颜色发黑原来是因为这，女人一定要重视！.pdf";

                break;
            case 25:
                FILE_NAME = "/JT/pdf/科普养生/26女人！别再透支你的生育能力！.pdf";

                break;
            case 26:

                FILE_NAME = "/JT/pdf/科普养生/27女人胸前的“炸弹”岂能一刀了之？.pdf";
                break;
            case 27:

                FILE_NAME = "/JT/pdf/科普养生/28内分泌失调对女性的伤害，不只衰老、肥胖那么简单…….pdf";
                break;
            case 28:

                FILE_NAME = "/JT/pdf/科普养生/29子宫不排毒，变成垃圾场！值得每个女人警惕！.pdf";
                break;
            case 29:
                FILE_NAME = "/JT/pdf/科普养生/30揭密：男人行不行，看他的“脸”就知道！.pdf";

                break;
            case 30:
                FILE_NAME = "/JT/pdf/科普养生/31你的脸上有张疾病图！教你从脸看健康～.pdf";

                break;
            case 31:

                FILE_NAME = "/JT/pdf/科普养生/32为什么中医总说你“湿气重”？看后恍然大悟！.pdf";

                break;
            case 32:
                FILE_NAME = "/JT/pdf/科普养生/33揭秘：女人私处液体的6个变化到底意味着什么揭秘.pdf";

                break;
            case 33:
                FILE_NAME = "/JT/pdf/科普养生/34男性性能力衰退的6大表现，一般人还不知道！.pdf";

                break;
            case 34:
                FILE_NAME = "/JT/pdf/科普养生/35痛经是子宫的求救信号，怎能一忍了之！.pdf";

                break;
            case 35:
                FILE_NAME = "/JT/pdf/科普养生/36-6个超赞的子宫保养常识，请收好！.pdf";

                break;
            case 36:
                FILE_NAME = "/JT/pdf/科普养生/37-“大姨妈”迟迟不走，你造为什么吗？.pdf";

                break;
            case 37:

                FILE_NAME = "/JT/pdf/科普养生/38-26岁白领患卵巢癌飙泪演讲，年轻人养生真的很重要！！.pdf";
                break;
            case 38:
                FILE_NAME = "/JT/pdf/科普养生/40触目惊心的人类健康现状——男性生理健康篇.pdf";

                break;
            case 39:

                FILE_NAME = "/JT/pdf/科普养生/40触目惊心的人类健康现状——男性生理健康篇.pdf";
                break;
            case 40:
                FILE_NAME = "/JT/pdf/科普养生/41从乳腺增生到乳腺癌有多远？！女人不要再无知了！.pdf";

                break;
            case 41:
                FILE_NAME = "/JT/pdf/科普养生/42关于乳房的10个健康小知识，你可能一个都不知道！.pdf";

                break;
            case 42:
                FILE_NAME = "/JT/pdf/科普养生/43警惕：女人脸上皱纹泄露的身体“机密”，太准了！.pdf";

                break;
            case 43:
                FILE_NAME = "/JT/pdf/科普养生/44男人必做8道题，看看你的身体需要“检修”吗？.pdf";

                break;
            case 44:
                FILE_NAME = "/JT/pdf/科普养生/45男人前列腺成“多事之地”，最怕这七个字…….pdf";

                break;
            case 45:
                FILE_NAME = "/JT/pdf/科普养生/46难以置信的人类年轻的现状——衰老过早来临.pdf";

                break;
            case 46:
                FILE_NAME = "/JT/pdf/科普养生/47你每天是怎么醒的？这么醒来对身体伤害非常大，几乎人人中招！.pdf";

                break;
            case 47:
                FILE_NAME = "/JT/pdf/科普养生/48女人经期绝不能踫的7种食物！一碰就痛经！.pdf";

                break;
            case 48:
                FILE_NAME = "/JT/pdf/科普养生/49女人是如何变老的？一定要认真对待！.pdf";

                break;
            case 49:
                FILE_NAME = "/JT/pdf/科普养生/50女性大姨妈来时，千万别做这12件事！.pdf";

                break;
            case 50:
                FILE_NAME = "/JT/pdf/科普养生/51女性更年期竟然可以推测！我的年龄居然是…….pdf";

                break;
            case 51:
                FILE_NAME = "/JT/pdf/科普养生/52女性肾虚比男人更危险，有这6种情况的女人要注意了…….pdf";

                break;
            case 52:
                FILE_NAME = "/JT/pdf/科普养生/53起床后的口气，不能忽视，一种口气预示一种疾病！.pdf";

                break;
            case 53:
                FILE_NAME = "/JT/pdf/科普养生/54三期保养  幸福一生.pdf";

                break;
            case 54:
                FILE_NAME = "/JT/pdf/科普养生/55十病九寒，体内寒气自测和祛除法，98%的人都说好！.pdf";


                break;
            case 55:
                FILE_NAME = "/JT/pdf/科普养生/56私处干净=没有妇科病？这种想法大错特错！.pdf";

                break;
            case 56:
                FILE_NAME = "/JT/pdf/科普养生/57阴道炎反复发作，竟是因为你忽略了这.pdf";

                break;
            case 57:
                FILE_NAME = "/JT/pdf/科普养生/59越来越没“女人味”？原来是它在捣鬼！.pdf";

                break;
            case 58:
                FILE_NAME = "/JT/pdf/科普养生/59越来越没“女人味”？原来是它在捣鬼！.pdf";

                break;
            case 59:
                FILE_NAME = "/JT/pdf/科普养生/60越懒越长寿？8大懒习惯让你年轻20岁，99%的人不知道！.pdf";

                break;
            case 60:


                FILE_NAME = "/JT/pdf/科普养生/61子宫竟然最怕它……，女人须提防4大“温柔杀手”！.pdf";
                break;
            case 61:
                FILE_NAME = "/JT/pdf/科普养生/62最伤害男人身体的六大疾病，早看早预防！.pdf";

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
//            ((PDFPagerAdapter) pdfViewPager.getAdapter()).close();
        }

    }


}
