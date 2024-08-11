package com.mohamed.jpa.repositories;

import com.mohamed.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {


    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    @Query("update  Author a set a.age = :age where a.id=:id")
    void updateAuthor(int age, int id);

    // SELECT a FROM Author a WHERE a.firstName=:firstName
    //select * from author where first_name='ali'
    List<Author> findByFirstName(String firstName);

    //SELECT a FROM Author a WHERE UPPER(a.firstName) = UPPER(:firstName)
    //select * from author where first_name='ali'
    List<Author> findByFirstNameIgnoreCase(String firstName);


    //SELECT a FROM Author WHERE  LOWER(a.firstName) like LOWER(:firstName)||'%'
    //select * from author where first_name like "al%"
    List<Author> findByFirstNameStartingWithIgnoreCase(String firstName);



    //SELECT a FROM Author WHERE  LOWER(a.firstName) like '%' || LOWER(:firstName)
    //select * from author where first_name like '%al'
    List<Author> findByFirstNameEndingWithIgnoreCase(String firstName);

    //SELECT a FROM Author WHERE  LOWER(a.firstName) like '%' || LOWER(:firstName) || '%'
    //select * from author where first_name like '%al%'
    List<Author> findByFirstNameContainingIgnoreCase(String firstName);


    //SELECT a FROM Author WHERE  LOWER(a.firstName) IN :firstNames
    //select * from author where first_name in ('Mohamed','Osman','Ibrahim')
    List<Author> findByFirstNameInIgnoreCase(List<String> firstName);






}
