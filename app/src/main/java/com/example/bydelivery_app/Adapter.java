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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private static final String TAG = "Adapter";

    private ArrayList<String> productNames = new ArrayList<>();
    private ArrayList<Integer> productImages = new ArrayList<>();
    private ArrayList<String> productSellers = new ArrayList<>();
    private ArrayList<Double> productPrices = new ArrayList<>();
    private ArrayList<Integer> productQuantityList = new ArrayList<>();
    private Context mContext;

    public Adapter(Context mContext, ArrayList<String> productNames, ArrayList<String> productSellers,
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
            }
        });
        holder.removeQuantity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: removeQuantity: " + position);
                int quantidadeProduto = productQuantityList.get(position);

                if (quantidadeProduto > 1) {
                    productQuantityList.set(position, productQuantityList.get(position) - 1);
                    notifyItemChanged(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView productName;
        TextView partnerName;
        TextView productPrice;
        ImageView productDelete;
        ImageView addQuantity;
        ImageView removeQuantity;
        TextView productQuantity;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
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

}
