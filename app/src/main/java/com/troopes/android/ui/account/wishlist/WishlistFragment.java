package com.troopes.android.ui.account.wishlist;

import android.arch.lifecycle.ViewModelProviders;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.Wishlist;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class WishlistFragment extends BaseFragment {

    @BindView(R.id.wish_list)
    RecyclerView wishlist;
    @BindView(R.id.no_wishlist)
    ConstraintLayout noWishlist;
    @BindView(R.id.see_items)
    Button seeItems;

    private WishlistAdapter wishlistAdapter;

    private MainViewModel mainViewModel;

    public static WishlistFragment newInstance() {
        return new WishlistFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.wishlist_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        if (getActivity() == null) {
            return;
        }

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        ArrayList<Wishlist> wishlists = mainViewModel.getWishlists();
        if (wishlists.size() == 0 || wishlists == null) {
            wishlist.setVisibility(View.GONE);
            noWishlist.setVisibility(View.VISIBLE);

            seeItems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                }
            });
        } else {
            noWishlist.setVisibility(View.GONE);
            wishlist.setVisibility(View.VISIBLE);

            wishlistAdapter = new WishlistAdapter();
            wishlistAdapter.setData(wishlists);

            LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            wishlist.setAdapter(wishlistAdapter);
            wishlist.setLayoutManager(llm);
        }
    }
}
