package com.troopes.android.ui.home.all;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.product.linearList.LinearListProductAdapter;
import com.troopes.android.viewmodel.AllProductListViewModel;

import java.util.ArrayList;
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

    private AllProductListViewModel allProductListViewModel;

    private int currentBannerPage = 0;

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

        allProductListViewModel = ViewModelProviders.of(getActivity()).get(AllProductListViewModel.class);
        final ArrayList<Integer> bannerImageList = allProductListViewModel.getBannerImages();
        bannerPagerAdapter = new BannerPagerAdapter(bannerImageList);
        linearListProductAdapter = new LinearListProductAdapter();
        linearListProductAdapter.setProductListData(allProductListViewModel.getAllProductList());

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(linearListProductAdapter);
        bannerPager.setAdapter(bannerPagerAdapter);
        indicator.setViewPager(bannerPager);
//        bannerPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

        // TODO: use something other than handler and fix circle indicator not showing
        // TODO: decouple this part from bannerImagesList
        final Handler handler = new Handler();
        final Runnable bannerUpdater = new Runnable() {
            public void run() {
                if (currentBannerPage == bannerImageList.size()) {
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

        hideProgressBar();
    }
}
