package com.example.bydelivery_app.handlers;

import com.example.bydelivery_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProductsList {

    private static String bifanaDescription = "As nossas Bifanas são preparadas com os melhores ingredientes e de forma completamente artesanal. Tudo para lhe garantir que está a consumir bifanas de grande qualidade.";
    private static String hamburguerDescription = "Os nossos hamburguers artesanais são preparados com um tipo especial de molho, o que os torna tão especiais e saborosos. Para além disso, a nossa carne é 100% certificada e os animais de onde esta provém 100% biologicos. \n Não adicionamos nenhum tipo de corante nem conservante para que possa sentir confiança e tranquilidade enquanto desfruta do nosso hambúrguer.";
    private static String sushiDescription = "Os nossos Chefs preparam o melhor da gastronomia asiática, abrindo portas à cultura japonesa.\nO melhor sushi no melhor restaurante japonês!";
    private static String frangoDescription = "Deguste o nosso frango churrasco. Para os verdadeiros amantes de frango!";
    private static String lasanhaDescription = "A Lasanha da Itzza Pitzza é composta por uma deliciosa massa, recheada com molho à bolonhesa, carne moída e presunto, coberta com molho branco e mussarela.\n Irresistível!";
    private static String pizzaDescription = "A pizza da Itzza Pitzza mergulha nos melhores sabores da gastronomia italiana!";
    private static String casacoDescription = "Casaco quente de gola alta, com pele de carneiro para o Inverno";
    private static String sapatosDescription = "Sapatos confortáveis de tamanho 44 de linhagem";
    private static String calcasDescription = "Calças de ganga azul para mulher\n tamanho 38";
    private static String tshirtDescription = "T-shirt 'Los Pollos Hermanos'\ntamanho M";
    private static String vestidoDescription = "Vestido de verão super confortável";
    private static String sandaliasDescription = "Sandálias para o verão\n tamanho 40";
    private static String niveaDescription = "Quer tenha pele normal, seca, oleosa ou sensível, há um creme essencial para a manter hidratada e cuidada!\n Mantenha a sua pele em equilíbrio!";
    private static String protetorsolarDescription = "Anthelios Airlicium FPS 70 de La Roche-Posay é indicado para pele oleosa ou acneica, sensível ao sol. Possui textura gel-creme, toque limpo, leve e de rápida absorção";
    private static String repelenteDescription = "Previne as picadas de insectos durante 6-8 horas de cada vez";
    private static String meiasDescription = "Meias térmicas para pés frios. Previna as doenças do inverno!";
    private static String preservativosDescription = "Os Durex Love Sex Natural Plus são preservativos concebidos com a tecnologia easy-on. São fáceis de colocar e adaptam-se anatomicamente, tornando a relação sexual cómoda e agradável. Proteja-se!";
    private static String vaselineDescription = "- Reduz o aparecimento de linhas finas e secas.\n- Ajuda a proteger cortes menores.\n- Comedogénico e hipoalergénico.";

    private static List<Comida> comida = new ArrayList<>(Arrays.asList(
            new Comida("Frango Churrasco", "O Churrasco", frangoDescription, R.drawable.frango_banner, 1, 5.60, 3.7, 800, 250),
            new Comida("Bifana", "Restaurante Sol", bifanaDescription, R.drawable.binafa_banner, 1, 7.50, 4.8, 190, 200),
            new Comida("Pizza", "Itzza Pitzza", pizzaDescription, R.drawable.pizza_banner, 1, 7.50, 4.3, 150, 200),
            new Comida("Hambúrguer", "Burguer Classic", hamburguerDescription, R.drawable.hamburguer_banner, 1, 4.99, 4.2, 250, 100),
            new Comida("Sushi", "Sushi Sentido", sushiDescription, R.drawable.sushi_banner, 1, 9.49, 5.0, 300, 250),
            new Comida("Lasanha", "Itzza Pitzza", lasanhaDescription, R.drawable.lasanha_banner, 1, 6.80, 4.0, 200, 150)));

    private static List<Roupa> roupa = new ArrayList<>(Arrays.asList(
            new Roupa("Casaco", "Santo Cabide", casacoDescription, R.drawable.casaco_banner, 1, 15.99, 3.0, 1200,"L"),
            new Roupa("Sapatos", "Pés de Seda", sapatosDescription, R.drawable.sapatos_banner,1, 49.99, 4.3,1500, "44"),
            new Roupa("T-Shirt", "Santo Cabide", tshirtDescription, R.drawable.tshirt_banner, 1, 12.99, 3.7, 1000,"M"),
            new Roupa("Calças", "Santo Cabide", calcasDescription, R.drawable.calcas_banner, 1, 24.99, 4.5, 1000,"38"),
            new Roupa("Sandálias", "Pés de Seda", sandaliasDescription, R.drawable.sandalias_banner,1, 34.99, 4.6,1000, "40"),
            new Roupa("Vestido", "Santo Cabide", vestidoDescription, R.drawable.vestido_banner, 1, 29.99, 4.1, 900,"S")
    ));

    private static List<Farmacia> farmacia = new ArrayList<>(Arrays.asList(
            new Farmacia("Creme hidratante", "Farmácia Santana", niveaDescription, R.drawable.nivea_banner, 1, 10.00, 5.0, 850, 100),
            new Farmacia("Protetor Solar", "Farmácia Santana", protetorsolarDescription, R.drawable.protetorsolar_banner, 1, 14.49, 4.3, 850, 100),
            new Farmacia("Repelente para Insetos", "Farmácia Santana", repelenteDescription, R.drawable.repelente_banner, 1, 17.49, 3.6, 450, 100),
            new Farmacia("Meias Térmicas", "Farmácia Santana", meiasDescription, R.drawable.meias_banner, 1, 19.99, 3.6, 150, 200),
            new Farmacia("Preservativos", "Farmácia Santana", preservativosDescription, R.drawable.preservativos_banner, 1, 7.00, 4.9, 100, 200),
            new Farmacia("Vaseline Original", "Farmácia Santana", vaselineDescription, R.drawable.vaseline_banner, 1, 8.00, 4.2, 350, 250)
            ));

    public static List<Produto> getComida() {
        return new ArrayList<Produto>(comida);
    }

    public static List<Produto> getRoupa() {
        return new ArrayList<Produto>(roupa);
    }

    public static List<Produto> getFarmacia() {
        return new ArrayList<Produto>(farmacia);
    }

    public static List<Produto> getAllProducts(){

        List<Produto> allProducts = new ArrayList<>();
        allProducts.addAll(comida);
        allProducts.addAll(roupa);
        allProducts.addAll(farmacia);

        return allProducts;
    }

    public static List<String> getAllProductsNames(){

        List<String> productNames = new ArrayList<>();
        for (Produto p : comida)
            productNames.add(p.getProductName());

        for (Produto p : roupa)
            productNames.add(p.getProductName());

        for (Produto p : farmacia)
            productNames.add(p.getProductName());

        return productNames;
    }

}
