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
import com.sunjiajia.androidnewwidgetsdemo.utils.SnackbarUtil;

import java.util.ArrayList;
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
                        new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
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
                listmovie = new ArrayList<Integer>();
                listmovie.add(0, R.drawable.img01);
                listmovie.add(1, R.drawable.img02);
                listmovie.add(2, R.drawable.img03);
                listmovie.add(3, R.drawable.img04);
                listmovie.add(4, R.drawable.img05);
                listmovie.add(5, R.drawable.img06);
                listmovie.add(6, R.drawable.img07);
                listmovie.add(7, R.drawable.img08);
                listmovie.add(8, R.drawable.img09);
                listmovie.add(9, R.drawable.img10);
                listmovie.add(10, R.drawable.img11);
                listmovie.add(11, R.drawable.img12);
                listmovie.add(12, R.drawable.img13);
                mRecyclerViewAdapter = new MyRecyclerViewAdapter(listmovie, getActivity());
                mRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
                mRecyclerViewAdapter.notifyDataSetChanged();
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
                info3.image = R.drawable.kp01;
                Imageinfo info4 = new Imageinfo();
                info4.imagename = "75%的人都亚健康，快来测测你得多少分？超过80就得去医院";
                info4.image = R.drawable.kp02;
                Imageinfo info5 = new Imageinfo();
                info5.imagename = "99%的女人都做错了！！太可怕了……";
                info5.image = R.drawable.kp01;
                Imageinfo info6 = new Imageinfo();
                info6.imagename = "备孕很久还没怀上，别怕，你可能被假性不孕蒙住了！";
                info6.image = R.drawable.kp02;
                Imageinfo info7 = new Imageinfo();
                info7.imagename = "被乳腺癌盯上的10种女人，不看后悔去吧！";
                info7.image = R.drawable.kp01;
                Imageinfo info8 = new Imageinfo();
                info8.imagename = "放倒男人的“新五毒”，看看你占了多少？";
                info8.image = R.drawable.kp02;
                Imageinfo info9 = new Imageinfo();
                info9.imagename = "撩人的味道，女人身上为什么会有体香？";
                info9.image = R.drawable.kp01;
                Imageinfo info10 = new Imageinfo();
                info10.imagename = "难怪你越来越老，就因为你老做这些事！";
                info10.image = R.drawable.kp02;
                Imageinfo info11 = new Imageinfo();
                info11.imagename = "女人保养的方子，全了！赶紧收藏起来吧！";
                info11.image = R.drawable.kp01;
                Imageinfo info12 = new Imageinfo();
                info12.imagename = "女人要懂得保护子宫，才能避免容颜早衰";
                info12.image = R.drawable.kp02;
                Imageinfo info13 = new Imageinfo();
                info13.imagename = "女人一生能承受几次人流？";
                info13.image = R.drawable.kp01;
                Imageinfo info14 = new Imageinfo();
                info14.imagename = "排毒——女人一生需要做的功课";
                info14.image = R.drawable.kp02;
                Imageinfo info15 = new Imageinfo();
                info15.imagename = "盘点女性患癌的11个信号，一定要提高警惕！";
                info15.image = R.drawable.kp01;
                Imageinfo info16 = new Imageinfo();
                info16.imagename = "切记！女人这样做竟会导致子宫移位，再不注意就晚了！";
                info16.image = R.drawable.kp02;
                Imageinfo info17 = new Imageinfo();
                info17.imagename = "清宫排阴毒，女人美丽的秘密！";
                info17.image = R.drawable.kp01;
                Imageinfo info18 = new Imageinfo();
                info18.imagename = "让女性月经彻底失调的7个坏习惯，第2条恐怕你就不知道。";
                info18.image = R.drawable.kp02;
                Imageinfo info19 = new Imageinfo();
                info19.imagename = "湿气重、危害大，湿气重易导致哪些妇科病？";
                info19.image = R.drawable.kp01;
                Imageinfo info20 = new Imageinfo();
                info20.imagename = "十女九寒！宫寒太可怕！忽视更可怕！！";
                info20.image = R.drawable.kp02;
                Imageinfo info21 = new Imageinfo();
                info21.imagename = "想漂亮？养颜先排毒 脸部10种情况暗示你该排毒";
                info21.image = R.drawable.kp01;
                Imageinfo info22 = new Imageinfo();
                info22.imagename = "22阴道炎反复发作，都是因为女人忽略了这些……";
                info22.image = R.drawable.kp02;
                Imageinfo info23 = new Imageinfo();
                info23.imagename = "23阴道炎你知道多少？它比你想象的更可怕！";
                info23.image = R.drawable.kp01;
                Imageinfo info24 = new Imageinfo();
                info24.imagename = "24月经是女性健康的晴雨表，女性必知！";
                info24.image = R.drawable.kp02;
                Imageinfo info25 = new Imageinfo();
                info25.imagename = "25月经颜色发黑原来是因为这，女人一定要重视！";
                info25.image = R.drawable.kp02;
                Imageinfo info26 = new Imageinfo();
                info26.imagename = "26女人！别再透支你的生育能力！";
                info26.image = R.drawable.kp02;
                Imageinfo info27 = new Imageinfo();
                info27.imagename = "27女人胸前的“炸弹”岂能一刀了之？";
                info27.image = R.drawable.kp02;
                Imageinfo info28 = new Imageinfo();
                info28.imagename = "28内分泌失调对女性的伤害，不只衰老、肥胖那么简单……";
                info28.image = R.drawable.kp02;
                Imageinfo info29 = new Imageinfo();
                info29.imagename = "29子宫不排毒，变成垃圾场！值得每个女人警惕！";
                info29.image = R.drawable.kp02;
                Imageinfo info30 = new Imageinfo();
                info30.imagename = "30揭密：男人行不行，看他的“脸”就知道！";
                info30.image = R.drawable.kp02;
                Imageinfo info31 = new Imageinfo();
                info31.imagename = "31你的脸上有张疾病图！教你从脸看健康～";
                info31.image = R.drawable.kp02;
                Imageinfo info32 = new Imageinfo();
                info32.imagename = "32为什么中医总说你“湿气重”？看后恍然大悟！";
                info32.image = R.drawable.kp02;
                Imageinfo info33 = new Imageinfo();
                info33.imagename = "33揭秘：女人私处液体的6个变化到底意味着什么揭秘";
                info33.image = R.drawable.kp02;
                Imageinfo info34 = new Imageinfo();
                info34.imagename = "34男性性能力衰退的6大表现，一般人还不知道！";
                info34.image = R.drawable.kp02;
                Imageinfo info35 = new Imageinfo();
                info35.imagename = "35痛经是子宫的求救信号，怎能一忍了之！";
                info35.image = R.drawable.kp02;
                Imageinfo info36 = new Imageinfo();
                info36.imagename = "36-6个超赞的子宫保养常识，请收好！";
                info36.image = R.drawable.kp02;
                Imageinfo info37 = new Imageinfo();
                info37.imagename = "37-“大姨妈”迟迟不走，你造为什么吗？";
                info37.image = R.drawable.kp02;
                Imageinfo info38 = new Imageinfo();
                info38.imagename = "38-26岁白领患卵巢癌飙泪演讲，年轻人养生真的很重要！！";
                info38.image = R.drawable.kp02;
                Imageinfo info39 = new Imageinfo();
                info39.imagename = "39-40岁以后为何会有老人臭？其实真的不是你的错！";
                info39.image = R.drawable.kp02;
                Imageinfo info40 = new Imageinfo();
                info40.imagename = "40触目惊心的人类健康现状——男性生理健康篇";
                info40.image = R.drawable.kp02;
                Imageinfo info41 = new Imageinfo();
                info41.imagename = "41从乳腺增生到乳腺癌有多远？！女人不要再无知了！";
                info41.image = R.drawable.kp02;
                Imageinfo info42 = new Imageinfo();
                info42.imagename = "42关于乳房的10个健康小知识，你可能一个都不知道！";
                info42.image = R.drawable.kp02;
                Imageinfo info43 = new Imageinfo();
                info43.imagename = "43警惕：女人脸上皱纹泄露的身体“机密”，太准了！";
                info43.image = R.drawable.kp02;
                Imageinfo info44 = new Imageinfo();
                info44.imagename = "44男人必做8道题，看看你的身体需要“检修”吗？";
                info44.image = R.drawable.kp02;
                Imageinfo info45 = new Imageinfo();
                info45.imagename = "45男人前列腺成“多事之地”，最怕这七个字……";
                info45.image = R.drawable.kp02;
                Imageinfo info46 = new Imageinfo();
                info46.imagename = "46难以置信的人类年轻的现状——衰老过早来临";
                info46.image = R.drawable.kp02;
                Imageinfo info47 = new Imageinfo();
                info47.imagename = "47你每天是怎么醒的？这么醒来对身体伤害非常大，几乎人人中招！";
                info47.image = R.drawable.kp02;
                Imageinfo info48 = new Imageinfo();
                info48.imagename = "48女人经期绝不能踫的7种食物！一碰就痛经！";
                info48.image = R.drawable.kp02;
                Imageinfo info49 = new Imageinfo();
                info49.imagename = "49女人是如何变老的？一定要认真对待！";
                info49.image = R.drawable.kp02;
                Imageinfo info50 = new Imageinfo();
                info50.imagename = "50女性大姨妈来时，千万别做这12件事！";
                info50.image = R.drawable.kp02;
                Imageinfo info51 = new Imageinfo();
                info51.imagename = "51女性更年期竟然可以推测！我的年龄居然是……";
                info51.image = R.drawable.kp02;
                Imageinfo info52 = new Imageinfo();
                info52.imagename = "52女性肾虚比男人更危险，有这6种情况的女人要注意了……";
                info52.image = R.drawable.kp02;
                Imageinfo info53 = new Imageinfo();
                info53.imagename = "53起床后的口气，不能忽视，一种口气预示一种疾病！";
                info53.image = R.drawable.kp02;
                Imageinfo info54 = new Imageinfo();
                info54.imagename = "54三期保养  幸福一生";
                info54.image = R.drawable.kp02;
                Imageinfo info55 = new Imageinfo();
                info55.imagename = "55十病九寒，体内寒气自测和祛除法，98%的人都说好！";
                info55.image = R.drawable.kp02;
                Imageinfo info56 = new Imageinfo();
                info56.imagename = "56私处干净=没有妇科病？这种想法大错特错！";
                info56.image = R.drawable.kp02;
                Imageinfo info57 = new Imageinfo();
                info57.imagename = "57阴道炎反复发作，竟是因为你忽略了这";
                info57.image = R.drawable.kp02;
                Imageinfo info58 = new Imageinfo();
                info58.imagename = "58月经量少会影响怀孕吗？经量多少才算少";
                info58.image = R.drawable.kp02;
                Imageinfo info59 = new Imageinfo();
                info59.imagename = "59越来越没“女人味”？原来是它在捣鬼！";
                info59.image = R.drawable.kp02;
                Imageinfo info60 = new Imageinfo();
                info60.imagename = "60越懒越长寿？8大懒习惯让你年轻20岁，99%的人不知道！";
                info60.image = R.drawable.kp02;
                Imageinfo info61 = new Imageinfo();
                info61.imagename = "61子宫竟然最怕它……，女人须提防4大“温柔杀手”！";
                info61.image = R.drawable.kp02;
                Imageinfo info62 = new Imageinfo();
                info62.imagename = "62最伤害男人身体的六大疾病，早看早预防！";
                info62.image = R.drawable.kp02;


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
                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case HANGYEDONGTAI_LIST:
                Imageinfo hangyedongtai1 = new Imageinfo();
                hangyedongtai1.imagename = "01“大健康产业”蛋糕有多大？一组数据告诉你！.pdf";
                hangyedongtai1.image = R.drawable.kp01;
                Imageinfo hangyedongtai2 = new Imageinfo();
                hangyedongtai2.imagename = "02成功的直销人必须具备的六种能力.pdf";
                hangyedongtai2.image = R.drawable.kp02;
                Imageinfo hangyedongtai3 = new Imageinfo();
                hangyedongtai3.imagename = "03从习大大和李总理在“全国卫生与健康大会”上的讲话剖析健康产业发展新趋势.pdf";
                hangyedongtai3.image = R.drawable.kp01;
                Imageinfo hangyedongtai4 = new Imageinfo();
                hangyedongtai4.imagename = "04老百姓关心的健康问题，总书记这样说 ——专家解读习总书记在全国卫生与健康大会上讲话精神.pdf";
                hangyedongtai4.image = R.drawable.kp02;
                Imageinfo hangyedongtai5 = new Imageinfo();
                hangyedongtai5.imagename = "05全民健康升至国家战略！拒绝直销大健康产业，就是拒绝财富和健康！.pdf";
                hangyedongtai5.image = R.drawable.kp01;
                Imageinfo hangyedongtai6 = new Imageinfo();
                hangyedongtai6.imagename = "06未来五年，团队+系统+趋势=成功.pdf";
                hangyedongtai6.image = R.drawable.kp02;
                Imageinfo hangyedongtai7 = new Imageinfo();
                hangyedongtai7.imagename = "07赢在金天——趋势篇.pdf";
                hangyedongtai7.image = R.drawable.kp01;
                Imageinfo hangyedongtai8 = new Imageinfo();
                hangyedongtai8.imagename = "08赢在金天——创新篇.pdf";
                hangyedongtai8.image = R.drawable.kp02;
                Imageinfo hangyedongtai9 = new Imageinfo();
                hangyedongtai9.imagename = "09赢在金天——实力篇（一）.pdf";
                hangyedongtai9.image = R.drawable.kp01;
                Imageinfo hangyedongt10 = new Imageinfo();
                hangyedongt10.imagename = "10赢在金天——实力篇（二）.pdf";
                hangyedongt10.image = R.drawable.kp02;
                Imageinfo hangyedongt11 = new Imageinfo();
                hangyedongt11.imagename = "11赢在金天——保障篇.pdf";
                hangyedongt11.image = R.drawable.kp01;
                Imageinfo hangyedongt12 = new Imageinfo();
                hangyedongt12.imagename = "12赢在金天——责任篇.pdf";
                hangyedongt12.image = R.drawable.kp02;
                Imageinfo hangyedongt13 = new Imageinfo();
                hangyedongt13.imagename = "13这样的团队，将无所不能！.pdf";
                hangyedongt13.image = R.drawable.kp01;
                Imageinfo hangyedongt14 = new Imageinfo();
                hangyedongt14.imagename = "14政治局审议通过”健康中国2030”纲要.pdf";
                hangyedongt14.image = R.drawable.kp02;
                Imageinfo hangyedongt15 = new Imageinfo();
                hangyedongt15.imagename = "15习大大、李总理等这样评价健康产业！.pdf";
                hangyedongt15.image = R.drawable.kp01;
                Imageinfo hangyedongt16 = new Imageinfo();
                hangyedongt16.imagename = "16健康需求消费或将爆发，新兴健康产业成消费爆发点！.pdf";
                hangyedongt16.image = R.drawable.kp02;
                Imageinfo hangyedongt17 = new Imageinfo();
                hangyedongt17.imagename = "17凭什么说中国大健康产业正在经历黄金时期？.pdf";
                hangyedongt17.image = R.drawable.kp01;
                Imageinfo hangyedongt18 = new Imageinfo();
                hangyedongt18.imagename = "18成为风潮的大健康产业，好在哪里？.pdf";
                hangyedongt18.image = R.drawable.kp02;
                Imageinfo hangyedongt19 = new Imageinfo();
                hangyedongt19.imagename = "19大健康产业为什么将成热门投资领域？.pdf";
                hangyedongt19.image = R.drawable.kp01;
                Imageinfo hangyedongt20 = new Imageinfo();
                hangyedongt20.imagename = "20治未病提上国家议程，大健康产业将迎来资本盛宴！.pdf";
                hangyedongt20.image = R.drawable.kp02;
                Imageinfo hangyedongt21 = new Imageinfo();
                hangyedongt21.imagename = "21马云进军大健康产业，你看到机会了吗.pdf";
                hangyedongt21.image = R.drawable.kp01;
                Imageinfo hangyedongt22 = new Imageinfo();
                hangyedongt22.imagename = "22为什么女性生殖健康产业是未来十年最有前景的项目？.pdf";
                hangyedongt22.image = R.drawable.kp02;
                Imageinfo hangyedongt23 = new Imageinfo();
                hangyedongt23.imagename = "23注意：大健康已上升为国家战略！.pdf";
                hangyedongt23.image = R.drawable.kp01;
                Imageinfo hangyedongt24 = new Imageinfo();
                hangyedongt24.imagename = "24十八个著名的心理学效应，生活中你一定用的到！.pdf";
                hangyedongt24.image = R.drawable.kp02;
                Imageinfo hangyedongt25 = new Imageinfo();
                hangyedongt25.imagename = "25一等人在保养、二等人健身锻炼、三等人进医院！.pdf";
                hangyedongt25.image = R.drawable.kp02;
                Imageinfo hangyedongt26 = new Imageinfo();
                hangyedongt26.imagename = "26女性生殖健康问题有多严重？生殖健康产业市场空间有多大？.pdf";
                hangyedongt26.image = R.drawable.kp02;
                Imageinfo hangyedongt27 = new Imageinfo();
                hangyedongt27.imagename = "27“治未病”是趋势，将影响13亿国人生活！.pdf";
                hangyedongt27.image = R.drawable.kp02;
                Imageinfo hangyedongt28 = new Imageinfo();
                hangyedongt28.imagename = "28-16万亿大健康产业，抓住财富的好时机!.pdf";
                hangyedongt28.image = R.drawable.kp02;



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

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case QIYEZIXUN_LIST:
                Imageinfo qiyezixun1 = new Imageinfo();
                qiyezixun1.imagename = "01金天国际集团捐款800万元建立";
                qiyezixun1.image = R.drawable.kp01;
                Imageinfo qiyezixun2 = new Imageinfo();
                qiyezixun2.imagename = "02热烈祝贺金天国际烟台金蕊、烟台天伦同获“重合同守信用企业”荣誉";
                qiyezixun2.image = R.drawable.kp02;
                Imageinfo qiyezixun3 = new Imageinfo();
                qiyezixun3.imagename = "03恭贺生态保养技术取得重大突破";
                qiyezixun3.image = R.drawable.kp01;
                Imageinfo qiyezixun4 = new Imageinfo();
                qiyezixun4.imagename = "04金天国际董事局主席祖明军先生当选中国“双反”联盟副理事长";
                qiyezixun4.image = R.drawable.kp02;
                Imageinfo qiyezixun5 = new Imageinfo();
                qiyezixun5.imagename = "05《反侵权假冒年度报告》首版发行 祖明军入选双反行业专家";
                qiyezixun5.image = R.drawable.kp01;
                Imageinfo qiyezixun6 = new Imageinfo();
                qiyezixun6.imagename = "06金天国际直销许可获商务部正式公示";
                qiyezixun6.image = R.drawable.kp02;
                Imageinfo qiyezixun7 = new Imageinfo();
                qiyezixun7.imagename = "07金天国际大中华区总裁祖威被评为十大维权打假优秀卫士";
                qiyezixun7.image = R.drawable.kp01;
                Imageinfo qiyezixun8 = new Imageinfo();
                qiyezixun8.imagename = "08“金天国际江苏智能化产业园开业典礼”亮点剖析";
                qiyezixun8.image = R.drawable.kp02;
                Imageinfo qiyezixun9 = new Imageinfo();
                qiyezixun9.imagename = "09金天国际宿迁智能化产业园落成典礼圆满落幕";
                qiyezixun9.image = R.drawable.kp01;
                Imageinfo qiyezixun10 = new Imageinfo();
                qiyezixun10.imagename = "10全国助残日：金天国际再次献爱烟台残障儿童";
                qiyezixun10.image = R.drawable.kp02;
                Imageinfo qiyezixun11 = new Imageinfo();
                qiyezixun11.imagename = "11北京科博会开幕, 金天国际“智造”受热捧!";
                qiyezixun11.image = R.drawable.kp01;
                Imageinfo qiyezixun12 = new Imageinfo();
                qiyezixun12.imagename = "12生态保养产业化又一壮举，“金天国际星湖半岛”项目正式启动！";
                qiyezixun12.image = R.drawable.kp02;
                Imageinfo qiyezixun13 = new Imageinfo();
                qiyezixun13.imagename = "13热烈庆祝金天国际直销启动暨“和谐与活力”公益盛典圆满落幕";
                qiyezixun13.image = R.drawable.kp01;
                Imageinfo qiyezixun14 = new Imageinfo();
                qiyezixun14.imagename = "14金天国际被增选为“北京民营经济发展促进会副会长单位”";
                qiyezixun14.image = R.drawable.kp02;
                Imageinfo qiyezixun15 = new Imageinfo();
                qiyezixun15.imagename = "15“生态金天，活力绽放”暨金天国际星湖半岛旅游研讨会圆满落幕！";
                qiyezixun15.image = R.drawable.kp01;
                Imageinfo qiyezixun16 = new Imageinfo();
                qiyezixun16.imagename = "16政府领导莅临金天国际江苏生态保养智能化产业园参观指导";
                qiyezixun16.image = R.drawable.kp02;
                Imageinfo qiyezixun17 = new Imageinfo();
                qiyezixun17.imagename = "17烟台市经济观摩活动组莅临金天国际参观考察";
                qiyezixun17.image = R.drawable.kp01;
                Imageinfo qiyezixun18 = new Imageinfo();
                qiyezixun18.imagename = "18金天国际生态港湾立体养生产业基地正式启动";
                qiyezixun18.image = R.drawable.kp02;
                Imageinfo qiyezixun19 = new Imageinfo();
                qiyezixun19.imagename = "19金天国际2016新品发布会成功举办";
                qiyezixun19.image = R.drawable.kp01;
                Imageinfo qiyezixun20 = new Imageinfo();
                qiyezixun20.imagename = "20祖明军董事长出席环骆马湖旅游产业联盟成立大会";
                qiyezixun20.image = R.drawable.kp02;
                Imageinfo qiyezixun21 = new Imageinfo();
                qiyezixun21.imagename = "21金天国际璀璨活力之星生态保养师海选大赛华东";
                qiyezixun21.image = R.drawable.kp01;
                Imageinfo qiyezixun22 = new Imageinfo();
                qiyezixun22.imagename = "22金天国际三维动态式特许专营模式";
                qiyezixun22.image = R.drawable.kp02;
                Imageinfo qiyezixun23 = new Imageinfo();
                qiyezixun23.imagename = "23金天国际中心店招募公告";
                qiyezixun23.image = R.drawable.kp01;
                Imageinfo qiyezixun24 = new Imageinfo();
                qiyezixun24.imagename = "24金天国际璀璨活力之星生态保养师晋级培训会成功举办";
                qiyezixun24.image = R.drawable.kp02;
                Imageinfo qiyezixun25 = new Imageinfo();
                qiyezixun25.imagename = "25金天国际璀璨活力之星生态保养师大赛复赛成功举办";
                qiyezixun25.image = R.drawable.kp02;
                Imageinfo qiyezixun26 = new Imageinfo();
                qiyezixun26.imagename = "26金天国际璀璨活力之星生态保养师大赛决赛成功举办";
                qiyezixun26.image = R.drawable.kp02;
                Imageinfo qiyezixun27 = new Imageinfo();
                qiyezixun27.imagename = "27金天国际公益纪实，用爱点燃生命，照亮梦想，让更多生命充满活力！";
                qiyezixun27.image = R.drawable.kp02;
                Imageinfo qiyezixun28 = new Imageinfo();
                qiyezixun28.imagename = "28“筑梦金天 荣耀尊享”红酒晚宴---致英雄与王者的尊贵之礼！";
                qiyezixun28.image = R.drawable.kp02;
                Imageinfo qiyezixun29 = new Imageinfo();
                qiyezixun29.imagename = "29【金天专题】“活力金天，助力中国”金天国际25周年梦想盛典暨公益筑梦远航精彩回顾";
                qiyezixun29.image = R.drawable.kp02;
                Imageinfo qiyezixun30 = new Imageinfo();
                qiyezixun30.imagename = "30【央视特别报道】金天国际护苗计划：圆贫困残障儿童学习梦";
                qiyezixun30.image = R.drawable.kp02;
                Imageinfo qiyezixun31 = new Imageinfo();
                qiyezixun31.imagename = "31【周年盛典】聆听领袖智慧箴言，见证生态保养产业化未来";
                qiyezixun31.image = R.drawable.kp02;
                Imageinfo qiyezixun32 = new Imageinfo();
                qiyezixun32.imagename = "32【周年盛典】助力全民健康，推动全面小康！金天国际公益筑梦扬帆远航！";
                qiyezixun32.image = R.drawable.kp02;
                Imageinfo qiyezixun33 = new Imageinfo();
                qiyezixun33.imagename = "33产业筑梦，共创共赢 ——金天国际2016领袖训成功举办";
                qiyezixun33.image = R.drawable.kp02;
                Imageinfo qiyezixun34 = new Imageinfo();
                qiyezixun34.imagename = "34【工具致胜】金天国际新版工具流正式上线！";
                qiyezixun34.image = R.drawable.kp02;
                Imageinfo qiyezixun35 = new Imageinfo();
                qiyezixun35.imagename = "35金天国际荣耀受邀出席2016年APEC工商领导人峰会";
                qiyezixun35.image = R.drawable.kp02;
                Imageinfo qiyezixun36 = new Imageinfo();
                qiyezixun36.imagename = "36【聚焦APEC】金天国际代表祖明军出席中厄经贸合作论坛并发表主题演讲";
                qiyezixun36.image = R.drawable.kp02;
                Imageinfo qiyezixun37 = new Imageinfo();
                qiyezixun37.imagename = "37【聚焦APEC】金天国际祖明军出席秘鲁投资环境介绍会";
                qiyezixun37.image = R.drawable.kp02;
                Imageinfo qiyezixun38 = new Imageinfo();
                qiyezixun38.imagename = "38聚焦APEC，领略金天国际创新之道——技术创新";
                qiyezixun38.image = R.drawable.kp02;
                Imageinfo qiyezixun39 = new Imageinfo();
                qiyezixun39.imagename = "39【聚焦APEC】APEC峰会盛大开启，金天国际屹立世界经济舞台！";
                qiyezixun39.image = R.drawable.kp02;
                Imageinfo qiyezixun40 = new Imageinfo();
                qiyezixun40.imagename = "40【聚焦APEC】金天国际祖明军受邀出席APEC欢迎晚宴";
                qiyezixun40.image = R.drawable.kp02;
                Imageinfo qiyezixun41 = new Imageinfo();
                qiyezixun41.imagename = "41聚焦APEC，领略金天国际创新之道——产品创新";
                qiyezixun41.image = R.drawable.kp02;
                Imageinfo qiyezixun42 = new Imageinfo();
                qiyezixun42.imagename = "42【聚焦APEC】领略金天国际创新之道—— 模式创新";
                qiyezixun42.image = R.drawable.kp02;
                Imageinfo qiyezixun43 = new Imageinfo();
                qiyezixun43.imagename = "43【聚焦APEC】习主席讲话引领未来经济， 金天国际“生态养生”惠及全球";
                qiyezixun43.image = R.drawable.kp02;
                Imageinfo qiyezixun44 = new Imageinfo();
                qiyezixun44.imagename = "44【聚焦APEC】领略金天国际创新之道—— 产业创新";
                qiyezixun44.image = R.drawable.kp02;
                Imageinfo qiyezixun45 = new Imageinfo();
                qiyezixun45.imagename = "45金天国际祖明军APEC荣耀之旅回顾";
                qiyezixun45.image = R.drawable.kp02;
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

                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case PPT_LIST:
                listppt = new ArrayList<Integer>();
                listppt.add(0, R.drawable.ppt01);
                listppt.add(1, R.drawable.ppt02);
                listppt.add(2, R.drawable.ppt03);
                listppt.add(3, R.drawable.ppt04);
                listppt.add(4, R.drawable.ppt05);
                listppt.add(5, R.drawable.ppt06);
                listppt.add(6, R.drawable.ppt07);
                listppt.add(7, R.drawable.ppt08);
                listppt.add(8, R.drawable.ppt09);
                listppt.add(9, R.drawable.ppt10);
                listppt.add(10, R.drawable.ppt11);

                mRecyclerViewAdapter = new MyRecyclerViewAdapter(listppt, getActivity());
                mRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
                mRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case PICTURE_LIST:
                Imageinfo picture1 = new Imageinfo();
                picture1.imagename = "01办公环境";
                picture1.image = R.drawable.kp01;
                Imageinfo picture2 = new Imageinfo();
                picture2.imagename = "02生产基地";
                picture2.image = R.drawable.kp02;
                Imageinfo picture3 = new Imageinfo();
                picture3.imagename = "03星湖半岛";
                picture3.image = R.drawable.kp01;
                Imageinfo picture4 = new Imageinfo();
                picture4.imagename = "04培训基地";
                picture4.image = R.drawable.kp02;
                Imageinfo picture5 = new Imageinfo();
                picture5.imagename = "05金天国际直销启动暨“和谐与活力”公益盛典";
                picture5.image = R.drawable.kp01;
                Imageinfo picture6 = new Imageinfo();
                picture6.imagename = "06金天国际2015年度优秀领导人表彰暨获牌盛典";
                picture6.image = R.drawable.kp02;
                Imageinfo picture7 = new Imageinfo();
                picture7.imagename = "07金天国际宿迁智能化产业园落成典礼";
                picture7.image = R.drawable.kp01;
                Imageinfo picture8 = new Imageinfo();
                picture8.imagename = "08金天国际25周年梦想盛典暨公益筑梦远航";
                picture8.image = R.drawable.kp02;




                list1 = new ArrayList<Imageinfo>();
                list1.add(0, picture1);
                list1.add(1, picture2);
                list1.add(2, picture3);
                list1.add(3, picture4);
                list1.add(4, picture5);
                list1.add(5, picture6);
                list1.add(6, picture7);
                list1.add(7, picture8);



                mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
                mypdfRecyclerViewAdapter.setOnItemClickListener(this);
                mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
                mypdfRecyclerViewAdapter.notifyDataSetChanged();
                mRecyclerView.setLayoutManager(mLayoutManager);

                break;
            case RONYUZIXUN_LIST:
                Imageinfo rngyuzixun1 = new Imageinfo();
                rngyuzixun1.imagename = "01企业商标专利";
                rngyuzixun1.image = R.drawable.kp01;
                Imageinfo rngyuzixun2 = new Imageinfo();
                rngyuzixun2.imagename = "02企业经营资质";
                rngyuzixun2.image = R.drawable.kp02;
                Imageinfo rngyuzixun3 = new Imageinfo();
                rngyuzixun3.imagename = "03企业荣誉";
                rngyuzixun3.image = R.drawable.kp01;
                Imageinfo rngyuzixun4 = new Imageinfo();
                rngyuzixun4.imagename = "04产品荣誉";
                rngyuzixun4.image = R.drawable.kp02;
                Imageinfo rngyuzixun5 = new Imageinfo();
                rngyuzixun5.imagename = "05权威检测报告";
                rngyuzixun5.image = R.drawable.kp01;





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
                Imageinfo huiyiwuliao1 = new Imageinfo();
                huiyiwuliao1.imagename = "店主培训会";
                huiyiwuliao1.image = R.drawable.wa1;
                Imageinfo huiyiwuliao2 = new Imageinfo();
                huiyiwuliao2.imagename = "公益讲座";
                huiyiwuliao2.image = R.drawable.wa2;

                list1 = new ArrayList<Imageinfo>();
                list1.add(0, huiyiwuliao1);
                list1.add(1, huiyiwuliao2);

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
                if (position==4){

                    Intent intent8 = new Intent(getActivity(), RongYuZiZhiDetailPdfActivity.class);

                    startActivity(intent8);
                }else {
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
