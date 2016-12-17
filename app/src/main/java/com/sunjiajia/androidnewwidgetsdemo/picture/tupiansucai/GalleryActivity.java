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

package com.sunjiajia.androidnewwidgetsdemo.picture.tupiansucai;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.sunjiajia.androidnewwidgetsdemo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    Gallery g = null;
    ArrayList<String> it = new ArrayList<String>();
    ;// 遍历符合条件的列表
    public String actionUrl = null;
    private String FILE_NAME = "Pictures/图片素材/01办公环境";

    private final String SD_PATH = android.os.Environment

            .getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String  position = getIntent().getStringExtra("a");
        Log.e("position",position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("图片");
        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(position.equals("0")){
            FILE_NAME = "JT/Pictures/图片素材/01办公环境";


        }else if (position.equals("1")){
            FILE_NAME = "JT/Pictures/图片素材/02生产基地";

        }else if (position.equals("2")){
            FILE_NAME = "JT/Pictures/图片素材/03星湖半岛";

        }else if (position.equals("3")){
            FILE_NAME = "JT/Pictures/图片素材/04培训基地";

        }else if (position.equals("4")){
            FILE_NAME = "JT/Pictures/图片素材/05金天国际直销启动暨“和谐与活力”公益盛典";

        }else if (position.equals("5")){
            FILE_NAME = "JT/Pictures/图片素材/06金天国际2015年度优秀领导人表彰暨获牌盛典";

        }else if (position.equals("6")){
            FILE_NAME = "JT/Pictures/图片素材/07金天国际宿迁智能化产业园落成典礼";

        }else if (position.equals("7")){
            FILE_NAME = "JT/Pictures/图片素材/08金天国际25周年梦想盛典暨公益筑梦远航";

        }
        g = (Gallery) findViewById(R.id.mygallery);
        //添加一个ImageAdapter并设置给Gallery对象
        g.setAdapter(new ImageAdapter(this, getSD()));
        //设置一个itemclickListener并Toast被单击图片的位置
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                Toast.makeText(GalleryActivity.this,
//                        "序列：" + (position + 1) + "\n路径：" + it.get(position),
//                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(GalleryActivity.this, GalleryDetailActivity.class);
                intent.putExtra("a", it.get(position));
                intent.putExtra("c",position);
                intent.putStringArrayListExtra("b",  it);
                startActivity(intent);
            }
        });
    }

    //遍历SD卡中某一路径下指定类型的图片
    private List<String> getSD() {

        File f = new File(SD_PATH + "//" + FILE_NAME);
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (getImageFile(file.getPath()))
                it.add(file.getPath());
        }
        return it;
    }

    //指定遍历文件类型
    private boolean getImageFile(String fName) {
        boolean re;
        String end = fName
                .substring(fName.lastIndexOf(".") + 1, fName.length())
                .toLowerCase();
        if (end.equals("jpg") || end.equals("gif") || end.equals("png")
                || end.equals("jpeg") || end.equals("bmp")) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }

    //改写BaseAdapter自定义一ImageAdapter class
    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        private List<String> lis;

        public ImageAdapter(Context c, List<String> li) {
            mContext = c;
            lis = li;
            //使用在res/values/aatrs.xml中的<declare-styleable>定义
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery);
            //取得Gallery属性
            mGalleryItemBackground = a.getResourceId(
                    R.styleable.Gallery_android_galleryItemBackground, 0);
            //让对象的styleable属性能够反复使用
            a.recycle();
        }

        //重写的方法，返回图片数目
        public int getCount() {
            return lis.size();
        }

        //重写的方法，返回图片的数组id
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //重写的方法，返回一View对象
        public View getView(int position, View convertView, ViewGroup parent) {
            //产生ImageView对象
            ImageView i = new ImageView(mContext);
            //设置图片给ImageView对象
            Bitmap bm = BitmapFactory.decodeFile(lis.get(position).toString());
            i.setImageBitmap(bm);
            //重新设置图片的宽度
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            //重新设置Layout的宽度
            i.setLayoutParams(new Gallery.LayoutParams(1000, 800));
            //设置Callery背景图
            i.setBackgroundResource(mGalleryItemBackground);
            return i;
        }
    }
}