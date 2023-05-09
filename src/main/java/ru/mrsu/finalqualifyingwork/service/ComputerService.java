package ru.mrsu.finalqualifyingwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mrsu.finalqualifyingwork.dto.request.BetweenRequest;
import ru.mrsu.finalqualifyingwork.dto.request.ComputerTypeRequest;
import ru.mrsu.finalqualifyingwork.entity.computers.Computer;
import ru.mrsu.finalqualifyingwork.repository.impl.ComputerRepository;

import java.util.List;

@Service
public class ComputerService {

    @Autowired
    ComputerRepository repository;

    public Computer saveComputer(Computer computer) {
        return repository.save(computer);
    }

    public List<Computer> getAllComputers() {
        return repository.findAll();
    }

    public Computer getComputerById(String id) {
        return repository.findById(id);
    }

    public List<Computer> getComputerByType(ComputerTypeRequest computerType) {
        return repository.findComputerByType(computerType.getComputerType());
    }

    public List<Computer> getComputerByRamBetween(BetweenRequest betweenRequest) {
        return repository.findComputerByRamBetween(betweenRequest.getGte(), betweenRequest.getLte());
    }

    public Computer updateComputerById(Computer computer) {
        if (computer.getId() != null) {
            return saveComputer(computer);
        } else return null;
    }

    public void deleteComputerById(String id) {
        repository.deleteById(id);
    }

}
