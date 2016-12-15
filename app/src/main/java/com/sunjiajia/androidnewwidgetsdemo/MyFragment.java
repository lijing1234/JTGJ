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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
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

    private static final int VERTICAL_LIST = 0;
    private static final int HORIZONTAL_LIST = 1;
    private static final int VERTICAL_GRID = 2;
    private static final int HORIZONTAL_GRID = 3;
    private static final int STAGGERED_GRID = 4;

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
            case VERTICAL_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case HORIZONTAL_LIST:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case VERTICAL_GRID:
                mLayoutManager =
                        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                break;
            case HORIZONTAL_GRID:
                mLayoutManager =
                        new GridLayoutManager(getActivity(), SPAN_COUNT, GridLayoutManager.HORIZONTAL, false);
                break;
            case STAGGERED_GRID:
                mLayoutManager =
                        new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
                break;
        }


    }

    private void attemptLeaveMsg() {

        if (flag == VERTICAL_LIST) {
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
        } else if (flag == HORIZONTAL_LIST) {
            Imageinfo info1 = new Imageinfo();
            info1.imagename="01-5个痛经认知误区，让女人越来越痛！";
            info1.image=R.drawable.img01;
            Imageinfo info2 = new Imageinfo();
            info2.imagename="01-5个痛经认知误区，让女人越来越痛！";
            info2.image=R.drawable.img01;


            list1 = new ArrayList<Imageinfo>();
            list1.add(0, info1);
            list1.add(1, info2);
            mypdfRecyclerViewAdapter = new MypdfRecyclerViewAdapter(list1, getActivity());
            mypdfRecyclerViewAdapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(mypdfRecyclerViewAdapter);
            mypdfRecyclerViewAdapter.notifyDataSetChanged();
            mRecyclerView.setLayoutManager(mLayoutManager);

        } else if (flag == VERTICAL_GRID) {
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

        } else if (flag == HORIZONTAL_GRID) {


        } else if (flag == STAGGERED_GRID) {


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
                if (flag == VERTICAL_LIST) {
                    attemptLeaveMsg();
                    Log.e("视频", "视频");
                    mRecyclerViewAdapter.notifyDataSetChanged();
                } else if (flag == HORIZONTAL_LIST) {
                    attemptLeaveMsg();
                    Log.e("pdf", "pdf");
                    mRecyclerViewAdapter.notifyDataSetChanged();
                } else if (flag == VERTICAL_GRID) {
                    attemptLeaveMsg();
                    Log.e("图片", "图片");
                    mRecyclerViewAdapter.notifyDataSetChanged();

                } else if (flag == HORIZONTAL_GRID) {

                    attemptLeaveMsg();
                    Log.e("倒数第二", "倒数第二");
                    mRecyclerViewAdapter.notifyDataSetChanged();
                } else if (flag == STAGGERED_GRID) {
                    attemptLeaveMsg();
                    Log.e("最后", "最后");
                    mStaggeredAdapter.notifyDataSetChanged();

                }
            }
        }, 1000);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (flag == VERTICAL_LIST) {
            Intent intent = new Intent(getActivity(), MovieActivity.class);

            intent.putExtra("a", String.valueOf(position));


            startActivity(intent);
        } else if (flag == HORIZONTAL_LIST) {
            Intent intent = new Intent(getActivity(), PdfActivity.class);
//            intent.putExtra("a", mStaggeredAdapter.mDatas.get(position));
            intent.putExtra("a", String.valueOf(position));


            startActivity(intent);
        } else if (flag == VERTICAL_GRID) {
            Intent intent = new Intent(getActivity(), PptActivity.class);
//            intent.putExtra("a", mStaggeredAdapter.mDatas.get(position));
            intent.putExtra("a", String.valueOf(position));

            startActivity(intent);
        }

    }

    @Override
    public void onItemLongClick(View view, int position) {
        SnackbarUtil.show(mRecyclerView, getString(R.string.item_longclicked), 0);
        Intent intent = new Intent(getActivity(), MovieActivity.class);
        startActivity(intent);
    }
}
