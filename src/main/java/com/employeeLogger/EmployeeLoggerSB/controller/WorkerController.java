package com.employeeLogger.EmployeeLoggerSB.controller;

import com.employeeLogger.EmployeeLoggerSB.entity.Worker;
import com.employeeLogger.EmployeeLoggerSB.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    WorkerRepository workerRepository;

    @GetMapping
    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    @GetMapping("/findbyid")
    public Optional<Worker> getWorkerByID(@RequestParam Long id){
        return workerRepository.findById(id);
    }
}
