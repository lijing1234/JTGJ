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

package com.sunjiajia.androidnewwidgetsdemo.picture.huiyiwuliao;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.sunjiajia.androidnewwidgetsdemo.R;
import com.sunjiajia.androidnewwidgetsdemo.adapter.MyRecyclerViewHolder;

import java.util.ArrayList;

public class HuiyiwuliaoDetailshowActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ImageView iv;
    ArrayList<String> infoList = new ArrayList<String>();
    ViewPager vp;
    int width;
    public LayoutInflater mLayoutInflater;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hui_yi_wu_liao_detail);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        mLayoutInflater = LayoutInflater.from(this);

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
        public Object instantiateItem(ViewGroup view, int position) {





            PhotoView imageView = new PhotoView(mContext);
            imageView.enable();
            imageView.setImageResource(R.drawable.img01);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setMaxScale(5);

            //设置图片给ImageView对象
            Glide.with(mContext)
                    .load(lis.get(position).toString())
                    .fitCenter()
                    .placeholder(R.drawable.loading_4)
                    .into(imageView);

            view.addView(imageView);
            return imageView;
        }

    }


}
