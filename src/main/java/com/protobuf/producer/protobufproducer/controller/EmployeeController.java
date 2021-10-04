package com.protobuf.producer.protobufproducer.controller;

import com.protobuf.producer.protobufproducer.emp.CrudRepository;
import com.protobuf.producer.protobufproducer.empDTO.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.protobuf.producer.protobufproducer.emp.Employee.Company;
import com.protobuf.producer.protobufproducer.emp.Employee.Emp;

import java.time.LocalDateTime;

@RestController
public class EmployeeController {

    @Autowired
    @Qualifier(value = "CrudRepository")
    private CrudRepository crudRepository;

    @Autowired
    @Qualifier(value = "CrudRepositoryJSON")
    private CrudRepository crudRepositoryJson;

    @GetMapping(value = "/emp/{id}", produces = "application/x-protobuf")
    public Emp getEmployee(@PathVariable Integer id){
        System.out.println("Hi Emp Test Controller");
        System.out.println(" Controller getEmployee Start: "+ LocalDateTime.now());
        Emp ss = crudRepository.getEmp(id);
        System.out.println(" Controller getEmployee End: "+ LocalDateTime.now());
        return  ss;
    }

	/*
	 * @GetMapping(value = "/empjson/{id}", produces = "application/json") public
	 * Emp getEmployeeJSON(@PathVariable Integer id){
	 * System.out.println("Hi Emp Test Controller");
	 * System.out.println(" Controller getEmployee Start: "+ LocalDateTime.now());
	 * Emp ss = crudRepository.getEmp(id);
	 * System.out.println(" Controller getEmployee End: "+ LocalDateTime.now());
	 * return ss; }
	 */

    @GetMapping(value = "/empdto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpDto getEmployeeDTO(@PathVariable Integer id){
        System.out.println("Hi Emp Test Controller: JSON ");
        System.out.println(" Controller DTO getEmployee Start: JSON "+ LocalDateTime.now());
        EmpDto ss = crudRepositoryJson.getEmpDTO(id);
        System.out.println(" Controller DTO getEmployee End: JSON "+ LocalDateTime.now());
        return  ss;
    }
}
