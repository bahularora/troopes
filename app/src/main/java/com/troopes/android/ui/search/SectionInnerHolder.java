package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.SubCategory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionInnerHolder extends BaseViewHolder {

    @BindView(R.id.section_item_image)
    ImageView sectionItemImage;
    @BindView(R.id.section_item_text)
    TextView sectionItemText;

    public SectionInnerHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(SubCategory subCategory) {
        sectionItemText.setText(subCategory.name);
    }
}