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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PictureActivity extends AppCompatActivity implements android.view.GestureDetector.OnGestureListener {
    private ViewFlipper viewFlipper = null;
    public String FileDir = null;
    public int counter = 0;
    public Bitmap[] bitmap_jj = new Bitmap[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);     //这个貌似没有意义
        setContentView(R.layout.activity_picture);
        closeBar();
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        new GestureDetector(this);
        SavaBitmap();
        for (int i = 0; i < counter; i++) {
            System.out.println(i);
            ImageView iv = new ImageView(this);    // 在ViewFlipper中插入ImagineView
            iv.setImageBitmap(bitmap_jj[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(iv, new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT,
                    ActionBar.LayoutParams.FILL_PARENT));
        }
        viewFlipper.setAutoStart(true);   //设置自动播放
        viewFlipper.setFlipInterval(10000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    private String isSdcard() {            //判断sd卡知否存在并且得到sd卡的目录
        File sdcardDir = null;
        boolean isSDExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
        if (isSDExist) {
            // 如果存在SDcard 就找到跟目录
            sdcardDir = Environment.getExternalStorageDirectory();

            return sdcardDir.toString();
        } else {
            return null;
        }
    }

    //这个函数的存在的是因为在android电视上会有一个不能隐藏的操作栏
    //这个方法是百度来的，意义在于隐藏下面的那一条操作栏，但是仅限于在root的设备上使用
    private void closeBar() {
        try {
            new Build.VERSION_CODES();
            new Build.VERSION();
            String ProcID = "79";

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                ProcID = "42"; // ICS AND NEWER
            }

            // 需要root 权限
            Process proc = Runtime.getRuntime().exec(
                    new String[]{
                            "su",
                            "-c",
                            "service call activity " + ProcID
                                    + " s16 com.android.systemui"}); // WAS 79
            proc.waitFor();

        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }

    //这是显示操作栏的方法
    private void showBar() {
        try {
            Process proc = Runtime.getRuntime().exec(
                    new String[]{"am", "startservice", "-n",
                            "com.android.systemui/.SystemUIService"});
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取本地视频路径

    private String geStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? sdPath + FILE_NAME : dataPath + FILE_NAME;


    }

    private String sdPath = Environment.getExternalStorageDirectory().getPath();
    //    private String FILE_NAME = "/video/01.mp4";
    private String FILE_NAME = "/Pictures/";
    private String dataPath = null;
    //遍历目录下的图片文件，然后，存储在BitMap数组中，
    private void SavaBitmap() {
        File file_ = new File(geStorageDirectory());
        File[] files = file_.listFiles();
        if (files != null) {
            int count = files.length;
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                File file = files[i];
                String filepath = file.getAbsolutePath();   //得到路径
                if (filepath.endsWith("jpg") || filepath.endsWith("gif")
                        || filepath.endsWith("bmp") || filepath.endsWith("png")) {
                    ArrayList<String> myFilePath = new ArrayList<String>();//吧路径存入容器中
                    myFilePath.add(file.getName());
                    System.out.println("size is " + myFilePath.size());
                    for (int j = 0; j < myFilePath.size(); j++) { //本来是用foreach的方式遍历，发现那样所有的字符都会一次性输出
                        String ll = myFilePath.get(j);
                        System.out.println(ll);
                        FileInputStream fis = null;
                        try {
                            fis = new FileInputStream(geStorageDirectory()    //ll中只有文件名，没有路径，坑了我很久，然后输出日志才突然发现原因所在
                                    );
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            System.out.println("error");
                            e.printStackTrace();
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);  //把路径中的图片读出来 转化为bitmap并且放入数组中
                        Bitmap bitmap = BitmapFactory.decodeStream(bis);
                        bitmap_jj[counter] = bitmap;
                        counter++;
                    }

                }
            }
        }
    }
}
