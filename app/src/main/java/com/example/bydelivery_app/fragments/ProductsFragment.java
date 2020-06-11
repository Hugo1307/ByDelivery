package com.example.bydelivery_app.fragments;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterProductsList;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.ProductsList;
import com.example.bydelivery_app.handlers.Produto;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ProductsFragment extends Fragment {

    private static View rootView;
    private List<Produto> productsList = ProductsList.getAllProducts();
    private String categoria;

    public ProductsFragment(List<Produto> productsList, String categoria){
        this.productsList = productsList;
        this.categoria = categoria;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        final TextView categoryLabel = view.findViewById(R.id.productsListCategoryLabel);
        final RelativeLayout topLayout = view.findViewById(R.id.productsListLayout1);
        final RecyclerView recycler = view.findViewById(R.id.productsListRecyclerView);
        final ImageView wavesImg = view.findViewById(R.id.productsListWaves);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        rootView = view;
        categoryLabel.setText(categoria);

        recycler.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (recycler.getAdapter().getItemCount() > 6){
                    ViewGroup.MarginLayoutParams productNameMargins = (ViewGroup.MarginLayoutParams) categoryLabel.getLayoutParams();
                    if (oldScrollY < -5) {
                        productNameMargins.topMargin = 15;
                        categoryLabel.setTextSize(35);
                        transform(topLayout, 300, 200);

                        wavesImg.animate().setDuration(300).alpha(0).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                wavesImg.setVisibility(View.GONE);
                            }
                        });

                    }

                    if (oldScrollY > 5) {
                        productNameMargins.topMargin = 75;
                        categoryLabel.setTextSize(50);
                        wavesImg.setVisibility(View.VISIBLE);
                        wavesImg.animate().setDuration(300).alpha(1);

                        transform(topLayout, 300, 500);
                    }

                }
            }


        });

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        RecyclerView recycler = rootView.findViewById(R.id.productsListRecyclerView);

        AdapterProductsList adapter = new AdapterProductsList(productsList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    public static void openProduct(Produto p){

        Fragment fr = new ProductDetailsFragment(p);
        FragmentChangeListener fc = (FragmentChangeListener) rootView.getContext();
        fc.replaceFragment(fr);

    }

    public void transform(final View v, int duration, int targetHeight) {
        int prevHeight  = v.getHeight();
        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

    private void fadeOut(final View toHide) {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        /*
        contentView.setAlpha(0f);
        contentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        toShow.animate()
                .alpha(1f)
                .setDuration(1000)
                .setListener(null);

         */

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        /*
        toHide.animate()
                .alpha(0f)
                .setDuration(800)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        toHide.setVisibility(View.GONE);
                    }
                });

         */


    }

}
