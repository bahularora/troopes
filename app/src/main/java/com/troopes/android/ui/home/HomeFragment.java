package com.troopes.android.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.troopes.android.BaseFragment;
import com.troopes.android.R;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.top_tab_layout)
    SmartTabLayout smartTabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected int getProgressBarLayoutId() {
        // we have delegated progress bar to each of its child fragment
        return 0;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        smartTabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view1 = LayoutInflater.from(smartTabLayout.getContext()).inflate(R.layout.layout_tab,container, false);
                CircleImageView imageView = view1.findViewById(R.id.tab_image);
                TextView textView = view1.findViewById(R.id.tab_text);
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("AllLauncher");
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("Launcher");
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("Launcher");
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("Launcher");
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("Launcher");
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.sample_category);
                        textView.setText("Launcher");
                        break;
                    case 6:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                    case 7:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                    case 8:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                    case 9:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                    case 10:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                    case 11:
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        textView.setText("Launcher");
                        break;
                }
                return view1;
            }
        });
        smartTabLayout.setViewPager(viewPager);
    }
}
