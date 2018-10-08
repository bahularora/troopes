package com.troopes.android.ui.account.address;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressHolder extends BaseViewHolder {

    @BindView(R.id.customer_name)
    TextView customerName;
    @BindView(R.id.address_first_line)
    TextView addressFirstLine;
    @BindView(R.id.address_second_line)
    TextView addressSecondLine;
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.select_address)
    RadioButton selectAddress;
    @BindView(R.id.edit_container)
    LinearLayout editContainer;
    @BindView(R.id.delete_container)
    LinearLayout deleteContainer;

    public AddressHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData() {
        customerName.setText("Robin Goyal");
        addressFirstLine.setText("B-147, Sector 6, Noida");
        addressSecondLine.setText("Uttar Pradesh, India");
        phoneNumber.setText("8447975083");
        //on click to selectAddress save state and set it as default address
        //TODO setClickListener for edit and delete Container
    }
}
