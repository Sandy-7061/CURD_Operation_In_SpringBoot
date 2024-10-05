package sandeep.curd_operation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sandeep.curd_operation.Entity.Department;
import sandeep.curd_operation.Error.DepartmentNotFoundException;
import sandeep.curd_operation.Repositry.DpeartmentRepositry;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DpeartmentRepositry departmentRepositry;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepositry.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepositry.findAll();
    }

    @Override
    public Department fetchDepartmentListById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepositry.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentListByID(Long id) throws DepartmentNotFoundException {
        Department department = fetchDepartmentListById(id);
        department.setActive(false);  // Soft delete
        departmentRepositry.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department myEntity) {
        Department entity = departmentRepositry.findById(id).get();

        if (Objects.nonNull(myEntity.getDepartmentName()) && !myEntity.getDepartmentName().equals("")) {
            entity.setDepartmentName(myEntity.getDepartmentName());
        }
        if (Objects.nonNull(myEntity.getDepartmentAddress()) && !myEntity.getDepartmentAddress().equals("")) {
            entity.setDepartmentAddress(myEntity.getDepartmentAddress());
        }
        if (Objects.nonNull(myEntity.getDepartmentCode()) && !myEntity.getDepartmentCode().equals("")) {
            entity.setDepartmentCode(myEntity.getDepartmentCode());
        }
        departmentRepositry.save(entity);
        return entity;
    }

    @Override
    public List<Department> searchDepartmentByName(String name) {
        return departmentRepositry.findByDepartmentNameContainingIgnoreCase(name);
    }
}
