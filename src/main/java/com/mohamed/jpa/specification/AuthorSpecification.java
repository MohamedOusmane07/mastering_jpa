package com.mohamed.jpa.specification;

import com.mohamed.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;


public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (
              Root<Author> root,
        CriteriaQuery<?> query,
                CriteriaBuilder creteriaBuilder

                )->{

            if(age<0){
                return null;
            }

            return creteriaBuilder.equal(root.get("age"), age);

        };
    }

    public static Specification<Author> firstNameLike (String firstName) {
        return (
                Root<Author> root,
        CriteriaQuery<?> query,
                CriteriaBuilder creteriaBuilder
                )->{
            if(firstName==null){
                return null;
            }
            return creteriaBuilder.like(root.get("firstName"), "%"+firstName+"%");
        };
    }
}
