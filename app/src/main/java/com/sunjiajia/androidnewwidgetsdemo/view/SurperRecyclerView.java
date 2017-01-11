package com.sunjiajia.androidnewwidgetsdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by lijing on 2017/1/11.
 */

public class SurperRecyclerView extends RecyclerView {
    private OnBottomCallback mOnBottomCallback;
    public interface OnBottomCallback {
        void onBottom();
    }
    public void setOnBottomCallback(OnBottomCallback onBottomCallback) {
        this.mOnBottomCallback = onBottomCallback;
    }
    public SurperRecyclerView(Context context) {
        this(context, null);
    }
    public SurperRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public SurperRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onScrolled(int dx, int dy) {
        if (isSlideToBottom()) {
            mOnBottomCallback.onBottom();
        }
    }
    /**
     * 其实就是它在起作用。
     */
    public boolean isSlideToBottom() {
        return this != null
                && this.computeVerticalScrollExtent() + this.computeVerticalScrollOffset()
                >= this.computeVerticalScrollRange();
    }

}
