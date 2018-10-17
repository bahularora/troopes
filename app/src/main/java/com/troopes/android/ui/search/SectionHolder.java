package com.troopes.android.ui.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.Search;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionHolder extends BaseViewHolder {

    @BindView(R.id.section_title)
    TextView title;
    @BindView(R.id.see_more)
    TextView seeMore;
    @BindView(R.id.search_section_item_list)
    RecyclerView sectionItemList;

    public SectionHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    private int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // here 72+4+4(margin) is the dp width of each viewholder
        return (int) (dpWidth / 80);
    }

    public void bindData(Search item) {
        title.setText(item.name);

        int subCategoryListGridCount = calculateNoOfColumns(itemView.getContext());
        GridLayoutManager glm = new GridLayoutManager(itemView.getContext(), subCategoryListGridCount);
        SectionInnerAdapter adapter = new SectionInnerAdapter();
        adapter.setData(item.list);
        sectionItemList.setLayoutManager(glm);
        sectionItemList.setAdapter(adapter);
    }
}