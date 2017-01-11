package com.sunjiajia.androidnewwidgetsdemo.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by lijing on 2017/1/11.
 */

public class TapListener extends GestureDetector.SimpleOnGestureListener {

    private OnDoubleTapListener mDoubleTapListener;
    public TapListener(OnDoubleTapListener onDoubleTapListener) {
        mDoubleTapListener = onDoubleTapListener;
    }
    public interface OnDoubleTapListener {
        void onDouble();
    }
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mDoubleTapListener.onDouble();
        return true;
    }


}
