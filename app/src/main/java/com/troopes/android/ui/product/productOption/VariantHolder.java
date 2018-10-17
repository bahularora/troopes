package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.product.Variant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VariantHolder extends BaseViewHolder {
    @BindView(R.id.variant_image_item)
    ImageView variantImage;

    public VariantHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Variant variant) {
        Picasso.get().load(variant.imageUrl).fit().centerCrop().into(variantImage);
    }
}