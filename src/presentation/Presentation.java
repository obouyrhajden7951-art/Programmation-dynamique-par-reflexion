package presentation;

import dao.DaoImpl;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation {
    private static MetierImpl metier;

    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metierImpl = new MetierImpl();
        metierImpl.setDao(dao);   // injection statique
        metier = metierImpl;

        System.out.println("Résultat = " + metier.calcul());
    }
}