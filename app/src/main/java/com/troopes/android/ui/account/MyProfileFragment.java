package com.troopes.android.ui.account;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

import butterknife.BindView;

public class MyProfileFragment extends BaseFragment {

    @BindView(R.id.save_button)
    Button saveButton;
    @BindView(R.id.profile_name_editText)
    EditText profileNameEditText;
    @BindView(R.id.edit_photo_icon)
    ImageView editPhotoIcon;
    @BindView(R.id.edit_photo_text)
    TextView editPhotoText;
    @BindView(R.id.gender_radio_group)
    RadioGroup genderRadioGroup;

    public static MyProfileFragment newInstance() {
        return new MyProfileFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.my_profile_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (rb != null) {
                    // assign this gender value to state
                    // rb.getText()
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save details - save state
            }
        });
    }
}
