package com.example.bydelivery_app.adapters;

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

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.fragments.CartFragment;
import com.example.bydelivery_app.handlers.Carrinho;
import com.example.bydelivery_app.handlers.NewMath;
import com.example.bydelivery_app.handlers.Produto;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterCartList extends RecyclerView.Adapter<AdapterCartList.ViewHolder>{

    private static final String TAG = "AdapterCartList";

    private View rootView;
    private List<Produto> products;
    private double deliveryPrice;

    public AdapterCartList() {
        this.products = Carrinho.getCartProducts();
        this.deliveryPrice = Carrinho.getDeliveryPrice();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        rootView = view;

        updatePriceOfOrder();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(products.get(position).getProductImage());
        holder.productName.setText(products.get(position).getProductName());
        holder.partnerName.setText(products.get(position).getProductSeller());
        holder.productPrice.setText(String.valueOf(products.get(position).getProductPrice()) + "€");
        holder.productQuantity.setText(String.valueOf(products.get(position).getProductQuantity()));

        holder.productDelete.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {

                Log.d(TAG, "onLongClick: clicked on: " + products.get(position).getProductName());

                products.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, products.size());
                updatePriceOfOrder();

                return true;
            }
        });

        holder.productDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + position);
                Toast.makeText(rootView.getContext(), "Mantenha pressionado para eliminar", Toast.LENGTH_SHORT).show();
            }
        });

        holder.addQuantity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: addQuantity: " + position);

                products.get(position).add();
                notifyItemChanged(position);
                updatePriceOfOrder();
            }
        });
        holder.removeQuantity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: removeQuantity: " + position);

                if (products.get(position).getProductQuantity() > 1) {
                    products.get(position).remove();
                    notifyItemChanged(position);
                    updatePriceOfOrder();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
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

    private void updatePriceOfOrder() {
        CartFragment.updatePriceEvaluation(NewMath.round(Carrinho.getTotalPVPPrice(), 2),
                NewMath.round(Carrinho.getOrderIVA(), 2), NewMath.round(Carrinho.getDeliveryPrice(), 2),
                NewMath.round(Carrinho.getProductsPVPPrice(), 2));

    }

}
