package com.example.springdata.repository;

import com.example.springdata.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
Bu interface PagingAndSortingRepository-dən də extend ola bilərdi. bu sayedə biz hər hansısa
bir 10000 row-u olan tabledən məsələn sadecə 100 row gətirə bilərdik.Yəni paging edə bilərik.
*/
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    // Burdakı method adları standard adlardır.Yəni ada uyğun spring-data database-lə əlaqəli işi görür


    List<Employee> findByName(String name);

    List<Employee> findByNameAndSurname(String name, String surname);


    // Bu halda native sql yazmış oluruq
    //@Query(value = "select * from Employee e where e.age > ?1 and e.salary>?2 ",nativeQuery = true)
    @Query("select e from Employee e where e.age > ?1 and e.salary>?2 ")
    List<Employee> find(int age, double salary);


    @Modifying(clearAutomatically = true) // update, insert, delete methodu olanada bu annotation lazımdır
    @Query("update Employee e set e.salary = e.salary*2 where e.name = :name")
    void updateEmpByName(@Param("name") String name);

}
