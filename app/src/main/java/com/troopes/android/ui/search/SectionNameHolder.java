package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Search;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionNameHolder extends BaseViewHolder implements View.OnClickListener {

    @BindView(R.id.section_name_item)
    TextView sectionName;

    private OnViewHolderClickListener onViewHolderClickListener;

    public SectionNameHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Search item) {
        sectionName.setText(item.name);
        sectionName.setOnClickListener(this);
    }

    @Override
    protected void setOnViewHolderClick(BaseViewHolder.OnViewHolderClickListener onViewHolderClickListener) {
        this.onViewHolderClickListener = onViewHolderClickListener;
    }

    @Override
    public void onClick(View view) {
        if (onViewHolderClickListener != null) {
            onViewHolderClickListener.onViewHolderClick(this);
        }
    }
}