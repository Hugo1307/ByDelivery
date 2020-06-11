package com.example.bydelivery_app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
import java.util.concurrent.TimeUnit;

public class CartFragment extends Fragment {

    private static View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
                    if (EncomendasList.getListaEncomendas().size() > 4) {
                        Date primeiraData = EncomendasList.getListaEncomendas().get(0).getDeliveryDate();
                        if (getDateDiff(primeiraData, dataAtual, TimeUnit.MINUTES) < 5) {
                            showPopupWindow(rootView, false);
                            return;
                        }
                    }

                    boolean isExpressDelivery;

                    if (Carrinho.getDeliveryPrice() == 0) {
                        isExpressDelivery = false;
                    }else{
                        isExpressDelivery = true;
                    }

                    EncomendasList.addEncomenda(new Encomenda(new ArrayList<Produto>(Carrinho.getCartProducts()),
                            dataAtual, dataPrevista, isExpressDelivery, Carrinho.getTotalPVPPrice(), 1));

                    clearCart(cartRecycler);
                    showPopupWindow(rootView, true);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "Encomenda requisitada", Toast.LENGTH_SHORT).show();
                        }
                    }, 2000);


                }else{
                    Toast.makeText(getContext(), "Tente adicionar alguns produtos primeiro.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        initRecyclerView();

        return view;
    }

    public static void updatePriceEvaluation(double totalPrice, double iva, double deliveryPrice, double productsTotalPrice){
        
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

    public final void showPopupWindow(View view, boolean accepted) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.layout_popup, null);

        // create the popup window
        int width = 500;
        int height = 500;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        TextView label = popupView.findViewById(R.id.popupLabel1);
        ImageView popupImg = popupView.findViewById(R.id.popupCheckImg);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        if (accepted) {
            label.setText("Compra autorizada");
            popupImg.setImageResource(R.drawable.ic_check_black_24dp);
        }else{
            label.setText("Compra recusada");
            popupImg.setImageResource(R.drawable.ic_close_black_24dp);
        }

        popupView.setAlpha(0);
        popupView.animate().setDuration(500).alpha(1);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                popupView.animate().setDuration(500).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        popupView.setVisibility(View.GONE);
                        popupWindow.dismiss();
                    }
                });
            }
        }, 2000);

    }

    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }


}
