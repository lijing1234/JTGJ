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

package com.sunjiajia.androidnewwidgetsdemo.ppt;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.LinearLayout;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyGalleryRecyclerViewAdapter;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyStaggeredViewAdapter;

import java.io.File;
import java.util.ArrayList;

public class PptGalleryActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    Gallery g = null;

    ;// 遍历符合条件的列表
    public String actionUrl = null;
    private String FILE_NAME = "Pictures/图片素材/pc01";

    private final String SD_PATH = android.os.Environment

            .getExternalStorageDirectory().getAbsolutePath();
    ArrayList<String> it ;
    int width;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyGalleryRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;
    private static final int SPAN_COUNT = 2;

    ViewPager vp;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt_gallery);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        String position = getIntent().getStringExtra("a");
        Log.e("position", position);
       toolbar = (Toolbar) findViewById(R.id.id_toolbar);

        if (position.equals("0")) {

            FILE_NAME = "JT/ppt/11635营销宝典";


            toolbar.setTitle("635营销宝典");


        } else if (position.equals("1")) {

            FILE_NAME = "JT/ppt/10金天国际 基础训";
            toolbar.setTitle("金天国际 基础训");
        } else if (position.equals("2")) {

            FILE_NAME = "JT/ppt/09生态保养咨询过程中需掌握的技巧和方法";
            toolbar.setTitle("生态保养咨询过程中需掌握的技巧和方法");
        } else if (position.equals("3")) {
            FILE_NAME = "JT/ppt/08专业咨询需掌握的基础知识";
            toolbar.setTitle("专业咨询需掌握的基础知识");

        } else if (position.equals("4")) {
            FILE_NAME = "JT/ppt/07讲师基本素质";
            toolbar.setTitle("讲师基本素质");
        } else if (position.equals("5")) {
            FILE_NAME = "JT/ppt/06讲师训班前训";
            toolbar.setTitle("讲师训班前训");
        } else if (position.equals("6")) {
            FILE_NAME = "JT/ppt/05十大亮点";
            toolbar.setTitle("十大亮点");
        } else if (position.equals("7")) {
            FILE_NAME = "JT/ppt/04十大举措";
            toolbar.setTitle("十大举措");
        } else if (position.equals("8")) {
            FILE_NAME = "JT/ppt/03模式篇";
            toolbar.setTitle("模式篇");
        } else if (position.equals("9")) {
            FILE_NAME = "JT/ppt/02产品篇";
            toolbar.setTitle("产品篇");
        } else if (position.equals("10")) {
            FILE_NAME = "JT/ppt/01企业篇";
            toolbar.setTitle("企业篇");
        }

        setSupportActionBar(toolbar);  // 用ToolBar代替ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        vp = (ViewPager) findViewById(R.id.pptvp);
        vp.setAdapter(new ImageAdapter(this, getSD()));
        vp.setOnPageChangeListener(this);
        vp.setCurrentItem(0);


    }

    //遍历SD卡中某一路径下指定类型的图片
    private ArrayList<String> getSD() {



        File f = new File(SD_PATH + "//" + FILE_NAME);
        File[] files = f.listFiles();
         it = new ArrayList<String>(files.length);

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            Log.e("file", String.valueOf(file));
            String ss = file.getName();
            Log.e("ss", ss);
            String rel = ss.trim().substring(3, ss.lastIndexOf("."));
            Log.e("rel", rel);
            int dd = Integer.parseInt(rel) - 1;
            Log.e("rel", String.valueOf(dd));
            if (dd == it.size()) {
                if (getImageFile(file.getPath())) {
                    it.add(dd, file.getPath());
                }

            } else {
                for (int j = 0; j < files.length; j++) {
                    File fi = files[j];
                    Log.e("file", String.valueOf(fi));
                    String s = fi.getName();
                    Log.e("ss", ss);
                    String re = s.trim().substring(3, s.lastIndexOf("."));
                    Log.e("re", re);
                    int d = Integer.parseInt(re) - 1;
                    if (d == it.size()) {
                        it.add(d, fi.getPath());
                    }
                }
            }

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
                || end.equals("jpeg") || end.equals("bmp") || end.equals("JPG")) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //改写BaseAdapter自定义一ImageAdapter class
    public class ImageAdapter extends PagerAdapter {
        private Context mContext;
        private ArrayList<String> lis;

        public ImageAdapter(Context c, ArrayList<String> li) {
            mContext = c;
            lis = li;

        }

        //重写的方法，返回图片数目
        public int getCount() {
            return lis.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {

            view.removeView((View) object);
        }

        // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView imageView = new PhotoView(mContext);
            imageView.enable();
            imageView.setImageResource(R.drawable.img01);
            imageView.setAdjustViewBounds(true);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            imageView.setLayoutParams(params);
            imageView.setMaxWidth(width);
            imageView.setMaxHeight(width * 30);
            Glide.with(PptGalleryActivity.this)
                    .load(lis.get(position).toString())
                    .into(imageView);

            container.addView(imageView);
            return imageView;
        }
    }
}
