package com.example.bydelivery_app.handlers;

import com.example.bydelivery_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public abstract class PartnersList {

    private static Calendar currentDate = Calendar.getInstance(TimeZone.getDefault());

    private static String burguerClassicDescription = "Hamburgueria clássica com os melhores sabores desde 1965";

    private static List<Parceiro> partnersList = new ArrayList<>(Arrays.asList(
            new Parceiro(R.drawable.burgerclassic_logo, "Burger Classic", burguerClassicDescription, 4.2,
                    "Rua do Sol", "910 000 000",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 7, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 22, 0).getTime())
    ));

    public static List<Parceiro> getPartnersList() {
        return partnersList;
    }
}
