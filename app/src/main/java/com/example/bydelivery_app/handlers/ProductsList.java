package com.example.bydelivery_app.handlers;

import com.example.bydelivery_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProductsList {

    private static String bifanaDescription = "As nossas Bifanas são preparadas com os melhores ingredientes e de forma completamente artesanal. Tudo para lhe garantir que está a consumir bifanas de grande qualidade.";
    private static String hamburguerDescription = "Os nossos hamburguers artesanais são preparados com um tipo especial de molho, o que os torna tão especiais e saborosos. Para além disso, a nossa carne é 100% certificada e os animais de onde esta provém 100% biologicos. \n Não adicionamos nenhum tipo de corante nem conservante para que possa sentir confiança e tranquilidade enquanto desfruta do nosso hambúrguer.";

    private static List<Produto> comida = new ArrayList<>(Arrays.asList(
            new Produto("Bifana", "Restaurante do Sol", bifanaDescription, R.drawable.binafa_banner, 1, 7.50, 4.8, 190, 200),
            new Produto("Hambúrguer", "Burguer Classic", hamburguerDescription, R.drawable.hamburguer_banner, 1, 4.99, 4.2, 250, 100)));

    public static List<Produto> getComida() {
        return comida;
    }

    public static void setComida(List<Produto> comida) {
        ProductsList.comida = comida;
    }

    public static List<Produto> getAllProducts(){
        return new ArrayList<>(comida);
    }

    public static List<String> getAllProductsNames(){
        List<String> productNames = new ArrayList<>();

        for (Produto p : comida) {
            productNames.add(p.getProductName());
        }

        return productNames;
    }

}
