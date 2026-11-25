// Création de la classe Presentation2 //
package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new File("config.txt"))) {

            //Chargement de la classe Dao //
            String daoClassName = scanner.nextLine().trim();
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

            //Chargement de la classe Métier //
            String metierClassName = scanner.nextLine().trim();
            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

            // Injection de la DAO dans le Métier par réflexion //
            Method setDao = cMetier.getMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            // Appel de la méthode métier //
            System.out.println("Résultat = " + metier.calcul());
        }
    }
}