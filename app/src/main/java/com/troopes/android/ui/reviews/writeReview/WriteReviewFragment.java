package com.troopes.android.ui.reviews.writeReview;


import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

import butterknife.BindView;

// TODO fix Toolbar not showing on this screen
public class WriteReviewFragment extends BaseFragment {

    @BindView(R.id.submit_button)
    TextView submitButton;
    @BindView(R.id.add_image)
    LinearLayout addImage;
    @BindView(R.id.review_content)
    EditText reviewContent;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;

    public static WriteReviewFragment newInstance() {
        return new WriteReviewFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.write_review_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        // TODO add code to accept image and update the

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reviewContent.getText();
                //ratingBar.getRating();
            }
        });
    }

}
