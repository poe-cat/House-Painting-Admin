package com.poecat.housepaintingadmin.service;

import com.poecat.housepaintingadmin.exception.CommissionNotFoundException;
import com.poecat.housepaintingadmin.model.Client;
import com.poecat.housepaintingadmin.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> listAll() {
        return clientRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client get(Integer id) throws CommissionNotFoundException {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            return client.get();
        }
        throw new CommissionNotFoundException("Couldn't find any client with ID " + id);
    }


    public void delete(Integer id) throws CommissionNotFoundException {
        Long count = clientRepository.countById(id);
        if(count == null || count == 0) {
            throw new CommissionNotFoundException("Couldn't find any client with ID " + id);
        }
        clientRepository.deleteById(id);
    }

}