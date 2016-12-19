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

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunjiajia.androidnewwidgetsdemo.adapter.MyRecyclerViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyStaggeredViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MypdfRecyclerViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.bean.Imageinfo;
import com.sunjiajia.androidnewwidgetsdemo.bean.ProductAllInfo;
import com.sunjiajia.androidnewwidgetsdemo.pdf.hangyedongtai.HangyedongtaiPdfActivity;
import com.sunjiajia.androidnewwidgetsdemo.pdf.kepuyangsheng.PdfActivity;
import com.sunjiajia.androidnewwidgetsdemo.pdf.qiyezizhi.QiyezixunPdfActivity;
import com.sunjiajia.androidnewwidgetsdemo.picture.huiyiwuliao.HuiYiWuLiaoActivity;
import com.sunjiajia.androidnewwidgetsdemo.picture.rongyuzixun.RongYUZiZhiDetailPictureActivity;
import com.sunjiajia.androidnewwidgetsdemo.picture.rongyuzixun.RongYuZiZhiDetailPdfActivity;
import com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai.GalleryActivity;
import com.sunjiajia.androidnewwidgetsdemo.ppt.PptActivity;
import com.sunjiajia.androidnewwidgetsdemo.utils.SnackbarUtil;
import com.sunjiajia.androidnewwidgetsdemo.video.MovieActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Monkey on 2015/6/29.
 */
public class MyFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener, MyRecyclerViewAdapter.OnItemClickListener, MypdfRecyclerViewAdapter.OnItemClickListener,
        MyStaggeredViewAdapter.OnItemClickListener {

    private View mView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;

    MypdfRecyclerViewAdapter mypdfRecyclerViewAdapter;

    private static final int MOVIE_LIST = 0;
    private static final int KEPUYANGSHENG_LIST = 1;
    private static final int HANGYEDONGTAI_LIST = 2;
    private static final int QIYEZIXUN_LIST = 3;
    private static final int PPT_LIST = 4;
    private static final int PICTURE_LIST = 5;
    private static final int RONYUZIXUN_LIST = 6;
    private static final int HUIYIWULIAO_LIST = 7;
    private static final int SPAN_COUNT = 2;
    private int flag = 0;
    List<Imageinfo> list1;
    List<Imageinfo> movielist;
    private List<ProductAllInfo> productinfo;
    List<Integer> listmovie;
    List<Integer> listppt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frag_main, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.id_swiperefreshlayout);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_recyclerview);

        flag = (int) getArguments().get("flag");
        configRecyclerView();
        attemptLeaveMsg();

        // 刷新时，指示器旋转后变化的颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.main_blue_light, R.color.main_blue_dark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void configRecyclerView() {

        switch (flag) {
            case MOVIE_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case KEPUYANGSHENG_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case HANGYEDONGTAI_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case QIYEZIXUN_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case PPT_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case PICTURE_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case RONYUZIXUN_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case HUIYIWULIAO_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
        }


    }

    private void attemptLeaveMsg() {
        switch (flag) {
            case MOVIE_LIST:
                Imageinfo movie1 = new Imageinfo();
                movie1.imagename = "金天国际2016企业宣传片";
                movie1.image = R.drawable.img01;
                Imageinfo movie2 = new Imageinfo();
                movie2.imagename = "直销启动暨“和谐与活力”公益盛典宣导片";
                movie2.image = R.drawable.img02;
                Imageinfo movie3 = new Imageinfo();
                movie3.imagename = "直销启动暨“和谐与活力”公益盛典精彩回顾";
                movie3.image = R.drawable.img03;
                Imageinfo movie4 = new Imageinfo();
                movie4.imagename = "宿迁智能化产业园落成典礼宣导片";
                movie4.image = R.drawable.img04;
                Imageinfo movie5 = new Imageinfo();
                movie5.imagename = "宿迁智能化产业园落成典礼精彩回顾";
                movie5.image = R.drawable.img05;
                Imageinfo movie6 = new Imageinfo();
                movie6.imagename = "金天国际璀璨之星讲师大赛宣导预告片";
                movie6.image = R.drawable.img06;
                Imageinfo movie7 = new Imageinfo();
                movie7.imagename = "金天国际直销启动暨“和谐与活力”公益盛典完整视频";
                movie7.image = R.drawable.img07;
                Imageinfo movie8 = new Imageinfo();
                movie8.imagename = "金天国际25周年梦想盛典暨公益筑梦远航宣导片";
                movie8.image = R.drawable.img08;
                Imageinfo movie9 = new Imageinfo();
                movie9.imagename = "金天国际25周年梦想盛典暨公益筑梦远航家人祝福";
                movie9.image = R.drawable.img09;
                Imageinfo movie10 = new Imageinfo();
                movie10.imagename = "央视七套《聚焦三农》：金天国际圆贫困残障儿童学习梦";
                movie10.image = R.drawable.img10;
                Imageinfo movie11 = new Imageinfo();
                movie11.imagename = "活力金天，助力中国——金天国际25周年梦想盛典暨公益筑梦远航精彩回顾";
                movie11.image = R.drawable.img11;
                Imageinfo movie12 = new Imageinfo();
                movie12.imagename = "《聚焦apec》金天国际董事长祖名军接受采访";
                movie12.image = R.drawable.img12;
                Imageinfo movie13 = new Imageinfo();
                movie13.imagename = "金天国际雪莲生态保&养时尚版全新上线";
                movie13.image = R.drawable.img13;


                movielist = new ArrayList<Imageinfo>();
                movielist.add(0, movie1);
                movielist.add(1, movie2);
                movielist.add(2, movie3);
                movielist.add(3, movie4);
                movielist.add(4, movie5);
                movielist.add(5, movie6);
                movielist.add(6, movie7);
                movielist.add(7, movie8);
                movielist.add(8, movie9);
                movielist.add(9, movie10);
                movielist.add(10, movie11);
                movielist.add(11, movie12);
                movielist.add(12, movie13);
                Collections.reverse(movielist);

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(movielist, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case KEPUYANGSHENG_LIST:
                Imageinfo info1 = new Imageinfo();
                info1.imagename = "5个痛经认知误区，让女人越来越痛！";
                info1.image = R.drawable.kp01;
                Imageinfo info2 = new Imageinfo();
                info2.imagename = "7种异常白带表现到底代表啥？女人一定要提高警惕！";
                info2.image = R.drawable.kp02;
                Imageinfo info3 = new Imageinfo();
                info3.imagename = "10个让身体早衰的坏习惯，你占了几个？";
                info3.image = R.drawable.kp03;
                Imageinfo info4 = new Imageinfo();
                info4.imagename = "75%的人都亚健康，快来测测你得多少分？超过80就得去医院";
                info4.image = R.drawable.kp04;
                Imageinfo info5 = new Imageinfo();
                info5.imagename = "99%的女人都做错了！！太可怕了……";
                info5.image = R.drawable.kp05;
                Imageinfo info6 = new Imageinfo();
                info6.imagename = "备孕很久还没怀上，别怕，你可能被假性不孕蒙住了！";
                info6.image = R.drawable.kp06;
                Imageinfo info7 = new Imageinfo();
                info7.imagename = "被乳腺癌盯上的10种女人，不看后悔去吧！";
                info7.image = R.drawable.kp07;
                Imageinfo info8 = new Imageinfo();
                info8.imagename = "放倒男人的“新五毒”，看看你占了多少？";
                info8.image = R.drawable.kp08;
                Imageinfo info9 = new Imageinfo();
                info9.imagename = "撩人的味道，女人身上为什么会有体香？";
                info9.image = R.drawable.kp09;
                Imageinfo info10 = new Imageinfo();
                info10.imagename = "难怪你越来越老，就因为你老做这些事！";
                info10.image = R.drawable.kp10;
                Imageinfo info11 = new Imageinfo();
                info11.imagename = "女人保养的方子，全了！赶紧收藏起来吧！";
                info11.image = R.drawable.kp11;
                Imageinfo info12 = new Imageinfo();
                info12.imagename = "女人要懂得保护子宫，才能避免容颜早衰";
                info12.image = R.drawable.kp12;
                Imageinfo info13 = new Imageinfo();
                info13.imagename = "女人一生能承受几次人流？";
                info13.image = R.drawable.kp13;
                Imageinfo info14 = new Imageinfo();
                info14.imagename = "排毒——女人一生需要做的功课";
                info14.image = R.drawable.kp14;
                Imageinfo info15 = new Imageinfo();
                info15.imagename = "盘点女性患癌的11个信号，一定要提高警惕！";
                info15.image = R.drawable.kp15;
                Imageinfo info16 = new Imageinfo();
                info16.imagename = "切记！女人这样做竟会导致子宫移位，再不注意就晚了！";
                info16.image = R.drawable.kp16;
                Imageinfo info17 = new Imageinfo();
                info17.imagename = "清宫排阴毒，女人美丽的秘密！";
                info17.image = R.drawable.kp17;
                Imageinfo info18 = new Imageinfo();
                info18.imagename = "让女性月经彻底失调的7个坏习惯，第2条恐怕你就不知道。";
                info18.image = R.drawable.kp18;
                Imageinfo info19 = new Imageinfo();
                info19.imagename = "湿气重、危害大，湿气重易导致哪些妇科病？";
                info19.image = R.drawable.kp19;
                Imageinfo info20 = new Imageinfo();
                info20.imagename = "十女九寒！宫寒太可怕！忽视更可怕！！";
                info20.image = R.drawable.kp20;
                Imageinfo info21 = new Imageinfo();
                info21.imagename = "想漂亮？养颜先排毒 脸部10种情况暗示你该排毒";
                info21.image = R.drawable.kp21;
                Imageinfo info22 = new Imageinfo();
                info22.imagename = "阴道炎反复发作，都是因为女人忽略了这些……";
                info22.image = R.drawable.kp22;
                Imageinfo info23 = new Imageinfo();
                info23.imagename = "阴道炎你知道多少？它比你想象的更可怕！";
                info23.image = R.drawable.kp23;
                Imageinfo info24 = new Imageinfo();
                info24.imagename = "月经是女性健康的晴雨表，女性必知！";
                info24.image = R.drawable.kp24;
                Imageinfo info25 = new Imageinfo();
                info25.imagename = "月经颜色发黑原来是因为这，女人一定要重视！";
                info25.image = R.drawable.kp25;
                Imageinfo info26 = new Imageinfo();
                info26.imagename = "女人！别再透支你的生育能力！";
                info26.image = R.drawable.kp26;
                Imageinfo info27 = new Imageinfo();
                info27.imagename = "女人胸前的“炸弹”岂能一刀了之？";
                info27.image = R.drawable.kp27;
                Imageinfo info28 = new Imageinfo();
                info28.imagename = "内分泌失调对女性的伤害，不只衰老、肥胖那么简单……";
                info28.image = R.drawable.kp28;
                Imageinfo info29 = new Imageinfo();
                info29.imagename = "子宫不排毒，变成垃圾场！值得每个女人警惕！";
                info29.image = R.drawable.kp29;
                Imageinfo info30 = new Imageinfo();
                info30.imagename = "揭密：男人行不行，看他的“脸”就知道！";
                info30.image = R.drawable.kp30;
                Imageinfo info31 = new Imageinfo();
                info31.imagename = "你的脸上有张疾病图！教你从脸看健康～";
                info31.image = R.drawable.kp31;
                Imageinfo info32 = new Imageinfo();
                info32.imagename = "为什么中医总说你“湿气重”？看后恍然大悟！";
                info32.image = R.drawable.kp32;
                Imageinfo info33 = new Imageinfo();
                info33.imagename = "揭秘：女人私处液体的6个变化到底意味着什么揭秘";
                info33.image = R.drawable.kp33;
                Imageinfo info34 = new Imageinfo();
                info34.imagename = "男性性能力衰退的6大表现，一般人还不知道！";
                info34.image = R.drawable.kp34;
                Imageinfo info35 = new Imageinfo();
                info35.imagename = "痛经是子宫的求救信号，怎能一忍了之！";
                info35.image = R.drawable.kp35;
                Imageinfo info36 = new Imageinfo();
                info36.imagename = "6个超赞的子宫保养常识，请收好！";
                info36.image = R.drawable.kp36;
                Imageinfo info37 = new Imageinfo();
                info37.imagename = "“大姨妈”迟迟不走，你造为什么吗？";
                info37.image = R.drawable.kp37;
                Imageinfo info38 = new Imageinfo();
                info38.imagename = "26岁白领患卵巢癌飙泪演讲，年轻人养生真的很重要！！";
                info38.image = R.drawable.kp38;
                Imageinfo info39 = new Imageinfo();
                info39.imagename = "40岁以后为何会有老人臭？其实真的不是你的错！";
                info39.image = R.drawable.kp39;
                Imageinfo info40 = new Imageinfo();
                info40.imagename = "触目惊心的人类健康现状——男性生理健康篇";
                info40.image = R.drawable.kp40;
                Imageinfo info41 = new Imageinfo();
                info41.imagename = "从乳腺增生到乳腺癌有多远？！女人不要再无知了！";
                info41.image = R.drawable.kp41;
                Imageinfo info42 = new Imageinfo();
                info42.imagename = "关于乳房的10个健康小知识，你可能一个都不知道！";
                info42.image = R.drawable.kp42;
                Imageinfo info43 = new Imageinfo();
                info43.imagename = "警惕：女人脸上皱纹泄露的身体“机密”，太准了！";
                info43.image = R.drawable.kp43;
                Imageinfo info44 = new Imageinfo();
                info44.imagename = "男人必做8道题，看看你的身体需要“检修”吗？";
                info44.image = R.drawable.kp44;
                Imageinfo info45 = new Imageinfo();
                info45.imagename = "男人前列腺成“多事之地”，最怕这七个字……";
                info45.image = R.drawable.kp45;
                Imageinfo info46 = new Imageinfo();
                info46.imagename = "难以置信的人类年轻的现状——衰老过早来临";
                info46.image = R.drawable.kp46;
                Imageinfo info47 = new Imageinfo();
                info47.imagename = "你每天是怎么醒的？这么醒来对身体伤害非常大，几乎人人中招！";
                info47.image = R.drawable.kp46;
                Imageinfo info48 = new Imageinfo();
                info48.imagename = "女人经期绝不能踫的7种食物！一碰就痛经！";
                info48.image = R.drawable.kp48;
                Imageinfo info49 = new Imageinfo();
                info49.imagename = "女人是如何变老的？一定要认真对待！";
                info49.image = R.drawable.kp49;
                Imageinfo info50 = new Imageinfo();
                info50.imagename = "女性大姨妈来时，千万别做这12件事！";
                info50.image = R.drawable.kp50;
                Imageinfo info51 = new Imageinfo();
                info51.imagename = "女性更年期竟然可以推测！我的年龄居然是……";
                info51.image = R.drawable.kp51;
                Imageinfo info52 = new Imageinfo();
                info52.imagename = "女性肾虚比男人更危险，有这6种情况的女人要注意了……";
                info52.image = R.drawable.kp52;
                Imageinfo info53 = new Imageinfo();
                info53.imagename = "起床后的口气，不能忽视，一种口气预示一种疾病！";
                info53.image = R.drawable.kp53;
                Imageinfo info54 = new Imageinfo();
                info54.imagename = "三期保养  幸福一生";
                info54.image = R.drawable.kp54;
                Imageinfo info55 = new Imageinfo();
                info55.imagename = "十病九寒，体内寒气自测和祛除法，98%的人都说好！";
                info55.image = R.drawable.kp55;
                Imageinfo info56 = new Imageinfo();
                info56.imagename = "私处干净=没有妇科病？这种想法大错特错！";
                info56.image = R.drawable.kp55;
                Imageinfo info57 = new Imageinfo();
                info57.imagename = "阴道炎反复发作，竟是因为你忽略了这";
                info57.image = R.drawable.kp57;
                Imageinfo info58 = new Imageinfo();
                info58.imagename = "月经量少会影响怀孕吗？经量多少才算少";
                info58.image = R.drawable.kp58;
                Imageinfo info59 = new Imageinfo();
                info59.imagename = "越来越没“女人味”？原来是它在捣鬼！";
                info59.image = R.drawable.kp59;
                Imageinfo info60 = new Imageinfo();
                info60.imagename = "越懒越长寿？8大懒习惯让你年轻20岁，99%的人不知道！";
                info60.image = R.drawable.kp60;
                Imageinfo info61 = new Imageinfo();
                info61.imagename = "子宫竟然最怕它……，女人须提防4大“温柔杀手”！";
                info61.image = R.drawable.kp61;
                Imageinfo info62 = new Imageinfo();
                info62.imagename = "最伤害男人身体的六大疾病，早看早预防！";
                info62.image = R.drawable.kp62;


                list1 = new ArrayList<Imageinfo>();
                list1.add(0, info1);
                list1.add(1, info2);
                list1.add(2, info3);
                list1.add(3, info4);
                list1.add(4, info5);
                list1.add(5, info6);
                list1.add(6, info7);
                list1.add(7, info8);
                list1.add(8, info9);
                list1.add(9, info10);
                list1.add(10, info11);
                list1.add(11, info12);
                list1.add(12, info13);
                list1.add(13, info14);
                list1.add(14, info15);
                list1.add(15, info16);
                list1.add(16, info17);
                list1.add(17, info18);
                list1.add(18, info19);
                list1.add(19, info20);
                list1.add(20, info21);
                list1.add(21, info22);
                list1.add(22, info23);
                list1.add(23, info24);
                list1.add(24, info25);
                list1.add(25, info26);
                list1.add(26, info27);
                list1.add(27, info28);
                list1.add(28, info29);
                list1.add(29, info30);
                list1.add(30, info31);
                list1.add(31, info32);
                list1.add(32, info33);
                list1.add(33, info34);
                list1.add(34, info35);
                list1.add(35, info36);
                list1.add(36, info37);
                list1.add(37, info38);
                list1.add(38, info39);
                list1.add(39, info40);
                list1.add(40, info41);
                list1.add(41, info42);
                list1.add(42, info43);
                list1.add(43, info44);
                list1.add(44, info45);
                list1.add(45, info46);
                list1.add(46, info47);
                list1.add(47, info48);
                list1.add(48, info49);
                list1.add(49, info50);
                list1.add(50, info51);
                list1.add(51, info52);
                list1.add(52, info53);
                list1.add(53, info54);
                list1.add(54, info55);
                list1.add(55, info56);
                list1.add(56, info57);
                list1.add(57, info58);
                list1.add(58, info59);
                list1.add(59, info60);
                list1.add(60, info61);
                list1.add(61, info62);
                Collections.reverse(list1);
                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case HANGYEDONGTAI_LIST:
                Imageinfo hangyedongtai1 = new Imageinfo();
                hangyedongtai1.imagename = "“大健康产业”蛋糕有多大？一组数据告诉你！";
                hangyedongtai1.image = R.drawable.hd01;
                Imageinfo hangyedongtai2 = new Imageinfo();
                hangyedongtai2.imagename = "成功的直销人必须具备的六种能力";
                hangyedongtai2.image = R.drawable.hd02;
                Imageinfo hangyedongtai3 = new Imageinfo();
                hangyedongtai3.imagename = "从习大大和李总理在“全国卫生与健康大会”上的讲话剖析健康产业发展新趋势";
                hangyedongtai3.image = R.drawable.hd03;
                Imageinfo hangyedongtai4 = new Imageinfo();
                hangyedongtai4.imagename = "老百姓关心的健康问题，总书记这样说 ——专家解读习总书记在全国卫生与健康大会上讲话精神";
                hangyedongtai4.image = R.drawable.hd04;
                Imageinfo hangyedongtai5 = new Imageinfo();
                hangyedongtai5.imagename = "全民健康升至国家战略！拒绝直销大健康产业，就是拒绝财富和健康！";
                hangyedongtai5.image = R.drawable.hd05;
                Imageinfo hangyedongtai6 = new Imageinfo();
                hangyedongtai6.imagename = "未来五年，团队+系统+趋势=成功";
                hangyedongtai6.image = R.drawable.hd06;
                Imageinfo hangyedongtai7 = new Imageinfo();
                hangyedongtai7.imagename = "赢在金天——趋势篇";
                hangyedongtai7.image = R.drawable.hd07;
                Imageinfo hangyedongtai8 = new Imageinfo();
                hangyedongtai8.imagename = "赢在金天——创新篇";
                hangyedongtai8.image = R.drawable.hd08;
                Imageinfo hangyedongtai9 = new Imageinfo();
                hangyedongtai9.imagename = "赢在金天——实力篇（一）";
                hangyedongtai9.image = R.drawable.hd09;
                Imageinfo hangyedongt10 = new Imageinfo();
                hangyedongt10.imagename = "赢在金天——实力篇（二）";
                hangyedongt10.image = R.drawable.hd10;
                Imageinfo hangyedongt11 = new Imageinfo();
                hangyedongt11.imagename = "赢在金天——保障篇";
                hangyedongt11.image = R.drawable.hd11;
                Imageinfo hangyedongt12 = new Imageinfo();
                hangyedongt12.imagename = "赢在金天——责任篇";
                hangyedongt12.image = R.drawable.hd12;
                Imageinfo hangyedongt13 = new Imageinfo();
                hangyedongt13.imagename = "这样的团队，将无所不能！";
                hangyedongt13.image = R.drawable.hd13;
                Imageinfo hangyedongt14 = new Imageinfo();
                hangyedongt14.imagename = "政治局审议通过”健康中国2030”纲要";
                hangyedongt14.image = R.drawable.hd14;
                Imageinfo hangyedongt15 = new Imageinfo();
                hangyedongt15.imagename = "习大大、李总理等这样评价健康产业！";
                hangyedongt15.image = R.drawable.hd15;
                Imageinfo hangyedongt16 = new Imageinfo();
                hangyedongt16.imagename = "健康需求消费或将爆发，新兴健康产业成消费爆发点！";
                hangyedongt16.image = R.drawable.hd16;
                Imageinfo hangyedongt17 = new Imageinfo();
                hangyedongt17.imagename = "凭什么说中国大健康产业正在经历黄金时期？";
                hangyedongt17.image = R.drawable.hd17;
                Imageinfo hangyedongt18 = new Imageinfo();
                hangyedongt18.imagename = "成为风潮的大健康产业，好在哪里？";
                hangyedongt18.image = R.drawable.hd18;
                Imageinfo hangyedongt19 = new Imageinfo();
                hangyedongt19.imagename = "大健康产业为什么将成热门投资领域？";
                hangyedongt19.image = R.drawable.hd19;
                Imageinfo hangyedongt20 = new Imageinfo();
                hangyedongt20.imagename = "治未病提上国家议程，大健康产业将迎来资本盛宴！";
                hangyedongt20.image = R.drawable.hd20;
                Imageinfo hangyedongt21 = new Imageinfo();
                hangyedongt21.imagename = "马云进军大健康产业，你看到机会了吗";
                hangyedongt21.image = R.drawable.hd21;
                Imageinfo hangyedongt22 = new Imageinfo();
                hangyedongt22.imagename = "为什么女性生殖健康产业是未来十年最有前景的项目？";
                hangyedongt22.image = R.drawable.hd22;
                Imageinfo hangyedongt23 = new Imageinfo();
                hangyedongt23.imagename = "注意：大健康已上升为国家战略！";
                hangyedongt23.image = R.drawable.hd23;
                Imageinfo hangyedongt24 = new Imageinfo();
                hangyedongt24.imagename = "十八个著名的心理学效应，生活中你一定用的到！";
                hangyedongt24.image = R.drawable.hd24;
                Imageinfo hangyedongt25 = new Imageinfo();
                hangyedongt25.imagename = "一等人在保养、二等人健身锻炼、三等人进医院！";
                hangyedongt25.image = R.drawable.hd25;
                Imageinfo hangyedongt26 = new Imageinfo();
                hangyedongt26.imagename = "女性生殖健康问题有多严重？生殖健康产业市场空间有多大？";
                hangyedongt26.image = R.drawable.hd26;
                Imageinfo hangyedongt27 = new Imageinfo();
                hangyedongt27.imagename = "“治未病”是趋势，将影响13亿国人生活！";
                hangyedongt27.image = R.drawable.hd27;
                Imageinfo hangyedongt28 = new Imageinfo();
                hangyedongt28.imagename = "16万亿大健康产业，抓住财富的好时机!";
                hangyedongt28.image = R.drawable.hd28;


                list1 = new ArrayList<Imageinfo>();
                list1.add(0, hangyedongtai1);
                list1.add(1, hangyedongtai2);
                list1.add(2, hangyedongtai3);
                list1.add(3, hangyedongtai4);
                list1.add(4, hangyedongtai5);
                list1.add(5, hangyedongtai6);
                list1.add(6, hangyedongtai7);
                list1.add(7, hangyedongtai8);
                list1.add(8, hangyedongtai9);
                list1.add(9, hangyedongt10);
                list1.add(10, hangyedongt11);
                list1.add(11, hangyedongt12);
                list1.add(12, hangyedongt13);
                list1.add(13, hangyedongt14);
                list1.add(14, hangyedongt15);
                list1.add(15, hangyedongt16);
                list1.add(16, hangyedongt17);
                list1.add(17, hangyedongt18);
                list1.add(18, hangyedongt19);
                list1.add(19, hangyedongt20);
                list1.add(20, hangyedongt21);
                list1.add(21, hangyedongt22);
                list1.add(22, hangyedongt23);
                list1.add(23, hangyedongt24);
                list1.add(24, hangyedongt25);
                list1.add(25, hangyedongt26);
                list1.add(26, hangyedongt27);
                list1.add(27, hangyedongt28);
                Collections.reverse(list1);
                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case QIYEZIXUN_LIST:
                Imageinfo qiyezixun1 = new Imageinfo();
                qiyezixun1.imagename = "金天国际集团捐款800万元建立";
                qiyezixun1.image = R.drawable.qy01;
                Imageinfo qiyezixun2 = new Imageinfo();
                qiyezixun2.imagename = "热烈祝贺金天国际烟台金蕊、烟台天伦同获“重合同守信用企业”荣誉";
                qiyezixun2.image = R.drawable.qy02;
                Imageinfo qiyezixun3 = new Imageinfo();
                qiyezixun3.imagename = "恭贺生态保养技术取得重大突破";
                qiyezixun3.image = R.drawable.qy03;
                Imageinfo qiyezixun4 = new Imageinfo();
                qiyezixun4.imagename = "金天国际董事局主席祖明军先生当选中国“双反”联盟副理事长";
                qiyezixun4.image = R.drawable.qy04;
                Imageinfo qiyezixun5 = new Imageinfo();
                qiyezixun5.imagename = "《反侵权假冒年度报告》首版发行 祖明军入选双反行业专家";
                qiyezixun5.image = R.drawable.qy05;
                Imageinfo qiyezixun6 = new Imageinfo();
                qiyezixun6.imagename = "金天国际直销许可获商务部正式公示";
                qiyezixun6.image = R.drawable.qy06;
                Imageinfo qiyezixun7 = new Imageinfo();
                qiyezixun7.imagename = "金天国际大中华区总裁祖威被评为十大维权打假优秀卫士";
                qiyezixun7.image = R.drawable.qy07;
                Imageinfo qiyezixun8 = new Imageinfo();
                qiyezixun8.imagename = "“金天国际江苏智能化产业园开业典礼”亮点剖析";
                qiyezixun8.image = R.drawable.qy08;
                Imageinfo qiyezixun9 = new Imageinfo();
                qiyezixun9.imagename = "金天国际宿迁智能化产业园落成典礼圆满落幕";
                qiyezixun9.image = R.drawable.qy09;
                Imageinfo qiyezixun10 = new Imageinfo();
                qiyezixun10.imagename = "全国助残日：金天国际再次献爱烟台残障儿童";
                qiyezixun10.image = R.drawable.qy10;
                Imageinfo qiyezixun11 = new Imageinfo();
                qiyezixun11.imagename = "北京科博会开幕, 金天国际“智造”受热捧!";
                qiyezixun11.image = R.drawable.qy11;
                Imageinfo qiyezixun12 = new Imageinfo();
                qiyezixun12.imagename = "生态保养产业化又一壮举，“金天国际星湖半岛”项目正式启动！";
                qiyezixun12.image = R.drawable.qy12;
                Imageinfo qiyezixun13 = new Imageinfo();
                qiyezixun13.imagename = "热烈庆祝金天国际直销启动暨“和谐与活力”公益盛典圆满落幕";
                qiyezixun13.image = R.drawable.qy13;
                Imageinfo qiyezixun14 = new Imageinfo();
                qiyezixun14.imagename = "金天国际被增选为“北京民营经济发展促进会副会长单位”";
                qiyezixun14.image = R.drawable.qy14;
                Imageinfo qiyezixun15 = new Imageinfo();
                qiyezixun15.imagename = "“生态金天，活力绽放”暨金天国际星湖半岛旅游研讨会圆满落幕！";
                qiyezixun15.image = R.drawable.qy15;
                Imageinfo qiyezixun16 = new Imageinfo();
                qiyezixun16.imagename = "政府领导莅临金天国际江苏生态保养智能化产业园参观指导";
                qiyezixun16.image = R.drawable.qy16;
                Imageinfo qiyezixun17 = new Imageinfo();
                qiyezixun17.imagename = "烟台市经济观摩活动组莅临金天国际参观考察";
                qiyezixun17.image = R.drawable.qy17;
                Imageinfo qiyezixun18 = new Imageinfo();
                qiyezixun18.imagename = "金天国际生态港湾立体养生产业基地正式启动";
                qiyezixun18.image = R.drawable.qy18;
                Imageinfo qiyezixun19 = new Imageinfo();
                qiyezixun19.imagename = "金天国际2016新品发布会成功举办";
                qiyezixun19.image = R.drawable.qy19;
                Imageinfo qiyezixun20 = new Imageinfo();
                qiyezixun20.imagename = "祖明军董事长出席环骆马湖旅游产业联盟成立大会";
                qiyezixun20.image = R.drawable.qy20;
                Imageinfo qiyezixun21 = new Imageinfo();
                qiyezixun21.imagename = "金天国际璀璨活力之星生态保养师海选大赛华东";
                qiyezixun21.image = R.drawable.qy21;
                Imageinfo qiyezixun22 = new Imageinfo();
                qiyezixun22.imagename = "金天国际三维动态式特许专营模式";
                qiyezixun22.image = R.drawable.qy22;
                Imageinfo qiyezixun23 = new Imageinfo();
                qiyezixun23.imagename = "金天国际中心店招募公告";
                qiyezixun23.image = R.drawable.qy23;
                Imageinfo qiyezixun24 = new Imageinfo();
                qiyezixun24.imagename = "金天国际璀璨活力之星生态保养师晋级培训会成功举办";
                qiyezixun24.image = R.drawable.qy24;
                Imageinfo qiyezixun25 = new Imageinfo();
                qiyezixun25.imagename = "金天国际璀璨活力之星生态保养师大赛复赛成功举办";
                qiyezixun25.image = R.drawable.qy25;
                Imageinfo qiyezixun26 = new Imageinfo();
                qiyezixun26.imagename = "金天国际璀璨活力之星生态保养师大赛决赛成功举办";
                qiyezixun26.image = R.drawable.qy26;
                Imageinfo qiyezixun27 = new Imageinfo();
                qiyezixun27.imagename = "金天国际公益纪实，用爱点燃生命，照亮梦想，让更多生命充满活力！";
                qiyezixun27.image = R.drawable.qy27;
                Imageinfo qiyezixun28 = new Imageinfo();
                qiyezixun28.imagename = "“筑梦金天 荣耀尊享”红酒晚宴---致英雄与王者的尊贵之礼！";
                qiyezixun28.image = R.drawable.qy28;
                Imageinfo qiyezixun29 = new Imageinfo();
                qiyezixun29.imagename = "【金天专题】“活力金天，助力中国”金天国际25周年梦想盛典暨公益筑梦远航精彩回顾";
                qiyezixun29.image = R.drawable.qy29;
                Imageinfo qiyezixun30 = new Imageinfo();
                qiyezixun30.imagename = "【央视特别报道】金天国际护苗计划：圆贫困残障儿童学习梦";
                qiyezixun30.image = R.drawable.qy30;
                Imageinfo qiyezixun31 = new Imageinfo();
                qiyezixun31.imagename = "【周年盛典】聆听领袖智慧箴言，见证生态保养产业化未来";
                qiyezixun31.image = R.drawable.qy31;
                Imageinfo qiyezixun32 = new Imageinfo();
                qiyezixun32.imagename = "【周年盛典】助力全民健康，推动全面小康！金天国际公益筑梦扬帆远航！";
                qiyezixun32.image = R.drawable.qy32;
                Imageinfo qiyezixun33 = new Imageinfo();
                qiyezixun33.imagename = "产业筑梦，共创共赢 ——金天国际2016领袖训成功举办";
                qiyezixun33.image = R.drawable.qy33;
                Imageinfo qiyezixun34 = new Imageinfo();
                qiyezixun34.imagename = "【工具致胜】金天国际新版工具流正式上线！";
                qiyezixun34.image = R.drawable.qy34;
                Imageinfo qiyezixun35 = new Imageinfo();
                qiyezixun35.imagename = "金天国际荣耀受邀出席2016年APEC工商领导人峰会";
                qiyezixun35.image = R.drawable.qy35;
                Imageinfo qiyezixun36 = new Imageinfo();
                qiyezixun36.imagename = "【聚焦APEC】金天国际代表祖明军出席中厄经贸合作论坛并发表主题演讲";
                qiyezixun36.image = R.drawable.qy36;
                Imageinfo qiyezixun37 = new Imageinfo();
                qiyezixun37.imagename = "【聚焦APEC】金天国际祖明军出席秘鲁投资环境介绍会";
                qiyezixun37.image = R.drawable.qy37;
                Imageinfo qiyezixun38 = new Imageinfo();
                qiyezixun38.imagename = "聚焦APEC，领略金天国际创新之道——技术创新";
                qiyezixun38.image = R.drawable.qy38;
                Imageinfo qiyezixun39 = new Imageinfo();
                qiyezixun39.imagename = "【聚焦APEC】APEC峰会盛大开启，金天国际屹立世界经济舞台！";
                qiyezixun39.image = R.drawable.qy39;
                Imageinfo qiyezixun40 = new Imageinfo();
                qiyezixun40.imagename = "【聚焦APEC】金天国际祖明军受邀出席APEC欢迎晚宴";
                qiyezixun40.image = R.drawable.qy40;
                Imageinfo qiyezixun41 = new Imageinfo();
                qiyezixun41.imagename = "聚焦APEC，领略金天国际创新之道——产品创新";
                qiyezixun41.image = R.drawable.qy41;
                Imageinfo qiyezixun42 = new Imageinfo();
                qiyezixun42.imagename = "【聚焦APEC】领略金天国际创新之道—— 模式创新";
                qiyezixun42.image = R.drawable.qy42;
                Imageinfo qiyezixun43 = new Imageinfo();
                qiyezixun43.imagename = "【聚焦APEC】习主席讲话引领未来经济， 金天国际“生态养生”惠及全球";
                qiyezixun43.image = R.drawable.qy43;
                Imageinfo qiyezixun44 = new Imageinfo();
                qiyezixun44.imagename = "【聚焦APEC】领略金天国际创新之道—— 产业创新";
                qiyezixun44.image = R.drawable.qy44;
                Imageinfo qiyezixun45 = new Imageinfo();
                qiyezixun45.imagename = "金天国际祖明军APEC荣耀之旅回顾";
                qiyezixun45.image = R.drawable.qy45;
                list1 = new ArrayList<Imageinfo>();
                list1.add(0, qiyezixun1);
                list1.add(1, qiyezixun2);
                list1.add(2, qiyezixun3);
                list1.add(3, qiyezixun4);
                list1.add(4, qiyezixun5);
                list1.add(5, qiyezixun6);
                list1.add(6, qiyezixun7);
                list1.add(7, qiyezixun8);
                list1.add(8, qiyezixun9);
                list1.add(9, qiyezixun10);
                list1.add(10, qiyezixun11);
                list1.add(11, qiyezixun12);
                list1.add(12, qiyezixun13);
                list1.add(13, qiyezixun14);
                list1.add(14, qiyezixun15);
                list1.add(15, qiyezixun16);
                list1.add(16, qiyezixun17);
                list1.add(17, qiyezixun18);
                list1.add(18, qiyezixun19);
                list1.add(19, qiyezixun20);
                list1.add(20, qiyezixun21);
                list1.add(21, qiyezixun22);
                list1.add(22, qiyezixun23);
                list1.add(23, qiyezixun24);
                list1.add(24, qiyezixun25);
                list1.add(25, qiyezixun26);
                list1.add(26, qiyezixun27);
                list1.add(27, qiyezixun28);
                list1.add(28, qiyezixun29);
                list1.add(29, qiyezixun30);
                list1.add(30, qiyezixun31);
                list1.add(31, qiyezixun32);
                list1.add(32, qiyezixun33);
                list1.add(33, qiyezixun34);
                list1.add(34, qiyezixun35);
                list1.add(35, qiyezixun36);
                list1.add(36, qiyezixun37);
                list1.add(37, qiyezixun38);
                list1.add(38, qiyezixun39);
                list1.add(39, qiyezixun40);
                list1.add(40, qiyezixun41);
                list1.add(41, qiyezixun42);
                list1.add(42, qiyezixun43);
                list1.add(43, qiyezixun44);
                list1.add(44, qiyezixun45);
                Collections.reverse(list1);
                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case PPT_LIST:



                Imageinfo ppt1 = new Imageinfo();
                ppt1.imagename = "企业篇";
                ppt1.image = R.drawable.ppt01;
                Imageinfo ppt2 = new Imageinfo();
                ppt2.imagename = "产品篇";
                ppt2.image = R.drawable.ppt02;
                Imageinfo ppt3 = new Imageinfo();
                ppt3.imagename = "模式篇";
                ppt3.image = R.drawable.ppt03;
                Imageinfo ppt4 = new Imageinfo();
                ppt4.imagename = "十大举措";
                ppt4.image = R.drawable.ppt04;
                Imageinfo ppt5 = new Imageinfo();
                ppt5.imagename = "十大亮点";
                ppt5.image = R.drawable.ppt05;
                Imageinfo ppt6 = new Imageinfo();
                ppt6.imagename = "讲师训班前训";
                ppt6.image = R.drawable.ppt06;
                Imageinfo ppt7 = new Imageinfo();
                ppt7.imagename = "讲师基本素质";
                ppt7.image = R.drawable.ppt07;
                Imageinfo ppt8 = new Imageinfo();
                ppt8.imagename = "专业咨询需掌握的基础知识";
                ppt8.image = R.drawable.ppt08;
                Imageinfo ppt9 = new Imageinfo();
                ppt9.imagename = "生态保养咨询过程中需掌握的技巧和方法";
                ppt9.image = R.drawable.ppt09;
                Imageinfo ppt10 = new Imageinfo();
                ppt10.imagename = "金天国际 基础训";
                ppt10.image = R.drawable.ppt10;
                Imageinfo ppt11 = new Imageinfo();
                ppt11.imagename = "635营销宝典";
                ppt11.image = R.drawable.ppt11;

                list1 = new ArrayList<Imageinfo>();
                list1.add(0, ppt1);
                list1.add(1, ppt2);
                list1.add(2, ppt3);
                list1.add(3, ppt4);
                list1.add(4, ppt5);
                list1.add(5, ppt6);
                list1.add(6, ppt7);
                list1.add(7, ppt8);
                list1.add(8, ppt9);
                list1.add(9, ppt10);
                list1.add(10, ppt11);
                Collections.reverse(list1);

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case PICTURE_LIST:
                Imageinfo picture1 = new Imageinfo();
                picture1.imagename = "办公环境";
                picture1.image = R.drawable.pc01;
                Imageinfo picture2 = new Imageinfo();
                picture2.imagename = "生产基地";
                picture2.image = R.drawable.pc02;
                Imageinfo picture3 = new Imageinfo();
                picture3.imagename = "星湖半岛";
                picture3.image = R.drawable.pc03;
                Imageinfo picture4 = new Imageinfo();
                picture4.imagename = "培训基地";
                picture4.image = R.drawable.pc04;
                Imageinfo picture5 = new Imageinfo();
                picture5.imagename = "金天国际直销启动暨“和谐与活力”公益盛典";
                picture5.image = R.drawable.pc05;
                Imageinfo picture6 = new Imageinfo();
                picture6.imagename = "金天国际2015年度优秀领导人表彰暨获牌盛典";
                picture6.image = R.drawable.pc06;
                Imageinfo picture7 = new Imageinfo();
                picture7.imagename = "金天国际宿迁智能化产业园落成典礼";
                picture7.image = R.drawable.pc07;
                Imageinfo picture8 = new Imageinfo();
                picture8.imagename = "金天国际25周年梦想盛典暨公益筑梦远航";
                picture8.image = R.drawable.pc08;


                list1 = new ArrayList<Imageinfo>();
                list1.add(0, picture1);
                list1.add(1, picture2);
                list1.add(2, picture3);
                list1.add(3, picture4);
                list1.add(4, picture5);
                list1.add(5, picture6);
                list1.add(6, picture7);
                list1.add(7, picture8);
                Collections.reverse(list1);


                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case RONYUZIXUN_LIST:
                //改完
                Imageinfo rngyuzixun1 = new Imageinfo();
                rngyuzixun1.imagename = "企业商标专利";
                rngyuzixun1.image = R.drawable.rz01;
                Imageinfo rngyuzixun2 = new Imageinfo();
                rngyuzixun2.imagename = "企业经营资质";
                rngyuzixun2.image = R.drawable.rz02;
                Imageinfo rngyuzixun3 = new Imageinfo();
                rngyuzixun3.imagename = "企业荣誉";
                rngyuzixun3.image = R.drawable.rz03;
                Imageinfo rngyuzixun4 = new Imageinfo();
                rngyuzixun4.imagename = "产品荣誉";
                rngyuzixun4.image = R.drawable.rz04;
                Imageinfo rngyuzixun5 = new Imageinfo();
                rngyuzixun5.imagename = "权威检测报告";
                rngyuzixun5.image = R.drawable.rz05;


                list1 = new ArrayList<Imageinfo>();
                list1.add(0, rngyuzixun1);
                list1.add(1, rngyuzixun2);
                list1.add(2, rngyuzixun3);
                list1.add(3, rngyuzixun4);
                list1.add(4, rngyuzixun5);



                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case HUIYIWULIAO_LIST:
                //改完
                Imageinfo huiyiwuliao1 = new Imageinfo();
                huiyiwuliao1.imagename = "店主培训会";
                huiyiwuliao1.image = R.drawable.wa1;
                Imageinfo huiyiwuliao2 = new Imageinfo();
                huiyiwuliao2.imagename = "公益讲座";
                huiyiwuliao2.image = R.drawable.wa2;

                list1 = new ArrayList<Imageinfo>();
                list1.add(0, huiyiwuliao1);
                list1.add(1, huiyiwuliao2);
                Collections.reverse(list1);

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            default:
                break;
        }

    }


    @Override
    public void onRefresh() {

        // 刷新时模拟数据的变化
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                int temp = (int) (Math.random() * 10);
//                if (flag == MOVIE_LIST) {
//                    attemptLeaveMsg();
//                    Log.e("视频", "视频");
//                    mRecyclerViewAdapter.notifyDataSetChanged();
//                } else if (flag == KEPUYANGSHENG_LIST) {
//                    attemptLeaveMsg();
//                    Log.e("pdf", "pdf");
//                    mRecyclerViewAdapter.notifyDataSetChanged();
//                } else if (flag == PPT_LIST) {
//                    attemptLeaveMsg();
//                    Log.e("图片", "图片");
//                    mRecyclerViewAdapter.notifyDataSetChanged();
//
//                } else if (flag == HANGYEDONGTAI_LIST) {
//
//                    attemptLeaveMsg();
//                    Log.e("倒数第二", "倒数第二");
//                    mRecyclerViewAdapter.notifyDataSetChanged();
//                } else if (flag == QIYEZIXUN_LIST) {
//                    attemptLeaveMsg();
//                    Log.e("最后", "最后");
//                    mStaggeredAdapter.notifyDataSetChanged();
//
//                }
            }
        }, 1000);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (flag) {
            case MOVIE_LIST:
                Intent intent = new Intent(getActivity(), MovieActivity.class);

                intent.putExtra("a", String.valueOf(position));


                startActivity(intent);

                break;
            case KEPUYANGSHENG_LIST:
                Intent intent1 = new Intent(getActivity(), PdfActivity.class);
                intent1.putExtra("a", position);
                startActivity(intent1);
                break;
            case HANGYEDONGTAI_LIST:
                Intent intent2 = new Intent(getActivity(), HangyedongtaiPdfActivity.class);
                intent2.putExtra("a", position);
                startActivity(intent2);
                break;
            case QIYEZIXUN_LIST:
                Intent intent7 = new Intent(getActivity(), QiyezixunPdfActivity.class);
                intent7.putExtra("a", position);
                startActivity(intent7);

                break;
            case PPT_LIST:
                Intent intent3 = new Intent(getActivity(), PptActivity.class);
                intent3.putExtra("a", String.valueOf(position));

                startActivity(intent3);
                break;
            case PICTURE_LIST:
                Intent intent4 = new Intent(getActivity(), GalleryActivity.class);
                intent4.putExtra("a", String.valueOf(position));

                startActivity(intent4);
                break;
            case RONYUZIXUN_LIST:
                if (position == 4) {

                    Intent intent8 = new Intent(getActivity(), RongYuZiZhiDetailPdfActivity.class);

                    startActivity(intent8);
                } else {
                    Intent intent5 = new Intent(getActivity(), RongYUZiZhiDetailPictureActivity.class);
                    intent5.putExtra("a", position);

                    startActivity(intent5);
                }

                break;
            case HUIYIWULIAO_LIST:
                Intent intent6 = new Intent(getActivity(), HuiYiWuLiaoActivity.class);
                intent6.putExtra("a", position);

                startActivity(intent6);
                break;
            default:
                break;
        }


    }

    @Override
    public void onItemLongClick(View view, int position) {
        SnackbarUtil.show(mRecyclerView, getString(R.string.item_longclicked), 0);
        Intent intent = new Intent(getActivity(), MovieActivity.class);
        startActivity(intent);
    }
}
