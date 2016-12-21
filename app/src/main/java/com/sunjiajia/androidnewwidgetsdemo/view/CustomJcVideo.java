package com.sunjiajia.androidnewwidgetsdemo.view;

import android.app.Activity;
import android.content.Context;

import android.util.AttributeSet;
import android.view.View;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by lijing on 2016/12/21.
 */

public class CustomJcVideo extends JCVideoPlayerStandard {


    public CustomJcVideo(Context context) {

//        context=context;
        super(context);
    }

    public CustomJcVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void onClick(View v) {
//        super.onClick(v);
        int i = v.getId();
         if (i == fm.jiecao.jcvideoplayer_lib.R.id.back) {

             Context context=getContext();
             if(context instanceof Activity){

                 ((Activity)context).finish();

             }


        }

             super.onClick(v);

    }
}
