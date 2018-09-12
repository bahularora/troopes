package com.troopes.android.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.troopes.android.R;

public class ExpandableTextView extends AppCompatTextView implements View.OnClickListener {
    private static final int MAX_LINES = 3;

    public ExpandableTextView(Context context) {
        super(context);
        init();
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOnClickListener(this);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_expand_more_black_24dp);
        setMaxLines(MAX_LINES);
    }

    @Override
    public void onClick(View v) {
        if (getMaxLines() == Integer.MAX_VALUE) {
            // when expanded -> shrink
            setMaxLines(MAX_LINES);
            setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_expand_more_black_24dp);
        } else {
            // when collapsed -> expand
            setMaxLines(Integer.MAX_VALUE);
            setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_expand_less_black_24dp);
        }
    }
}
