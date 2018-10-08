package com.troopes.android.ui.account.address;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.order.AddAddressFragment;

import butterknife.BindView;

public class AddressFragment extends BaseFragment {

    @BindView(R.id.address_list)
    RecyclerView addressList;
    @BindView(R.id.add_address_container)
    ConstraintLayout addAddressContainer;
    OnFragmentInteractionListener onChildFragmentInteractionListener;
    private AddressAdapter addressAdapter;

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.address_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        addressAdapter = new AddressAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        addressList.setAdapter(addressAdapter);
        addressList.setLayoutManager(llm);

        addAddressContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAddressFragment fragment = AddAddressFragment.newInstance();
                onChildFragmentInteractionListener.onInteraction(fragment);
            }
        });
    }

    public void setOnFragmentInteractionListener(OnFragmentInteractionListener onChildFragmentInteractionListener) {
        this.onChildFragmentInteractionListener = onChildFragmentInteractionListener;
    }
}
