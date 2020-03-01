package com.example.fasttechnologies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context mcontext;

    ImageAdapter(Context context) {
        this.mcontext = context;
    }
    @Override
    public boolean isViewFromObject(View view,Object object){
        return view == ((ImageView)  object);}
    private int[] sliderImageId = new int[]{
            R.drawable.aade, R.drawable.bc, R.drawable.ceh,R.drawable.fewd, R.drawable.phplarval,R.drawable.pyndj,R.drawable.uthreed
    };
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
    @Override
    public int getCount() {
        return sliderImageId.length;
    }
}
