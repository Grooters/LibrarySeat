package io.github.grooters.lller.widget.pager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ViewPageRer extends ViewPager implements ViewPager.OnPageChangeListener{

    private static final String TAG= ViewPageRer.class.getSimpleName();
    private Context context;
    private List<Fragment> fragments;
    private List<View> views;
    private ViewPagerInterface viewPagerInterface;

    public ViewPageRer(@NonNull Context context) {
        super(context);
    }

    public ViewPageRer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG,"ViewPageRer");
    }

    /**
     * 初始化ViewPager
     * @param context 上下文
     * @param fragments 需要添加页面的Fragment集合
     * @param views 需要添加页面的view视图集合
     * @param fm FragmentManager实例
     * @param viewPagerInterface 响应接口，用于执行点击滑动事件等业务逻辑
     */
    public void init(Context context,List<Fragment> fragments, List<View> views,FragmentManager fm,ViewPagerInterface viewPagerInterface){
        this.context=context;
        this.fragments=fragments;
        this.views=views;
        this.viewPagerInterface=viewPagerInterface;
        setAdapter(new FragmentPagerAdapterr(fm));
    }

    public interface ViewPagerInterface{
        public void handle(int position,int state,float positionOffset, int positionOffsetPixels);
    }

    /**
     * 默认适配器
     */
    private class FragmentPagerAdapterr extends FragmentPagerAdapter {
        private FragmentPagerAdapterr(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            Log.i(TAG,"fragments.size()："+fragments.size());
            return fragments.size();
        }
        @Override
        public Fragment getItem(int position) {
            Log.i(TAG,"position："+position);
            return fragments.get(position);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position,positionOffset,positionOffsetPixels);
        viewPagerInterface.handle(position,-1,positionOffset,positionOffsetPixels);
    }
    @Override
    public void onPageSelected(int position) {
        viewPagerInterface.handle(position,-1,-1,-1);
    }
    @Override
    public void onPageScrollStateChanged(int state) {
        viewPagerInterface.handle(-1,state,-1,-1);
    }


    private class FragmentStatePagerAdapterr extends android.support.v4.app.FragmentStatePagerAdapter{
        public FragmentStatePagerAdapterr(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
        @Override
        public Fragment getItem(int position) {
            Log.i(TAG,"position："+position);
            return fragments.get(position);
        }
    }
    private class PagerAdapterr extends PagerAdapter {
        public PagerAdapterr() {
            super();
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position));
            Log.i(TAG,"instantiateItem"+position);
            return views.get(position);
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(views.get(position));
            Log.i(TAG,"destroyItem"+position);
        }
    }


}
