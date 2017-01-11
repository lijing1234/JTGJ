package com.sunjiajia.androidnewwidgetsdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by lijing on 2017/1/11.
 */

public class SuperToolbar extends Toolbar implements TapListener.OnDoubleTapListener{

    private OnTwoTapListener mOnTwoTapListener;
    private GestureDetector mDetector;
    public interface OnTwoTapListener {
        void onTwoTap();
    }
    public void setOnTwoTapListener(OnTwoTapListener onTwoTapListener) {
        mOnTwoTapListener = onTwoTapListener;
    }
    public SuperToolbar(Context context) {
        this(context, null);
    }
    public SuperToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.toolbarStyle);
    }
    public SuperToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TapListener tapListener = new TapListener(this);
        mDetector = new GestureDetector(context, tapListener);
    }
    @Override
    public void onDouble() {
        mOnTwoTapListener.onTwoTap();
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        mDetector.onTouchEvent(ev);
        return true;
    }


}
