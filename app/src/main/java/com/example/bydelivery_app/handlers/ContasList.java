package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ContasList {

    private static  Conta currentAccount = null;

    private static List<Conta> contasList = new ArrayList<>(Arrays.asList(
            new Conta("Hugo Gonçalves", "hugogoncalves13@ua.pt", "123456", "Rua do Sol, nº273",
                    "910 854 625", 0, false),
            new Conta("João Reis", "joaoreis16@ua.pt", "123456", "Avenida das Flores, nº356",
                    "910 542 625",1, true),
            new Conta("José Andrade", "testes@ua.pt", "1234", "Avenida das Flores, nº356",
                    "912 548 625",2, true)
    ));

    public static List<Conta> getAllAccounts(){
        return contasList;
    }

    public static Conta getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(Conta currentAccount) {
        ContasList.currentAccount = currentAccount;
    }
}
