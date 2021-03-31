package com.kodilla.patterns2.facade.manytomany;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompanyByFirstThreeDigitOfName",
        query = "SELECT * FROM Companies WHERE LEFT(COMPANY_NAME, :LENGTH) = :DIGITS",
        resultClass = Company.class
)

@NamedNativeQuery(
        name = "Company.retrieveCompanyByPartName",
        query = "SELECT * FROM Companies WHERE COMPANY_NAME = :NAME",
        resultClass = Company.class
)


@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    EntityManager em;


    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List <Company > retrieveCompanyByPartName(String name){
        Query query = em.createNamedQuery("Company.retrieveCompanyByPartName");
        List<Company> results = query.getResultList();
        return results;
    }
}

