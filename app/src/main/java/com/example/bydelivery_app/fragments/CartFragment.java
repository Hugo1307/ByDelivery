package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterCartList;
import com.example.bydelivery_app.handlers.Carrinho;
import com.example.bydelivery_app.handlers.Encomenda;
import com.example.bydelivery_app.handlers.EncomendasList;
import com.example.bydelivery_app.handlers.NewMath;
import com.example.bydelivery_app.handlers.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";
    private static View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: started");

        View view = inflater.inflate(R.layout.fragment_cart, null);
        final RelativeLayout panelEntregaNormal = view.findViewById(R.id.cartChoosePanel_EntregaNormal);
        final RelativeLayout panelEntregaExpresso = view.findViewById(R.id.cartChoosePanel_EntregaExpresso);
        final FloatingActionButton finalizeBtn = view.findViewById(R.id.cartFinalize);
        final RecyclerView cartRecycler = view.findViewById(R.id.cartRecyclerView);

        rootView = view;

        panelEntregaNormal.setBackgroundResource(R.drawable.choose_panel_selected);

        panelEntregaNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelEntregaNormal.setBackgroundResource(R.drawable.choose_panel_selected);
                panelEntregaExpresso.setBackgroundResource(R.drawable.choose_panel_unselected);
                Carrinho.setDeliveryPrice(0);
                updatePriceEvaluation(Carrinho.getTotalPVPPrice(), NewMath.round(Carrinho.getOrderIVA(), 2), Carrinho.getDeliveryPrice(),
                        Carrinho.getProductsPVPPrice());
            }
        });

        panelEntregaExpresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelEntregaNormal.setBackgroundResource(R.drawable.choose_panel_unselected);
                panelEntregaExpresso.setBackgroundResource(R.drawable.choose_panel_selected);
                Carrinho.setDeliveryPrice(3.25);
                updatePriceEvaluation(Carrinho.getTotalPVPPrice(), NewMath.round(Carrinho.getOrderIVA(), 2), Carrinho.getDeliveryPrice(),
                        Carrinho.getProductsPVPPrice());
            }
        });

        finalizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int minutesNormalDelivery = (int) (Math.random()* 69) + 1;
                int minutesExpressDelivery = (int) (Math.random()* 29) + 1;

                Date dataAtual = Calendar.getInstance().getTime();
                Calendar dataPrevistaCal = Calendar.getInstance();
                dataPrevistaCal.setTime(new Date(dataAtual.getTime()));

                if (Carrinho.getDeliveryPrice() == 0) {
                    dataPrevistaCal.add(Calendar.MINUTE, minutesNormalDelivery);
                }else{
                    dataPrevistaCal.add(Calendar.MINUTE, minutesExpressDelivery);
                }

                Date dataPrevista = dataPrevistaCal.getTime();

                if (Carrinho.getCartProducts().size() != 0) {

                    boolean isExpressDelivery;

                    if (Carrinho.getDeliveryPrice() == 0) {
                        isExpressDelivery = false;
                    }else{
                        isExpressDelivery = true;
                    }

                    EncomendasList.addEncomenda(new Encomenda(new ArrayList<Produto>(Carrinho.getCartProducts()),
                            dataAtual, dataPrevista, isExpressDelivery));

                    clearCart(cartRecycler);
                    Toast.makeText(getContext(), "Encomenda requisitada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Tente adicionar alguns produtos primeiro.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        initRecyclerView();

        return view;
    }

    public static void updatePriceEvaluation(double totalPrice, double iva, double deliveryPrice, double productsTotalPrice){

        Log.d(TAG, "updatePriceEvaluation: called");
        
        TextView labelTotalPrice = rootView.findViewById(R.id.label_totalPrice);
        TextView labelDeliveryPrice = rootView.findViewById(R.id.label_entregaPrice);
        TextView labelIvaPrice = rootView.findViewById(R.id.label_totalIVA);
        TextView labelProductsPrice = rootView.findViewById(R.id.label_productsTotalPrice);

        labelTotalPrice.setText(rootView.getContext().getString(R.string.totalPrice, String.valueOf(totalPrice)));
        labelDeliveryPrice.setText(rootView.getContext().getString(R.string.deliveyPrice, String.valueOf(deliveryPrice)));
        labelIvaPrice.setText(rootView.getContext().getString(R.string.ivaPrice, String.valueOf(iva)));
        labelProductsPrice.setText(rootView.getContext().getString(R.string.totalProductsPrice, String.valueOf(productsTotalPrice)));

        if (productsTotalPrice == 0) {
            rootView.findViewById(R.id.emptyCart).setVisibility(View.VISIBLE);
            rootView.findViewById(R.id.cartRecyclerView).setVisibility(View.INVISIBLE);
        }else{
            rootView.findViewById(R.id.emptyCart).setVisibility(View.INVISIBLE);
            rootView.findViewById(R.id.cartRecyclerView).setVisibility(View.VISIBLE);
        }

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.cartRecyclerView);
        AdapterCartList adapter = new AdapterCartList();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        updatePriceEvaluation(0, 0, 0, 0);
    }

    private void clearCart(RecyclerView cartRecycler) {
        Carrinho.clear();
        Objects.requireNonNull(cartRecycler.getAdapter()).notifyDataSetChanged();
        updatePriceEvaluation(0,0,0,0);
        rootView.findViewById(R.id.emptyCart).setVisibility(View.VISIBLE);
    }

}
