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

package com.sunjiajia.androidnewwidgetsdemo.video;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.view.CustomJcVideo;

import java.io.File;

import fm.jiecao.jcvideoplayer_lib.JCBuriedPoint;
import fm.jiecao.jcvideoplayer_lib.JCBuriedPointStandard;
import fm.jiecao.jcvideoplayer_lib.JCUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


//http://172.17.20.44:8080/script/01.mp4
//        http://172.17.20.44:8080/script/04.jpg
public class MovieActivity extends AppCompatActivity implements View.OnClickListener {
    JCVideoPlayer.JCAutoFullscreenListener mSensorEventListener;
    SensorManager mSensorManager;
    CustomJcVideo mJcVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String position = getIntent().getStringExtra("a");
        Log.e("position", position);
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


        if (position.equals("0")) {
            FILE_NAME = "/JT/video/13金天国际雪莲生态保&养时尚版全新上线.mp4";

            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际雪莲生态保&养时尚版全新上线");

            Glide.with(this)
                    .load(R.drawable.img13)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("1")) {
            FILE_NAME = "/JT/video/12《聚焦apec》金天国际董事长祖名军接受采访.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "《聚焦apec》金天国际董事长祖名军接受采访");
            Glide.with(this)
                    .load(R.drawable.img12)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("2")) {
            FILE_NAME = "/JT/video/11活力金天，助力中国——金天国际25周年梦想盛典暨公益筑梦远航精彩回顾.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "活力金天，助力中国——金天国际25周年梦想盛典暨公益筑梦远航精彩回顾");
            Glide.with(this)
                    .load(R.drawable.img11)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("3")) {
            FILE_NAME = "/JT/video/10央视七套《聚焦三农》：金天国际圆贫困残障儿童学习梦.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "央视七套《聚焦三农》：金天国际圆贫困残障儿童学习梦");
            Glide.with(this)
                    .load(R.drawable.img10)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("4")) {
            FILE_NAME = "/JT/video/09金天国际25周年梦想盛典暨公益筑梦远航家人祝福.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际25周年梦想盛典暨公益筑梦远航家人祝福");
            Glide.with(this)
                    .load(R.drawable.img09)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("5")) {
            FILE_NAME = "/JT/video/08金天国际25周年梦想盛典暨公益筑梦远航宣导片.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际25周年梦想盛典暨公益筑梦远航宣导片");
            Glide.with(this)
                    .load(R.drawable.img08)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("6")) {
            FILE_NAME = "/JT/video/07-金天国际直销启动暨“和谐与活力”公益盛典完整视频.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际直销启动暨“和谐与活力”公益盛典完整视频");
            Glide.with(this)
                    .load(R.drawable.img07)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("7")) {
            FILE_NAME = "/JT/video/06金天国际璀璨之星讲师大赛宣导预告片.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际璀璨之星讲师大赛宣导预告片");
            Glide.with(this)
                    .load(R.drawable.img06)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("8")) {
            FILE_NAME = "/JT/video/05宿迁智能化产业园落成典礼精彩回顾.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);

            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "宿迁智能化产业园落成典礼精彩回顾");
            Glide.with(this)
                    .load(R.drawable.img05)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("9")) {
            FILE_NAME = "/JT/video/04宿迁智能化产业园落成典礼宣导片.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "宿迁智能化产业园落成典礼宣导片");
            Glide.with(this)
                    .load(R.drawable.img04)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("10")) {
            FILE_NAME = "/JT/video/03直销启动暨“和谐与活力”公益盛典精彩回顾.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "直销启动暨“和谐与活力”公益盛典精彩回顾");
            Glide.with(this)
                    .load(R.drawable.img03)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("11")) {
            FILE_NAME = "/JT/video/02直销启动暨“和谐与活力”公益盛典宣导片.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "直销启动暨“和谐与活力”公益盛典宣导片");
            Glide.with(this)
                    .load(R.drawable.img02)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        } else if (position.equals("12")) {
            FILE_NAME = "/JT/video/01金天国际2016企业宣传片.mp4";
            String path = geStorageDirectory();
            final File file = new File(path);

            mJcVideoPlayerStandard = (CustomJcVideo) findViewById(R.id.jc_video);
            mJcVideoPlayerStandard.setUp(geStorageDirectory()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "金天国际2016企业宣传片");
            Glide.with(this)
                    .load(R.drawable.img01)
                    .into(mJcVideoPlayerStandard.thumbImageView);
        }


        mJcVideoPlayerStandard.looping = true;

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
        mJcVideoPlayerStandard.startPlayLogic();
        mJcVideoPlayerStandard.startWindowFullscreen();



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
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        finish();
    }
    class MyJCBuriedPointStandard implements JCBuriedPointStandard {

        @Override
        public void onEvent(int type, String url, int screen, Object... objects) {

        }
    }
    @Override
    public void onClick(View v) {

        int i = v.getId();


    }





}
