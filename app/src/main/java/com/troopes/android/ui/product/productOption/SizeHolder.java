package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.product.Size;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SizeHolder extends BaseViewHolder {
    @BindView(R.id.product_size_item)
    TextView sizeText;

    public SizeHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Size size) {
        sizeText.setText(size.name);
    }

}