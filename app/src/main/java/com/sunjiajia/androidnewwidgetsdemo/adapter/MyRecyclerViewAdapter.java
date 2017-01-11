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

package com.sunjiajia.androidnewwidgetsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.view.SurperRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monkey on 2015/6/29.
 */
public class MyRecyclerViewAdapter extends SurperRecyclerView.Adapter<MyRecyclerViewHolder> implements View.OnClickListener {

    @Override
    public void onClick(View v) {
//    if (mOnItemClickListener != null) {
//              //注意这里使用getTag方法获取数据
//      mOnItemClickListener.onItemClick(v,(DataModel)v.getTag());
//    }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public Context mContext;
    public List<String> mDatas;
    //    List<ProductInfo> list;
    List<Integer> list;
    public LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(List<Integer> list, Context mContext) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    /**
     * 创建ViewHolder，被LayoutManager所调用
     */
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.item_main, parent, false);
        MyRecyclerViewHolder mViewHolder = new MyRecyclerViewHolder(mView);
        mView.setOnClickListener(this);
        return mViewHolder;
    }

    /**
     * 绑定ViewHoler，给item中的控件设置数据，将数据与界面进行绑定操作
     */
    @Override
    public void onBindViewHolder(final MyRecyclerViewHolder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);

                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);
                    return true;
                }
            });
        }
        //将数据保存在itemView的Tag中，以便点击时进行获取

        Glide.with(mContext)
                .load(list.get(position))
                .placeholder(R.drawable.loading_4)
                .fitCenter()
                .into(holder.mimage);
//        holder.mimage.setId(list.get(position));
//        holder.mtv.setText(list.get(position).getProductname());
//        holder.mtv1.setText(list.get(position).getProductcode());
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();
    }


}
