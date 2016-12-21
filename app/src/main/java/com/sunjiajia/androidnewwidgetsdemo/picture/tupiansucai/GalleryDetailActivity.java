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
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.view.PhotoViewPager;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

public class GalleryDetailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ImageView iv;
    ArrayList<String> infoList = new ArrayList<String>();
    ViewPager vp;
    int width;
    PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
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
        String path = getIntent().getStringExtra("a");
        infoList = getIntent().getStringArrayListExtra("b");
        int postion = getIntent().getIntExtra("c", 1);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new ImageAdapter(this, infoList));
        vp.setOnPageChangeListener(this);
        vp.setCurrentItem(postion);

        //重新设置图片的宽度


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
            Glide.with(GalleryDetailActivity.this)
                    .load(lis.get(position).toString())
                    .into(imageView);

            container.addView(imageView);
            return imageView;
        }
    }
}
