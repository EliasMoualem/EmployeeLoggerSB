package com.employeeLogger.EmployeeLoggerSB.repository;

import com.employeeLogger.EmployeeLoggerSB.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
