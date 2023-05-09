package ru.mrsu.finalqualifyingwork.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.finalqualifyingwork.dto.request.BetweenRequest;
import ru.mrsu.finalqualifyingwork.dto.request.ComputerTypeRequest;
import ru.mrsu.finalqualifyingwork.entity.computers.Computer;
import ru.mrsu.finalqualifyingwork.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    ComputerService service;

    @PostMapping("/save")
    public ResponseEntity<Computer> saveComputer(@Valid @RequestBody Computer computer) {
        return ResponseEntity.ok(service.saveComputer(computer));
    }

    @GetMapping
    public ResponseEntity<List<Computer>> getAllComputers() {
        return ResponseEntity.ok(service.getAllComputers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable String id) {
        return ResponseEntity.ok(service.getComputerById(id));
    }

    @PostMapping("/byType")
    public ResponseEntity<List<Computer>> getComputerByType(@Valid @RequestBody ComputerTypeRequest computerType) {
        return ResponseEntity.ok(service.getComputerByType(computerType));
    }

    @PostMapping("/byRamBetween")
    public ResponseEntity<List<Computer>> getComputerByRamBetween(@Valid @RequestBody BetweenRequest betweenRequest) {
        return ResponseEntity.ok(service.getComputerByRamBetween(betweenRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<Computer> updateComputerById(@Valid @RequestBody Computer computer) {
        Computer updatedComputer = service.updateComputerById(computer);
        return updatedComputer != null
                ? ResponseEntity.ok(computer)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComputerById(@PathVariable String id) {
        service.deleteComputerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
