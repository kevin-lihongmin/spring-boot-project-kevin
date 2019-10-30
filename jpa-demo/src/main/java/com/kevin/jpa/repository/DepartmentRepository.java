package com.kevin.jpa.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DepartmentRepository<Department, Long> extends SimpleJpaRepository<Department, Long> {

    public DepartmentRepository(JpaEntityInformation<Department, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public DepartmentRepository(Class<Department> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
