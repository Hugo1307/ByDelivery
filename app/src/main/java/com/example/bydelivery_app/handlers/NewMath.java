package com.example.bydelivery_app.handlers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NewMath {

    public enum Tipo{
        CIMA, BAIXO
    }

    public static double round(double value, int places, Tipo tipo){

        BigDecimal bd = BigDecimal.valueOf(value);

        if (places <= 0)
            throw new IllegalArgumentException();

        if (tipo.equals(Tipo.CIMA)) {
            bd = bd.setScale(places, RoundingMode.HALF_UP);
        }else if (tipo.equals(Tipo.BAIXO)) {
            bd = bd.setScale(places, RoundingMode.HALF_DOWN);
        }

        return bd.doubleValue();

    }

    public static double round(double value, int places){

        BigDecimal bd = BigDecimal.valueOf(value);

        if (places <= 0)
            throw new IllegalArgumentException();

        bd = bd.setScale(places, RoundingMode.HALF_UP);

        return bd.doubleValue();

    }

}
