package pe.edu.i202112261.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202112261.entity.City;
import pe.edu.i202112261.entity.Country;
import pe.edu.i202112261.entity.CountryLanguage;

import java.util.List;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world.DB");
        EntityManager em = emf.createEntityManager();


        Country country = new Country("ZZZ", "Chillond", "Asia", "desierto", 5000.0, 2024, 1000000, 75.0, 20000.0, 18000.0, "Isla", "República", "Juan Pérez", 1, "XY", null, null);

        City city1 = new City(null, "Verita", "Blanco", 800000, country);
        City city2 = new City(null, "Lolita", "Negro", 1200000, country);
        City city3 = new City(null, "Canela", "Rojo", 500000, country);

        CountryLanguage language1 = new CountryLanguage(null, "QUECHUA", true, 80.0, country);
        CountryLanguage language2 = new CountryLanguage(null, "LATIN", true, 20.0, country);

        country.setCities(List.of(city1, city2, city3));
        country.setLanguages(List.of(language1, language2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();


    }
}

