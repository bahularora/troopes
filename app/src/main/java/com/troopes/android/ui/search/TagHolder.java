package com.troopes.android.ui.search;


import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Tag;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TagHolder extends BaseViewHolder {

    @BindView(R.id.tag_text)
    TextView tagText;

    public TagHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Tag tag) {
        tagText.setText(tag.name);
    }
}
