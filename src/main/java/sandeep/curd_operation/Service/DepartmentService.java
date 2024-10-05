package sandeep.curd_operation.Service;

import sandeep.curd_operation.Entity.Department;
import sandeep.curd_operation.Error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getDepartment();
    Department fetchDepartmentListById(Long id) throws DepartmentNotFoundException;
    void deleteDepartmentListByID(Long id) throws DepartmentNotFoundException;
    Department updateDepartment(Long id, Department myEntity);
    List<Department> searchDepartmentByName(String name);
}
