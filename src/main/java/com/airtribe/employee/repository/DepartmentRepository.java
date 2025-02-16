package com.airtribe.employee.repository;

import com.airtribe.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT SUM(p.budget) FROM Project p WHERE p.department.id = :departmentId")
    Double calculateTotalBudgetByDepartmentId(Long departmentId);
}
