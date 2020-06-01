package com.example.bydelivery_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.Handler.NewMath;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterProductsList extends RecyclerView.Adapter<AdapterProductsList.ViewHolder>{

    private static final String TAG = "AdapterCartList";

    private ArrayList<String> productNames;
    private ArrayList<Integer> productImages;
    private ArrayList<String> productSellers;
    private ArrayList<Double> productPrices;
    private Context mContext;

    AdapterProductsList(Context mContext, ArrayList<String> productNames, ArrayList<String> productSellers,
                        ArrayList<Double> productPrices, ArrayList<Integer> productImages) {
        this.productNames = productNames;
        this.productSellers = productSellers;
        this.productImages = productImages;
        this.productPrices = productPrices;
        this.mContext = mContext;
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

        holder.productImage.setImageResource(productImages.get(position));
        holder.productImage.setClipToOutline(true);
        holder.productImage.bringToFront();
        holder.productName.setText(productNames.get(position));
        holder.partnerName.setText(productSellers.get(position));
        holder.productPrice.setText(String.valueOf(productPrices.get(position)) + "€");

    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImage;
        TextView productName;
        TextView partnerName;
        TextView productPrice;
        TextView productSeller;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage2);
            productName = itemView.findViewById(R.id.productName2);
            partnerName = itemView.findViewById(R.id.productSellerName2);
            productPrice = itemView.findViewById(R.id.productPrice2);


        }

    }

}
