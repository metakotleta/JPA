package ru.rvukolov.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.rvukolov.jpa.model.Person;
import ru.rvukolov.jpa.model.PersonData;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, PersonData> {
    List<Person> findByCityOfLiving(String cityOfLiving);
    @Query(value = "SELECT * from person p where p.age < ?1 order by p.age", nativeQuery = true)
    List<Person> findByAge(int age);
    Optional<Person> findByPersonData(PersonData personData);
}
