package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static EntityManagerFactory factory = null;

    static {
        init();
    }

    public static void init() {

        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
                System.out.println("Pegouuuu");

            }
        } catch (Exception e) {
            System.out.println("Erroooo");
            e.printStackTrace();

        }

    }

    public static EntityManager getEntityManger() {
        return factory.createEntityManager();
    }

    public static Object getPrimaryKey(Object entity){
        return factory.getPersistenceUnitUtil().getIdentifier(entity);

    }

}
