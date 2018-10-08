package com.troopes.android.ui.account;


import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.account.myOrders.MyOrdersFragment;

import butterknife.BindView;

public class AccountFragment extends BaseFragment {

    @BindView(R.id.profile_image)
    ImageView profileImage;
    @BindView(R.id.profile_name_welome)
    TextView profileName;
    @BindView(R.id.about_container)
    ConstraintLayout aboutContainer;
    @BindView(R.id.faq_container)
    ConstraintLayout faqContainer;
    @BindView(R.id.policy_container)
    ConstraintLayout policyContainer;
    @BindView(R.id.my_orders_container)
    ConstraintLayout myOrdersContainer;
    @BindView(R.id.wishlist_container)
    ConstraintLayout wishlistContainer;
    @BindView(R.id.accounts_container)
    ConstraintLayout accountsContainer;
    @BindView(R.id.my_profile_container)
    ConstraintLayout myProfileContainer;

    OnFragmentInteractionListener onFragmentInteractionListener;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.account_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        profileName.setText("Hi");
        aboutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        faqContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        policyContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        myOrdersContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrdersFragment fragment = MyOrdersFragment.newInstance();
                onFragmentInteractionListener.onInteraction(fragment);
            }
        });
        wishlistContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        });
        accountsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountSettingFragment fragment = AccountSettingFragment.newInstance();
                onFragmentInteractionListener.onInteraction(fragment);
            }
        });
        myProfileContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProfileFragment fragment = MyProfileFragment.newInstance();
                onFragmentInteractionListener.onInteraction(fragment);
            }
        });
    }

    @Override
    public void setOnFragmentInteractionListener(OnFragmentInteractionListener onFragmentInteractionListener) {
        this.onFragmentInteractionListener = onFragmentInteractionListener;
    }
}
