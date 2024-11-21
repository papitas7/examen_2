package pe.edu.i202112261.crud;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202112261.entity.Country;


public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world.DB");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();


    }
}
