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
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{
    //获取本地视频路径

    private String geStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? sdPath + FILE_NAME : dataPath + FILE_NAME;
    }

    private String sdPath = Environment.getExternalStorageDirectory().getPath();
    //    private String FILE_NAME = "/video/01.mp4";
    private String FILE_NAME = "/video/01.mp4";
    private String dataPath = null;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        String  position = getIntent().getStringExtra("a");
        Log.e("position",position);
        imageView= (ImageView) findViewById(R.id.iv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("视频");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageView.setOnClickListener(this);

//        VideoView videoView = (VideoView) this.findViewById(R.id.vd);
//        videoView.setMediaController(new MediaController(this));
//        Uri uri = Uri.parse(geStorageDirectory());
//        videoView.setVideoURI(uri);
//        videoView.start();
//        videoView.requestFocus();
//        Intent it = new Intent(Intent.ACTION_VIEW);
//        Uri uri = Uri.parse(geStorageDirectory());
//        it.setDataAndType(uri, "video/mp4");
//        startActivity(it);
        if(position.equals("0")){
            FILE_NAME = "/video/00.mp4";
            imageView.setImageResource(R.drawable.img01);


        }else if (position.equals("1")){
            FILE_NAME = "/video/01.mp4";
            imageView.setImageResource(R.drawable.img02);

        }else if (position.equals("2")){
            FILE_NAME = "/video/02.mp4";
            imageView.setImageResource(R.drawable.img03);

        }else if (position.equals("3")){
            FILE_NAME = "/video/03.mp4";
            imageView.setImageResource(R.drawable.img04);

        }else if (position.equals("4")){
            FILE_NAME = "/video/04.mp4";
            imageView.setImageResource(R.drawable.img05);

        }else if (position.equals("5")){
            FILE_NAME = "/video/05.mp4";
            imageView.setImageResource(R.drawable.img06);

        }else if (position.equals("6")){
            FILE_NAME = "/video/06.mp4";
            imageView.setImageResource(R.drawable.img07);

        }else if (position.equals("7")){
            FILE_NAME = "/video/07.mp4";
            imageView.setImageResource(R.drawable.img08);

        }else if (position.equals("8")){
            FILE_NAME = "/video/08.mp4";
            imageView.setImageResource(R.drawable.img09);

        }else if (position.equals("9")){
            FILE_NAME = "/video/09.mp4";
            imageView.setImageResource(R.drawable.img10);

        }else if (position.equals("10")){
            FILE_NAME = "/video/10.mp4";

            imageView.setImageResource(R.drawable.img11);
        }else if (position.equals("11")){
            FILE_NAME = "/video/11.mp4";
            imageView.setImageResource(R.drawable.img12);

        }else if (position.equals("12")){
            FILE_NAME = "/video/12.mp4";
            imageView.setImageResource(R.drawable.img13);

        }

    }
    private void openExoPlayer(String filePath) {
//        Environment.getExternalStorageDirectory().getPath() + filePath
        Uri uri = Uri.parse( filePath);
        //调用系统自带的播放器
         Intent intent = new Intent(Intent.ACTION_VIEW);
         intent.setDataAndType(uri, "video/mp4"); startActivity(intent);
        //
        }

    @Override
    public void onClick(View v) {
        int ID = v.getId();
        switch(ID) {
            case R.id.iv:
                openExoPlayer(geStorageDirectory());
                break;
        }
    }
}
