package sandeep.curd_operation.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sandeep.curd_operation.Entity.Department;

import java.util.List;

@Repository
public interface DpeartmentRepositry extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentNameContainingIgnoreCase(String name);  // Search by name
}
