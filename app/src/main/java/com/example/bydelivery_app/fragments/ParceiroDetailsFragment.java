package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.Parceiro;
import com.example.bydelivery_app.handlers.Pesquisa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ParceiroDetailsFragment extends Fragment {

    private View rootView;
    private Parceiro partner;

    public ParceiroDetailsFragment(Parceiro partner) {
        this.partner = partner;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parceiro_details, null);

        ImageView partnerImage = view.findViewById(R.id.parceiroDetailsImage);
        final TextView partnerName = view.findViewById(R.id.parceiroDetailsName);
        TextView partnerRating = view.findViewById(R.id.parceiroDetailsRating);
        TextView partnerDescription = view.findViewById(R.id.parceiroDetailsMot);
        TextView partnerLocation = view.findViewById(R.id.parceiroDetailsLocation);
        TextView partnerContact = view.findViewById(R.id.parceiroDetailsContact);
        TextView partnerSchedule = view.findViewById(R.id.parceiroDetailsSchedule);
        TextView partnerStoreStatus = view.findViewById(R.id.parceiroDetailsStoreStatus);
        FloatingActionButton partnerProductsBtn = view.findViewById(R.id.parceiroDetailsCheckProductsBtn);

        rootView = view;
        partnerImage.setImageResource(partner.getPartnerImage());
        partnerName.setText(partner.getPartnerName());
        partnerRating.setText(partner.getPartnerRating() + "★");
        partnerDescription.setText(partner.getPartnerDescription());
        partnerLocation.setText(partner.getPartnerLocation());
        partnerContact.setText(partner.getPartnerContact());
        partnerSchedule.setText(String.format("%02d", partner.getPartnerOpenSchedule().getHours()) + ":" + String.format("%02d", partner.getPartnerOpenSchedule().getMinutes()) + "-" +
                String.format("%02d", partner.getPartnerCloseSchedule().getHours()) + ":" + String.format("%02d", partner.getPartnerCloseSchedule().getMinutes()));
        if (partner.isPartnerStoreOpen()) {
             partnerStoreStatus.setText("Aberto");
        }else{
            partnerStoreStatus.setText("Fechado");
        }

        partnerProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new SearchFragment(Pesquisa.getProductsBySeller(partner.getPartnerName()));
                FragmentChangeListener fc = (FragmentChangeListener) rootView.getContext();
                fc.replaceFragment(fr);
            }
        });

        return view;
    }
}
