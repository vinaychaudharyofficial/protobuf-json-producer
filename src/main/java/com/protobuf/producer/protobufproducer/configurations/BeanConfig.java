package com.protobuf.producer.protobufproducer.configurations;

import com.protobuf.producer.protobufproducer.dtoUtils.PDFByteUtil;
import com.protobuf.producer.protobufproducer.emp.CrudRepository;

import com.protobuf.producer.protobufproducer.emp.Employee.Company;
import com.protobuf.producer.protobufproducer.emp.Employee.Emp;
import com.protobuf.producer.protobufproducer.empDTO.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Configuration
public class BeanConfig {

    @Autowired
    PDFByteUtil pdfByteUtil;

    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Arrays.asList(hmc));
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean("CrudRepository")
    public CrudRepository getEmp() throws IOException {

        System.out.println(" Crud Bean getEMP Called Start: "+ LocalDateTime.now());
        Map<Integer, Emp> emps = new HashMap<>();
        for(int i=1;i<=2;i++) {
            List comList = new ArrayList<Company>();
            Company com1;
            for(int j=1;j<=10000;j++) {
                com1 = Company.newBuilder()
                        .setId(j)
                        .setCompanyName("XYZ Company Pvt Ltd ")
                        .setLocation("XYZ Company Pvt Ltd 	Plt No 10, Star Building, Sector-100, Near XYZ Road, XYZ City, India")
                        .setEmail("xyz@xyz.com")
                        //.setDoc(pdfByteUtil.getDocumentByte())
                        //.addAllPhoneNumbers(new ArrayList<Employee.Company.PhoneNumber>())
                        .build();
                comList.add(com1);
            }

            Emp emp1 = Emp.newBuilder()
                    .setId(i)
                    .setEmpName("Vinay Chaudhary")
                    .addAllCompanies(comList)
                    .build();
            emps.put(emp1.getId(), emp1);
        }
        System.out.println(" Crud Bean getEMP Called End: "+ LocalDateTime.now());
        return new CrudRepository(emps);
    }

    @Bean("CrudRepositoryJSON")
    public CrudRepository getEmpDTO() throws IOException {

        System.out.println(" Crud Bean getEMP Called Start: "+ LocalDateTime.now());
        Map<Integer, EmpDto> emps = new HashMap<>();
        for(int i=1;i<=2;i++) {
            List comList = new ArrayList<com.protobuf.producer.protobufproducer.empDTO.Company>();
            com.protobuf.producer.protobufproducer.empDTO.Company com1;
            for(int j=1;j<=10000;j++) {
                com1 = new com.protobuf.producer.protobufproducer.empDTO.Company();
                        com1.setId(j);
                        com1.setCompany_name("XYZ Company Pvt Ltd ");
                        com1.setLocation("XYZ Company Pvt Ltd 	Plt No 10, Star Building, Sector-100, Near XYZ Road, XYZ City, India");
                        com1.setEmail("xyz@xyz.com");

                      // com1.setDoc(pdfByteUtil.getDocumentByte());
                comList.add(com1);
            }

            EmpDto emp1 = new EmpDto();
                    emp1.setId(i);
                    emp1.setEmp_name("Vinay Chaudhary");
                    emp1.setCompanies(comList);

            emps.put(emp1.getId(), emp1);
        }
        System.out.println(" Crud Bean getEMP Called End: "+ LocalDateTime.now());
        return new CrudRepository(emps,null);
    }
}
