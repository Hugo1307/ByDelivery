package com.example.bydelivery_app.handlers;

import com.example.bydelivery_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class PartnersList {

    private static String burguerClassicDescription = "Hamburgueria clássica com os melhores sabores desde 1965";

    private static List<Parceiro> partnersList = new ArrayList<>(Arrays.asList(
            new Parceiro(R.drawable.burgerclassic_logo, "Burger Classic", burguerClassicDescription, 4.2,
                    "Rua do Sol", "910 000 000",
                    new GregorianCalendar(0, 0, 1, 7, 0).getTime(),
                    new GregorianCalendar(0, 0, 1, 22, 0).getTime())
    ));

    public static List<Parceiro> getPartnersList() {
        return partnersList;
    }
}
