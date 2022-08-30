package com.poecat.housepaintingadmin.service;

import com.poecat.housepaintingadmin.exception.CommissionNotFoundException;
import com.poecat.housepaintingadmin.model.Commission;
import com.poecat.housepaintingadmin.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    public CommissionService() {
    }

    public List<Commission> listAll() {
        return commissionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void save(Commission commission) {
        commissionRepository.save(commission);
    }

    public Commission get(Integer id) throws CommissionNotFoundException {
        Optional<Commission> commission = commissionRepository.findById(id);

        if (commission.isPresent()) {
            return commission.get();
        }
        throw new CommissionNotFoundException("Couldn't find any commission with ID " + id);
    }


    public void delete(Integer id) throws CommissionNotFoundException {
        Long count = commissionRepository.countById(id);
        if(count == null || count == 0) {
            throw new CommissionNotFoundException("Couldn't find any commission with ID " + id);
        }
        commissionRepository.deleteById(id);
    }
}
