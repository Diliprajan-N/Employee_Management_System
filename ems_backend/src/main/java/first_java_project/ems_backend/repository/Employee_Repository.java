package first_java_project.ems_backend.repository;

import first_java_project.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Employee_Repository extends JpaRepository <Employee,Long> {

}
