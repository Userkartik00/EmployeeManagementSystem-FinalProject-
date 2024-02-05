package com.demo.FinalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.FinalProject.Model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
