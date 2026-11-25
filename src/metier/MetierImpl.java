// Création de l'implémentation MetierImpl //
package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;

    // Injection de l'instance de IDao:
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData() * 2;
    }
}
