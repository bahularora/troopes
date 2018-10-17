package com.troopes.android.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.Category;
import com.troopes.android.viewmodel.MainViewModel;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.top_tab_layout)
    SmartTabLayout smartTabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private MainViewModel mainViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.home_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        // we have delegated progress bar to each of its child fragment
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getActivity() == null) {
            return;
        }
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        final int categoriesCount = mainViewModel.getCategoriesCount();
        viewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager(), categoriesCount));
        smartTabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view1 = LayoutInflater.from(smartTabLayout.getContext()).inflate(R.layout.layout_tab, container, false);
                CircleImageView imageView = view1.findViewById(R.id.tab_image);
                TextView textView = view1.findViewById(R.id.tab_text);
                // TODO: decouple this logic
                if (position == 0) {
                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    textView.setText("All");
                } else {
                    Category category = mainViewModel.getCategory(position - 1);
                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    textView.setText(category.getName());
                }
                return view1;
            }
        });
        smartTabLayout.setViewPager(viewPager);
    }
}
