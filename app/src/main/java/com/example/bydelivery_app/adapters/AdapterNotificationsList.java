package com.example.bydelivery_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.RecyclerValuesStorage;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterNotificationsList extends RecyclerView.Adapter<AdapterNotificationsList.ViewHolder> {

    private ArrayList<Integer> notificationsImages;
    private ArrayList<String> notificationsTitles;
    private ArrayList<String> notificationsBodyStrings;
    private ArrayList<String> notificationsHours;
    private boolean isNewNotification = true;

    private static final String TAG = "AdapterNotificationsLis";
    
    public AdapterNotificationsList(){

        this.notificationsImages = RecyclerValuesStorage.getNotificationsImages();
        this.notificationsTitles = RecyclerValuesStorage.getNotificationsTitles();
        this.notificationsBodyStrings = RecyclerValuesStorage.getNotificationsBodyStrings();
        this.notificationsHours = RecyclerValuesStorage.getNotificationsHours();

    }

    @NonNull
    @Override
    public AdapterNotificationsList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listnotifications, parent, false);
        AdapterNotificationsList.ViewHolder holder = new AdapterNotificationsList.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotificationsList.ViewHolder holder, int position) {

        holder.notificationImage.setImageResource(notificationsImages.get(position));
        holder.notificationTitle.setText(notificationsTitles.get(position));
        holder.notificationBody.setText(notificationsBodyStrings.get(position));
        holder.notificationTime.setText(notificationsHours.get(position));

        if (isNewNotification) {
            holder.newNotificationIndicator.setVisibility(View.VISIBLE);
        }else{
            holder.newNotificationIndicator.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return notificationsTitles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView notificationImage;
        CircleImageView newNotificationIndicator;
        TextView notificationTitle;
        TextView notificationBody;
        TextView notificationTime;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            notificationImage = itemView.findViewById(R.id.notificationsRecyclerImage);
            newNotificationIndicator = itemView.findViewById(R.id.notificationsRecyclerNewIndicator);
            notificationTitle = itemView.findViewById(R.id.notificationsRecyclerTitle);
            notificationBody = itemView.findViewById(R.id.notificationsRecyclerBody);
            notificationTime = itemView.findViewById(R.id.notificationsRecyclerTime);

        }

    }

}
