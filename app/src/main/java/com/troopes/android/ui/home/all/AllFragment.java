package com.troopes.android.ui.home.all;

import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.product.linearList.LinearListProductAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;

public class AllFragment extends BaseFragment {

    @BindView(R.id.banner)
    ViewPager bannerPager;

    @BindView(R.id.all_list)
    RecyclerView recyclerView;

    @BindView(R.id.indicator)
    CircleIndicator indicator;

    BannerPagerAdapter bannerPagerAdapter;
    LinearListProductAdapter linearListProductAdapter;

    private int currentBannerPage = 0;

    // sample banner images
    private final Integer[] IMAGES = {R.drawable.sample_viewpager1, R.drawable.sample_viewpager2, R.drawable.sample_viewpager3, R.drawable.sample_viewpager4};
    private ArrayList<Integer> bannerImages = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_all;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return R.id.progress_bar;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        showProgressBar();
        bannerImages.addAll(Arrays.asList(IMAGES));
        bannerPagerAdapter = new BannerPagerAdapter(bannerImages);
        linearListProductAdapter = new LinearListProductAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(linearListProductAdapter);
        bannerPager.setAdapter(bannerPagerAdapter);
        indicator.setViewPager(bannerPager);
//        bannerPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

        // stimulating network call
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // TODO use something other than handler and fix circle indicator not showing
        final Handler handler = new Handler();
        final Runnable bannerUpdater = new Runnable() {
            public void run() {
                if (currentBannerPage == bannerImages.size()) {
                    currentBannerPage = 0;
                }
                bannerPager.setCurrentItem(currentBannerPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(bannerUpdater);
            }
        }, 3000, 3000);

        // Pager listener over indicator
//        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int position) {
//                currentBannerPage = position;
//            }
//
//            @Override
//            public void onPageScrolled(int pos, float arg1, int arg2) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int pos) {
//            }
//        });

        hideProgressBar();
    }
}