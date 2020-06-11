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
    private static String restauranteSolDescription = "Restaurante popular português a atendê-lo desde 1978";
    private static String sushiSentidoDescription = "Envolva-se numa experiência de sabores e ambientes muito para além do que melhor se faz na cozinha nipónica.";
    private static String itzzaPitzzaDescription = "EAT. DRINK. ENJOY!";
    private static String santocabideDescription = "A melhor roupa ao melhor preço e qualidade";
    private static String pesdesedaDescription = "Conforto em primeiro lugar!";
    private static String santanaDescription = "Cuide bem de si, compre na Farmácia Santana";

    private static List<Parceiro> partnersList = new ArrayList<>(Arrays.asList(
            new Parceiro(R.drawable.burgerclassic_logo, "Burger Classic", burguerClassicDescription, 4.2,
                    "Rua do Sol, Porto", "910 000 000",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 7, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 22, 0).getTime()),
            new Parceiro(R.drawable.restaurantesol_logo, "Restaurante Sol", burguerClassicDescription, 4.2,
                    "Rua Fernão Magalhães, Leiria", "960 100 101",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 7, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 22, 0).getTime()),
            new Parceiro(R.drawable.restaurante_churrasco_logo, "O Churrasco", burguerClassicDescription, 4.2,
                    "Rua Central do Estádio, Porto", "942 148 191",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 7, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 23, 0).getTime()),
            new Parceiro(R.drawable.sushisentido_logo, "Sushi Sentido", sushiSentidoDescription, 4.5,
                    "Av. Dr. Domingos Caetano Sousa, Coimbra", "910 352 235",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 17, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 24, 0).getTime()),
            new Parceiro(R.drawable.itzzapitzza_logo, "Itzza Pitzza", itzzaPitzzaDescription, 3.8,
                    "Rua Doutor João Morais, Algarve", "256 311 287",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 10, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 22, 0).getTime()),
            new Parceiro(R.drawable.santocabide_logo, "Santo Cabide", santocabideDescription, 4.1,
                    "Av. Dr. Cristovão Pinhão, Portalegre", "256 432 564",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 9, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 22, 0).getTime()),
            new Parceiro(R.drawable.pesdeseda_logo, "Pés de seda", pesdesedaDescription, 3.5,
                    "Rua Jesus de Oliveira, Guarda", "912 242 547",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 9, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 20, 0).getTime()),
            new Parceiro(R.drawable.farmaciasantana_logo, "Farmácia Santana", santanaDescription, 4.0,
                    "Rua Martins Oliveira, Vila Real", "913 423 457",
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 7, 0).getTime(),
                    new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH), 24, 0).getTime())
    ));
    public static List<Parceiro> getPartnersList() {
        return partnersList;
    }
}
