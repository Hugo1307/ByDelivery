package com.example.bydelivery_app.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.fragments.ProductsFragment;
import com.example.bydelivery_app.handlers.ProductsList;
import com.example.bydelivery_app.handlers.Produto;

import java.util.ArrayList;
import java.util.List;

public class AdapterProductsList extends RecyclerView.Adapter<AdapterProductsList.ViewHolder>{

    private static final String TAG = "AdapterProductsList";

    private List<Produto> productsList;
    private ArrayList<Integer> productImages;
    private ArrayList<String> productSellers;
    private ArrayList<Double> productPrices;

    public AdapterProductsList(List<Produto> productsList) {
        this.productsList = ProductsList.getAllProducts();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listproduct, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.productImage.setImageResource(productsList.get(position).getProductImage());
        holder.productImage.setClipToOutline(true);
        holder.productImage.bringToFront();
        holder.productName.setText(productsList.get(position).getProductName());
        holder.partnerName.setText(productsList.get(position).getProductSeller());
        holder.productPrice.setText(String.valueOf(productsList.get(position).getProductPrice()) + "€");

        holder.productLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: clicked on: " + productsList.get(position).getProductName());

                ProductsFragment.openProduct(productsList.get(position));
            }
        });

    }


    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout productLayout;
        ImageView productImage;
        TextView productName;
        TextView partnerName;
        TextView productPrice;
        TextView productSeller;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            productLayout = itemView.findViewById(R.id.productLayout);
            productImage = itemView.findViewById(R.id.productImage2);
            productName = itemView.findViewById(R.id.productName2);
            partnerName = itemView.findViewById(R.id.productSellerName2);
            productPrice = itemView.findViewById(R.id.productPrice2);

        }

    }

}
