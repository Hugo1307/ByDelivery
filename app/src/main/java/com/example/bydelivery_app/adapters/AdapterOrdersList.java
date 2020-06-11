package com.example.bydelivery_app.adapters;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.Encomenda;
import com.example.bydelivery_app.handlers.EncomendasList;
import com.example.bydelivery_app.handlers.OrdinaryMethods;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterOrdersList extends RecyclerView.Adapter<AdapterOrdersList.ViewHolder> {

    private List<Encomenda> orders;
    private View rootView;

    public AdapterOrdersList() {
        this.orders = EncomendasList.getListaEncomendas();
    }

    @NonNull
    @Override
    public AdapterOrdersList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listorders, parent, false);
        AdapterOrdersList.ViewHolder holder = new AdapterOrdersList.ViewHolder(view);

        rootView = view;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterOrdersList.ViewHolder holder, final int position) {

        holder.orderName.setText("Encomenda #" + orders.get(position).getDeliveryId());

        Date currentDate = Calendar.getInstance(TimeZone.getDefault()).getTime();

        if (getDateDiff(orders.get(position).getDeliveryDate(), currentDate, TimeUnit.MINUTES) >= 3) {
            orders.get(position).setDeliveryState(2);
        }

        if (getDateDiff(orders.get(position).getDeliveryDate(), currentDate, TimeUnit.MINUTES) >=
                getDateDiff(orders.get(position).getDeliveryDate(), orders.get(position).getDeliveryPrevision(), TimeUnit.MINUTES)) {
            orders.get(position).setDeliveryState(3);
        }

        switch (orders.get(position).getDeliveryState()){
            case 1:
                holder.orderStatus.setText("Em preparação");
                OrdinaryMethods.addNotification(orders.get(position).getProductsList().get(0).getProductImage(),
                        "Encomenda #" + orders.get(position).getDeliveryId(), "A encomenda entrontra-se em preparação",
                        String.format("%02d:%02d", currentDate.getHours(), currentDate.getMinutes()));
                break;
            case 2:
                holder.orderStatus.setText("Em trânsito");
                OrdinaryMethods.addNotification(orders.get(position).getProductsList().get(0).getProductImage(),
                        "Encomenda #" + orders.get(position).getDeliveryId(), "A encomenda entrontra-se em trânsito",
                        String.format("%02d:%02d", currentDate.getHours(), currentDate.getMinutes()));
                break;
            case 3:
                holder.orderStatus.setText("Entregue");
                OrdinaryMethods.addNotification(orders.get(position).getProductsList().get(0).getProductImage(),
                        "Entrega #" + orders.get(position).getDeliveryId(), "A encomenda foi entregue",
                        String.format("%02d:%02d", currentDate.getHours(), currentDate.getMinutes()));
                break;
        }

        if (orders.get(position).getProductsList().size() >= 1) {
            holder.orderImage.setImageResource(orders.get(position).getProductsList().get(0).getProductImage());
        }

        holder.orderDate.setText(String.format("%02d:%02d", orders.get(position).getDeliveryDate().getHours(), orders.get(position).getDeliveryDate().getMinutes()));
        holder.orderPrevision.setText(String.format("%02d:%02d", orders.get(position).getDeliveryPrevision().getHours(), orders.get(position).getDeliveryPrevision().getMinutes()));
        holder.orderPrice.setText(orders.get(position).getDeliveryPrice() + "€");

        if (orders.get(position).isExpressDelivery()) {
            holder.orderDeliveryType.setVisibility(View.VISIBLE);
        }else{
            holder.orderDeliveryType.setVisibility(View.INVISIBLE);
        }

        holder.orderCancel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (orders.get(position).getDeliveryState() == 1) {
                    EncomendasList.removeEncomenda(position);
                    notifyDataSetChanged();
                    Toast.makeText(rootView.getContext(), "Cancelamento efetuado com sucesso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(rootView.getContext(), "Já não é possível cancelar a encomenda", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        holder.orderCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rootView.getContext(), "Pressione para cancelar a encomenda", Toast.LENGTH_SHORT).show();
            }
        });

        holder.orderMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (holder.mainLayout.getHeight() > holder.topLayout.getHeight()) {
                    transform(holder.mainLayout, 800, holder.topLayout.getHeight());
                }else{
                    transform(holder.mainLayout, 800, 875);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static void transform(final View v, int duration, int targetHeight) {
        int prevHeight  = v.getHeight();
        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout mainLayout;
        RelativeLayout topLayout;
        CircleImageView orderImage;
        TextView orderStatus;
        TextView orderName;
        TextView orderDate;
        TextView orderPrevision;
        TextView orderPrice;
        ImageView orderMoreInfo;
        ImageView orderCancel;
        ImageView orderDeliveryType;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderStatus = itemView.findViewById(R.id.ordersItemEstadoPedido);
            mainLayout = itemView.findViewById(R.id.ordersItemMainLayout);
            topLayout = itemView.findViewById(R.id.ordersItemLayout1);
            orderImage = itemView.findViewById(R.id.ordersProductImage);
            orderName = itemView.findViewById(R.id.ordersProductName);
            orderMoreInfo = itemView.findViewById(R.id.ordersMoreInfoIcon);
            orderCancel = itemView.findViewById(R.id.ordersCancelOrderIcon);
            orderDate = itemView.findViewById(R.id.ordersItemDataPedido);
            orderPrevision = itemView.findViewById(R.id.ordersItemPedidoPrevisao);
            orderPrice = itemView.findViewById(R.id.ordersItemPedidoPreco);
            orderDeliveryType = itemView.findViewById(R.id.ordersItemDeliveryType);
        }

    }
}
