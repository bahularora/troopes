package com.troopes.android.ui.home.all;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.product.ProductActivity;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;
import com.troopes.android.utils.GridSpacingItemDecoration;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;

public class AllFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    private static final String ARG_PRODUCT_ID = "productId";

    @BindView(R.id.banner)
    ViewPager bannerPager;
    @BindView(R.id.all_list)
    RecyclerView recyclerView;
    @BindView(R.id.indicator)
    CircleIndicator indicator;

    private BannerPagerAdapter bannerPagerAdapter;
    private ProductGridListAdapter productGridListAdapter;

    private MainViewModel mainViewModel;

    private int currentBannerPage = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.all_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return R.id.progress_bar;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        showProgressBar();
        if (getActivity() == null) {
            return;
        }

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        final ArrayList<Integer> bannerImageList = mainViewModel.getBannerImages();
        bannerPagerAdapter = new BannerPagerAdapter(bannerImageList);
        productGridListAdapter = new ProductGridListAdapter();
        productGridListAdapter.setProductList(mainViewModel.getAllProductList());

        GridLayoutManager glm = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(glm);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 6, true));

        recyclerView.setAdapter(productGridListAdapter);
        bannerPager.setAdapter(bannerPagerAdapter);
        indicator.setViewPager(bannerPager);
//        bannerPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);

        productGridListAdapter.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(int position, String name) {
        long productId = mainViewModel.getAllProductList().get(position).productId;
        Intent intent = new Intent(getActivity(), ProductActivity.class);
        intent.putExtra(ARG_PRODUCT_ID, productId);
        startActivity(intent);
    }
}
