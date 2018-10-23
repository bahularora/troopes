package com.troopes.android.ui.account;


import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

import butterknife.BindView;

public class AccountFragment extends BaseFragment {

    private static final String ARG_ACC_SCREEN  = "account_screen";

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
    protected void init(final View view) {
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
                //MyOrdersFragment fragment = MyOrdersFragment.newInstance();
                //onFragmentInteractionListener.onInteraction(fragment);
                Intent intent = new Intent(view.getContext(), AccountMediatorActivity.class);
                intent.putExtra(ARG_ACC_SCREEN, "MyOrdersFragment");
                startActivity(intent);
            }
        });
        wishlistContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WishlistFragment fragment = WishlistFragment.newInstance();
                //onFragmentInteractionListener.onInteraction(fragment);
                Intent intent = new Intent(view.getContext(), AccountMediatorActivity.class);
                intent.putExtra(ARG_ACC_SCREEN, "WishlistFragment");
                startActivity(intent);
            }
        });
        accountsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AccountSettingFragment fragment = AccountSettingFragment.newInstance();
                //fragment.setOnFragmentInteractionListener(AccountFragment.this);
                //onFragmentInteractionListener.onInteraction(fragment);
                Intent intent = new Intent(view.getContext(), AccountMediatorActivity.class);
                intent.putExtra(ARG_ACC_SCREEN, "AccountSettingFragment");
                startActivity(intent);
            }
        });
        myProfileContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyProfileFragment fragment = MyProfileFragment.newInstance();
                //onFragmentInteractionListener.onInteraction(fragment);
                Intent intent = new Intent(view.getContext(), AccountMediatorActivity.class);
                intent.putExtra(ARG_ACC_SCREEN, "MyProfileFragment");
                startActivity(intent);
            }
        });
    }

}
