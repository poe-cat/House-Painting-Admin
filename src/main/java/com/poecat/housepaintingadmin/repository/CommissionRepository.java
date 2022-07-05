package com.poecat.housepaintingadmin.repository;

import com.poecat.housepaintingadmin.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Integer> {

    Long countById(Integer id);

}
