package com.troopes.android.ui.order;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.account.address.AddressAdapter;

import butterknife.BindView;

public class OrderSetAddressFragment extends BaseFragment {

    @BindView(R.id.address_list)
    RecyclerView addressList;
    @BindView(R.id.add_address_container)
    ConstraintLayout addAddressContainer;
    OnFragmentInteractionListener onFragmentInteractionListener;
    private AddressAdapter addressAdapter;

    public static OrderSetAddressFragment newInstance() {
        return new OrderSetAddressFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.order_set_address_fragment;
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
                onFragmentInteractionListener.onInteraction(fragment);
            }
        });
    }

    public void setOnFragmentInteractionListener(OnFragmentInteractionListener onFragmentInteractionListener) {
        this.onFragmentInteractionListener = onFragmentInteractionListener;
    }
}
