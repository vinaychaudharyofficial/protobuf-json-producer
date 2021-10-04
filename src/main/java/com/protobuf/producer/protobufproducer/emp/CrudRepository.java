package com.protobuf.producer.protobufproducer.emp;

import com.protobuf.producer.protobufproducer.empDTO.EmpDto;
import com.protobuf.producer.protobufproducer.emp.Employee.Emp;

import java.util.Map;


public class CrudRepository {

    Map<Integer, Emp> empMap;

    Map<Integer, EmpDto> empMapDTO;


    public CrudRepository (Map<Integer, Emp> empMap) {
        this.empMap = empMap;
    }
    public CrudRepository (Map<Integer, EmpDto> empMapDTO, String ss) {
        this.empMapDTO = empMapDTO;
    }

    public Emp getEmp(int id) {
        return empMap.get(id);
    }
    public Map<Integer, Emp> getAllEmp() {
        return empMap;
    }

    public EmpDto getEmpDTO(int id) {
        return empMapDTO.get(id);
    }
    public Map<Integer, EmpDto> getAllEmpDTO() {
        return empMapDTO;
    }

}
