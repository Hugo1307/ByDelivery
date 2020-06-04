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

import com.example.bydelivery_app.fragments.CartFragment;
import com.example.bydelivery_app.handlers.NewMath;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterCartList extends RecyclerView.Adapter<AdapterCartList.ViewHolder>{

    private static final String TAG = "AdapterCartList";

    private ArrayList<String> productNames;
    private ArrayList<Integer> productImages;
    private ArrayList<String> productSellers;
    private ArrayList<Double> productPrices;
    private ArrayList<Integer> productQuantityList;
    private Context mContext;

    public AdapterCartList(Context mContext, ArrayList<String> productNames, ArrayList<String> productSellers,
                    ArrayList<Double> productPrices, ArrayList<Integer> productQuantityList, ArrayList<Integer> productImages) {
        this.productNames = productNames;
        this.productSellers = productSellers;
        this.productImages = productImages;
        this.productPrices = productPrices;
        this.productQuantityList = productQuantityList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        calcPriceOfOrder();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(productImages.get(position));
        holder.productName.setText(productNames.get(position));
        holder.partnerName.setText(productSellers.get(position));
        holder.productPrice.setText(String.valueOf(productPrices.get(position)) + "€");
        holder.productQuantity.setText(String.valueOf(productQuantityList.get(position)));

        holder.productDelete.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {

                Log.d(TAG, "onLongClick: clicked on: " + productNames.get(position));

                productNames.remove(position);
                productImages.remove(position);
                productPrices.remove(position);
                productQuantityList.remove(position);
                productSellers.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, productNames.size());
                calcPriceOfOrder();

                return true;
            }
        });

        holder.productDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + position);
                Toast.makeText(mContext, "Mantenha pressionado para eliminar", Toast.LENGTH_SHORT).show();
            }
        });

        holder.addQuantity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: addQuantity: " + position);
                productQuantityList.set(position, productQuantityList.get(position) + 1);
                notifyItemChanged(position);
                calcPriceOfOrder();
            }
        });
        holder.removeQuantity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int productQuantity = productQuantityList.get(position);
                Log.d(TAG, "onClick: removeQuantity: " + position);

                if (productQuantity > 1) {
                    productQuantityList.set(position, productQuantityList.get(position) - 1);
                    notifyItemChanged(position);
                    calcPriceOfOrder();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView productName;
        TextView partnerName;
        TextView productPrice;
        ImageView productDelete;
        ImageView addQuantity;
        ImageView removeQuantity;
        TextView productQuantity;
        RelativeLayout parentLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            partnerName = itemView.findViewById(R.id.productSellerName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDelete = itemView.findViewById(R.id.productDelete);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            addQuantity = itemView.findViewById(R.id.productAddQuantity);
            removeQuantity = itemView.findViewById(R.id.productRemoveQuantity);
            productQuantity = itemView.findViewById(R.id.productQuantity);

        }

    }

    private void calcPriceOfOrder() {

        Log.d(TAG, "calcPriceOfOrder: called");

        double totalPrice, deliveryPrice = 0, iva, productsTotalPrice = 0;

        for (int i = 0; i < productNames.size(); i++){
            productsTotalPrice += productPrices.get(i) * productQuantityList.get(i);
        }

        iva = (productsTotalPrice + deliveryPrice) * 0.23;
        totalPrice = productsTotalPrice + iva;

        CartFragment.updatePriceEvaluation(NewMath.round(totalPrice, 2), NewMath.round(deliveryPrice, 2),
                NewMath.round(iva, 2), NewMath.round(productsTotalPrice, 2));
    }

    ////////////////////////////////////////////////////////////////
    //                      Getters e Setters
    ////////////////////////////////////////////////////////////////


    void setProductNames(ArrayList<String> productNames) {
        this.productNames = productNames;
    }

    void setProductImages(ArrayList<Integer> productImages) {
        this.productImages = productImages;
    }

    void setProductPrices(ArrayList<Double> productPrices) {
        this.productPrices = productPrices;
    }

    void setProductQuantityList(ArrayList<Integer> productQuantityList) {
        this.productQuantityList = productQuantityList;
    }

    void setProductSellers(ArrayList<String> productSellers) {
        this.productSellers = productSellers;
    }

}
