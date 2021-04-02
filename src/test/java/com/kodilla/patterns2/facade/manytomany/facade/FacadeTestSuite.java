package com.kodilla.patterns2.facade.manytomany.facade;

import com.kodilla.patterns2.facade.manytomany.Company;
import com.kodilla.patterns2.facade.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FacadeTestSuite{

    @Autowired
    FacadeApi facadeApi;

    @Test
    void findCompanyByPartName(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        List<Company> result = new LinkedList<>();
        result.add(softwareMachine);

        facadeApi.addEmployee(johnSmith);
        facadeApi.addEmployee(stephanieClarckson);
        facadeApi.addEmployee(lindaKovalsky);

        facadeApi.addCompany(softwareMachine);
        facadeApi.addCompany(dataMaesters);
        facadeApi.addCompany(greyMatter);

        //When
        List<Company> result2 = facadeApi.findCompanyByPartName("oftw");

        //Then
        Assertions.assertEquals(result.get(0).getName(),result2.get(0).getName());
    }

    @Test
    void findEmployeeByPartName(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        List<Employee> result = new LinkedList<>();
        result.add(johnSmith);

        facadeApi.addEmployee(johnSmith);
        facadeApi.addEmployee(stephanieClarckson);
        facadeApi.addEmployee(lindaKovalsky);

        facadeApi.addCompany(softwareMachine);
        facadeApi.addCompany(dataMaesters);
        facadeApi.addCompany(greyMatter);

        //When
        List<Employee> result2 = facadeApi.findEmployeeByPartName("mit");

        //Then
        Assertions.assertEquals(result.get(0).getLastname(),result2.get(0).getLastname());
    }


}

