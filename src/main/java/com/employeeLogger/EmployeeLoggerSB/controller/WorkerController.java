package com.employeeLogger.EmployeeLoggerSB.controller;

import com.employeeLogger.EmployeeLoggerSB.entity.Worker;
import com.employeeLogger.EmployeeLoggerSB.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkerController {

    @Autowired
    WorkerRepository workerRepository;

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    @RequestMapping(value = "/findworkerbyid{id}", method = RequestMethod.GET)
    public Optional<Worker> getWorkerByID(@RequestParam Long id){
        return workerRepository.findById(id);
    }

    @RequestMapping(value = "/deleteworkerbyid{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public void deleteWorkerByID(@RequestParam Long id){
        workerRepository.deleteById(id);
    }
}
