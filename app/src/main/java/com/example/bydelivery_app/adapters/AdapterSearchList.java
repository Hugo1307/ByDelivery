package com.example.bydelivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.fragments.SearchFragment;
import com.example.bydelivery_app.handlers.Produto;

import java.util.List;

public class AdapterSearchList extends RecyclerView.Adapter<AdapterSearchList.ViewHolder> {

    private View rootView;
    private List<Produto> searchResults;

    public AdapterSearchList(List<Produto> searchResults) {
        this.searchResults = searchResults;
    }

    @NonNull
    @Override
    public AdapterSearchList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listsearches, parent, false);
        AdapterSearchList.ViewHolder holder = new AdapterSearchList.ViewHolder(view);

        rootView = view;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearchList.ViewHolder holder, final int position) {

        holder.searchProductImage.setImageResource(searchResults.get(position).getProductImage());
        holder.searchProductImage.setClipToOutline(true);
        holder.searchProductImage.bringToFront();
        holder.searchProductName.setText(searchResults.get(position).getProductName());
        holder.searchProductPrice.setText(String.valueOf(searchResults.get(position).getProductPrice()) + "€");
        holder.searchProductSeller.setText(searchResults.get(position).getProductSeller());

        holder.searchMainItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment.showProduct(searchResults.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout searchMainItemLayout;
        TextView searchProductName;
        TextView searchProductSeller;
        TextView searchProductPrice;
        ImageView searchProductImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            searchMainItemLayout = itemView.findViewById(R.id.searchItemMainLayout);
            searchProductName = itemView.findViewById(R.id.searchProductName);
            searchProductSeller = itemView.findViewById(R.id.searchProductSeller);
            searchProductPrice = itemView.findViewById(R.id.searchProductPrice);
            searchProductImage = itemView.findViewById(R.id.searchProductImage);

        }

    }
}
