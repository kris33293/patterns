package com.kodilla.patterns2.facade.manytomany.facade;

import com.kodilla.patterns2.facade.manytomany.Company;
import com.kodilla.patterns2.facade.manytomany.CompanyDao;
import com.kodilla.patterns2.facade.manytomany.Employee;
import com.kodilla.patterns2.facade.manytomany.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeApi.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;



    @Autowired
    public FacadeApi(CompanyDao company, EmployeeDao employee ){
        this.companyDao = company;
        this.employeeDao = employee;
    }


    public List<Company> findCompanyByPartName(String name){
        LOGGER.info("Searching for company which name include: " + name);
        return companyDao.retrieveCompanyByPartName(name);
    }

    public List<Employee> findEmployeeByPartName(String name){
        LOGGER.info("Searching for employee which name include: " + name);
        return  employeeDao.retrieveEmployeeByPartName(name);
    }


    public void addCompany(Company company) {
        companyDao.save(company);
    }

    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }




}

