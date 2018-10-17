package com.troopes.android.ui.product.productOption;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.product.Product;
import com.troopes.android.viewmodel.ProductViewModel;

import butterknife.BindView;

public class ProductOptionFragment extends BaseFragment {

    private static final String ARG_PRODUCT_ID = "productId";
    @BindView(R.id.product_image)
    ImageView productImage;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.size_list)
    RecyclerView sizeList;
    @BindView(R.id.variant_list)
    RecyclerView variantList;
    @BindView(R.id.color_list)
    RecyclerView colorList;
    private long productId;
    private VariantAdapter variantAdapter;
    private SizeAdapter sizeAdapter;
    private ColorAdapter colorAdapter;

    private ProductViewModel productViewModel;

    public static ProductOptionFragment newInstance(long productId) {
        ProductOptionFragment fragment = new ProductOptionFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.product_option_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getArguments() != null) {
            productId = getArguments().getLong(ARG_PRODUCT_ID);
        }

        if (getActivity() == null) {
            return;
        }
        productViewModel = ViewModelProviders.of(getActivity()).get(ProductViewModel.class);

        sizeAdapter = new SizeAdapter();
        colorAdapter = new ColorAdapter();
        variantAdapter = new VariantAdapter();

        Product product = productViewModel.getProduct(productId);
        Picasso.get().load(product.imageUrl).fit().centerCrop().into(productImage);
        productName.setText(product.name);
        sizeAdapter.setData(product.sizeList);
        colorAdapter.setData(product.colorList);
        variantAdapter.setData(product.variantList);

        LinearLayoutManager llm1 = new LinearLayoutManager(view.getContext());
        llm1.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager llm2 = new LinearLayoutManager(view.getContext());
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager llm3 = new LinearLayoutManager(view.getContext());
        llm3.setOrientation(LinearLayoutManager.HORIZONTAL);

        sizeList.setLayoutManager(llm1);
        colorList.setLayoutManager(llm2);
        variantList.setLayoutManager(llm3);

        sizeList.setAdapter(sizeAdapter);
        colorList.setAdapter(colorAdapter);
        variantList.setAdapter(variantAdapter);
    }
}
