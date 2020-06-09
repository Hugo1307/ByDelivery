package com.example.bydelivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.fragments.ParceiroDetailsFragment;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.RecyclerValuesStorage;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterParceirosList extends RecyclerView.Adapter<AdapterParceirosList.ViewHolder> {

    private View rootView;
    private List<Integer> parceirosLogos;
    private List<String> parceirosNames;
    private List<String> parceirosMOTDs;
    private List<Double> parceirosRatings;

    public AdapterParceirosList(){
        this.parceirosLogos = RecyclerValuesStorage.getParceirosLogos();
        this.parceirosNames = RecyclerValuesStorage.getParceirosNames();
        this.parceirosRatings = RecyclerValuesStorage.getParceirosRatings();
        this.parceirosMOTDs = RecyclerValuesStorage.getParceirosMOTDs();
    }

    @NonNull
    @Override
    public AdapterParceirosList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listparceiros, parent, false);
        AdapterParceirosList.ViewHolder holder = new AdapterParceirosList.ViewHolder(view);

        rootView = view;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterParceirosList.ViewHolder holder, int position) {

        holder.parceiroLogo.setImageResource(parceirosLogos.get(position));
        holder.parceiroName.setText(parceirosNames.get(position));
        holder.parceiroMOTD.setText(parceirosMOTDs.get(position));
        holder.parceiroRating.setText(parceirosRatings.get(position) + "★");

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new ParceiroDetailsFragment();
                FragmentChangeListener fc = (FragmentChangeListener) rootView.getContext();
                fc.replaceFragment(fr);
            }
        });

    }

    @Override
    public int getItemCount() {
        return parceirosNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView parceiroLogo;
        TextView parceiroName;
        TextView parceiroMOTD;
        TextView parceiroRating;
        RelativeLayout mainLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            parceiroLogo = itemView.findViewById(R.id.parceirosImage);
            parceiroName = itemView.findViewById(R.id.parceirosName);
            parceiroMOTD = itemView.findViewById(R.id.parceirosMOTD);
            parceiroRating = itemView.findViewById(R.id.parceirosRating);
            mainLayout = itemView.findViewById(R.id.parceirosRecyclerMainLayout);

        }

    }
}
