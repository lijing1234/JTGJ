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

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;

import java.io.File;

import fm.jiecao.jcvideoplayer_lib.JCBuriedPointStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


//http://172.17.20.44:8080/script/01.mp4
//        http://172.17.20.44:8080/script/04.jpg
public class MovieActivity extends AppCompatActivity {
    JCVideoPlayer.JCAutoFullscreenListener mSensorEventListener;
    SensorManager mSensorManager;
    JCVideoPlayerStandard mJcVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String  position = getIntent().getStringExtra("a");
        Log.e("position",position);
        setContentView(R.layout.activity_movie);
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
//        http://video.jiecao.fm/11/23/xin/%E5%81%87%E4%BA%BA.mp4

//        /storage/emulated/0/Movies/Starry_Night.mp4
//        /storage/emulated/0/Movies/Starry_Night.mp4
//        /storage/emulated/0/video/01.mp4
//        file.exists() ? file.getPath() : ""



        if(position.equals("0")){
            FILE_NAME = "/video/01金天国际2016企业宣传片.mp4";


        }else if (position.equals("1")){
            FILE_NAME = "/video/02直销启动暨“和谐与活力”公益盛典宣导片.mp4";

        }else if (position.equals("2")){
            FILE_NAME = "/video/03直销启动暨“和谐与活力”公益盛典精彩回顾.mp4";

        }else if (position.equals("3")){
            FILE_NAME = "/video/04宿迁智能化产业园落成典礼宣导片.mp4";

        }else if (position.equals("4")){
            FILE_NAME = "/video/05宿迁智能化产业园落成典礼精彩回顾.mp4";

        }else if (position.equals("5")){
            FILE_NAME = "/video/06金天国际璀璨之星讲师大赛宣导预告片.mp4";

        }else if (position.equals("6")){
            FILE_NAME = "/video/07-金天国际直销启动暨“和谐与活力”公益盛典完整视频.mp4";

        }else if (position.equals("7")){
            FILE_NAME = "/video/08金天国际25周年梦想盛典暨公益筑梦远航宣导片.mp4";

        }else if (position.equals("8")){
            FILE_NAME = "/video/09金天国际25周年梦想盛典暨公益筑梦远航家人祝福.mp4";

        }else if (position.equals("9")){
            FILE_NAME = "/video/10央视七套《聚焦三农》：金天国际圆贫困残障儿童学习梦.mp4";

        }else if (position.equals("10")){
            FILE_NAME = "/video/11活力金天，助力中国——金天国际25周年梦想盛典暨公益筑梦远航精彩回顾.mp4";

        }else if (position.equals("11")){
            FILE_NAME = "/video/12《聚焦apec》金天国际董事长祖名军接受采访.mp4";

        }else if (position.equals("12")){
            FILE_NAME = "/video/13金天国际雪莲生态保&养时尚版全新上线.mp4";

        }

        String path = geStorageDirectory();
        final File file = new File(path);

        mJcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jc_video);
        mJcVideoPlayerStandard.setUp(geStorageDirectory()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "視頻");

        Glide.with(this)
                .load("http://img4.jiecaojingxuan.com/2016/img11/23/00b026e7-b830-4994-bc87-38f4033806a6.jpg")
                .into(mJcVideoPlayerStandard.thumbImageView);
        mJcVideoPlayerStandard.looping = true;
        JCVideoPlayer.setJcBuriedPoint(new MyJCBuriedPointStandard());
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();


    }
    //获取本地视频路径

    private String geStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? sdPath + FILE_NAME : dataPath + FILE_NAME;


    }

    private String sdPath = Environment.getExternalStorageDirectory().getPath();
//    private String FILE_NAME = "/video/01.mp4";
    private String FILE_NAME = "/Movies/Starry_Night.mp4";
    private String dataPath = null;

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    class MyJCBuriedPointStandard implements JCBuriedPointStandard {

        @Override
        public void onEvent(int type, String url, int screen, Object... objects) {

        }
    }


}
