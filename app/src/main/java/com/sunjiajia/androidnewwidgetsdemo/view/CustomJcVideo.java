package com.sunjiajia.androidnewwidgetsdemo.view;

import android.content.Context;
import android.util.AttributeSet;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by lijing on 2016/12/21.
 */

public class CustomJcVideo extends JCVideoPlayer {
    public CustomJcVideo(Context context) {
        super(context);
    }

    public CustomJcVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
