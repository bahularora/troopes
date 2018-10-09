package com.troopes.android.ui.order;


import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

import butterknife.BindView;

public class AddAddressFragment extends BaseFragment {

    @BindView(R.id.flat_no_layout)
    TextInputLayout flatNoLayout;
    @BindView(R.id.flat_no_text)
    TextInputEditText flatNoText;
    @BindView(R.id.select_state_layout)
    Spinner spinner;

    public static AddAddressFragment newInstance() {
        return new AddAddressFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.add_address_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        String[] data = new String[3];
        data[0] = "Delhi";
        data[1] = "Noida";
        data[2] = "UP";
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getActivity(), R.layout.spinner_item, data, "select an item");
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getActivity(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        flatNoText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() < 4 && s.length() > 0) {
                    flatNoLayout.setErrorEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 4) {//only do if set error enabled true
                    flatNoLayout.setError("Please fill your Flat/ House No. /Floor / Building");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 4) {
                    flatNoLayout.setErrorEnabled(false);
                }
            }
        });
    }
}
