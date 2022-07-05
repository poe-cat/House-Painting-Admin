package com.poecat.housepaintingadmin.repository;

import com.poecat.housepaintingadmin.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Long countById(Integer id);
}