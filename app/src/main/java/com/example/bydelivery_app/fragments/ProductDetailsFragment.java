package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.Carrinho;
import com.example.bydelivery_app.handlers.Encomenda;
import com.example.bydelivery_app.handlers.EncomendasList;
import com.example.bydelivery_app.handlers.OrdinaryMethods;
import com.example.bydelivery_app.handlers.Produto;

import java.util.Calendar;
import java.util.Date;

public class ProductDetailsFragment extends Fragment {

    private static final String TAG = "ProductDetailsFragment";
    private View rootView;
    
    private Produto product;

    public ProductDetailsFragment (Produto p) {
        this.product = p;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productdetails, null);

        RelativeLayout imageProductImg = view.findViewById(R.id.productDetailsBanner);
        TextView labelProductName = view.findViewById(R.id.productDetailsNameLabel);
        TextView labelProductSeller = view.findViewById(R.id.productDetailsSeller);
        TextView labelProductDescription = view.findViewById(R.id.productDetailsDescription);
        TextView labelProductWeight = view.findViewById(R.id.productDetailsLabelPeso);
        TextView labelProductSize = view.findViewById(R.id.productDetailsLabelTamanho);
        final RatingBar productRatingBar = view.findViewById(R.id.productDetailsRatingBar);
        final Date currentTime = Calendar.getInstance().getTime();

        rootView = view;

        imageProductImg.setBackgroundResource(product.getProductImage());
        labelProductName.setText(product.getProductName());
        labelProductSeller.setText(product.getProductSeller());
        labelProductDescription.setText(product.getProductDescription());
        labelProductWeight.setText(String.valueOf(product.getProductWeight()) + " g");

        productRatingBar.setRating((float)product.getProductRating());

        productRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                boolean canEvaluate = false;
                for (Encomenda e : EncomendasList.getListaEncomendas()) {
                    if (e.getProductsList().contains(product))
                        canEvaluate = true;
                }

                if (!canEvaluate && fromUser) {
                    Toast.makeText(getContext(), "Só poderá avaliar depois de comprar", Toast.LENGTH_SHORT).show();
                    productRatingBar.setRating((float)product.getProductRating());
                }

            }
        });

        view.findViewById(R.id.productDetailsBuyNowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: button clicked");

                Carrinho.addProduct(product);

                OrdinaryMethods.addNotification(product.getProductImage(), product.getProductName(),
                        "Novo produto adicionado ao carrinho",
                        currentTime.getHours() + ":" + String.format("%02d", currentTime.getMinutes()));

                Toast.makeText(getContext(), "Produto adicionaado ao carrinho", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }



}
