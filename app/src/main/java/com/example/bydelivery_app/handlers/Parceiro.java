package com.example.bydelivery_app.handlers;

import java.util.Calendar;
import java.util.Date;

public class Parceiro implements Comparable<Parceiro> {

    private static int id = 0;
    private int partnerId;
    private int partnerImage;
    private String partnerName;
    private String partnerDescription;
    private Double partnerRating;
    private String partnerLocation;
    private String partnerContact;
    private Date partnerOpenSchedule;
    private Date partnerCloseSchedule;

    public Parceiro(int partnerImage, String partnerName, String partnerDescription, Double partnerRating, String partnerLocation, String partnerContact, Date partnerOpenSchedule, Date partnerCloseSchedule) {
        id++;
        this.partnerId = id;
        this.partnerImage = partnerImage;
        this.partnerName = partnerName;
        this.partnerDescription = partnerDescription;
        this.partnerRating = partnerRating;
        this.partnerLocation = partnerLocation;
        this.partnerContact = partnerContact;
        this.partnerOpenSchedule = partnerOpenSchedule;
        this.partnerCloseSchedule = partnerCloseSchedule;
    }

    public boolean isPartnerStoreOpen(){

        Date currentDate = Calendar.getInstance().getTime();

        return currentDate.after(partnerOpenSchedule) && currentDate.before(partnerCloseSchedule);
    }

    public int getPartnerId() {
        return partnerId;
    }

    public int getPartnerImage() {
        return partnerImage;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getPartnerDescription() {
        return partnerDescription;
    }

    public double getPartnerRating() {

        double ratingCount = 0;
        double totalRatings = 0;

        for (Produto p : ProductsList.getAllProducts()) {
            if (p.getProductSeller().equalsIgnoreCase(partnerName)) {
                totalRatings += p.getProductRating();
                ratingCount++;
            }
        }

        if (ratingCount != 0) {
            return NewMath.round((totalRatings / ratingCount), 1);
        }else{
            return 0;
        }



    }

    public String getPartnerLocation() {
        return partnerLocation;
    }

    public String getPartnerContact() {
        return partnerContact;
    }

    public Date getPartnerOpenSchedule() {
        return partnerOpenSchedule;
    }

    public Date getPartnerCloseSchedule() {
        return partnerCloseSchedule;
    }

    public void setPartnerRating(Double partnerRating) {
        this.partnerRating = partnerRating;
    }

    @Override
    public int compareTo(Parceiro o) {
        return this.partnerName.compareTo(o.getPartnerName());
    }
}
