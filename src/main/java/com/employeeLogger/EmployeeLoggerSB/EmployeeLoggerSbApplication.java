package com.employeeLogger.EmployeeLoggerSB;

import com.employeeLogger.EmployeeLoggerSB.rfid.RFID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeLoggerSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLoggerSbApplication.class, args);
		RFID.comPortConnection();
	}
}
