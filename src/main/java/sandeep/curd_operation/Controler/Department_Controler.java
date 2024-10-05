package sandeep.curd_operation.Controler;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sandeep.curd_operation.Entity.Department;
import sandeep.curd_operation.Entity.DepartmentDTO;
import sandeep.curd_operation.Error.DepartmentNotFoundException;
import sandeep.curd_operation.Repositry.DpeartmentRepositry;
import sandeep.curd_operation.Service.DepartmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class Department_Controler {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DpeartmentRepositry getderaptment;
    private Logger log = Logger.getLogger(this.getClass().getName());

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        log.info("This is SaveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartment() {
        log.config("This is GetDepartment");
        return getderaptment.findAll();
    }

    @GetMapping("/departments/{id}")
    public Department get_department(@PathVariable Long id) throws DepartmentNotFoundException {
        log.info("This is Get department By id");
        return departmentService.fetchDepartmentListById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String delete_department(@PathVariable Long id) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentListByID(id);
        log.finer("This is Delete Department by id");
        return "Department soft deleted";
    }

    @PutMapping("/departments/{id}")
    public Department update_department(@PathVariable Long id, @RequestBody Department my_entity) {
        log.finest("This is Update Department by id");
        return departmentService.updateDepartment(id, my_entity);
    }

    @GetMapping("/departments/search")
    public List<Department> searchDepartment(@RequestParam String name) {
        log.info("Searching department by name");
        return departmentService.searchDepartmentByName(name);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> Handlvalidation(MethodArgumentNotValidException ex) {
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((errors) -> {
            String fieldname = ((FieldError) errors).getField();
            String error_message = errors.getDefaultMessage();
            error.put(fieldname, error_message);
        });
        return error;
    }
}
