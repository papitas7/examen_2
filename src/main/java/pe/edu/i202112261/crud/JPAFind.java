package pe.edu.i202112261.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202112261.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world.DB");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");
        if (country != null) {
            country.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println(city.getName()));
        } else {
            System.out.println("El país no existe.");
        }

        em.close();
        emf.close();
    }
}
