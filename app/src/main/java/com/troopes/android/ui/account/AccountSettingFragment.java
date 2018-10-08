package com.troopes.android.ui.account;


import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.account.address.AddressFragment;

import butterknife.BindView;

public class AccountSettingFragment extends BaseFragment implements BaseFragment.OnFragmentInteractionListener {

    @BindView(R.id.phone_no)
    EditText phoneNumber;
    @BindView(R.id.email_address)
    EditText emailAddress;
    @BindView(R.id.current_password)
    EditText currentPassword;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.retype_new_password)
    EditText retypedNewPassword;
    @BindView(R.id.add_change_address_container)
    ConstraintLayout addChangeAddressContainer;
    @BindView(R.id.save_button)
    Button saveButton;

    OnFragmentInteractionListener onChildFragmentInteractionListener;

    public static AccountSettingFragment newInstance() {
        return new AccountSettingFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.account_setting_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        addChangeAddressContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressFragment fragment = AddressFragment.newInstance();
                fragment.setOnFragmentInteractionListener(AccountSettingFragment.this);
                onChildFragmentInteractionListener.onInteraction(fragment);
            }
        });
    }

    public void setOnFragmentInteractionListener(OnFragmentInteractionListener onChildFragmentInteractionListener) {
        this.onChildFragmentInteractionListener = onChildFragmentInteractionListener;
    }

    @Override
    public void onInteraction(Fragment fragment) {
        onChildFragmentInteractionListener.onInteraction(fragment);
    }
}
