package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.product.Color;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColorHolder extends BaseViewHolder {
    @BindView(R.id.color_image)
    ImageView colorSquare;
    @BindView(R.id.color_text)
    TextView colorText;

    public ColorHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Color color) {
        colorSquare.setBackgroundColor(color.color);
        colorText.setText(color.name);
    }
}
