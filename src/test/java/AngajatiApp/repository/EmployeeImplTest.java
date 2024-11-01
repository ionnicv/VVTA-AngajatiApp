package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.controller.EmployeeController;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeImplTest {
    Employee employee;
    EmployeeController eCtrl;
    EmployeeRepositoryInterface repo;

    @BeforeEach
    void setUp() {
        repo = new EmployeeMock();
        eCtrl = new EmployeeController(repo);
        employee = new Employee();

        employee.setFirstName("Pacuraru");
        employee.setLastName("Marius");
        employee.setCnp("1234567890876");
        employee.setFunction(DidacticFunction.valueOf("ASSISTENT"));
        employee.setSalary(2000.0);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee_TC1() {
        employee.setSalary(1.0);
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal-1, "Dimensiunea listei nu a crescut");
        }
        catch (Exception er) {
            fail("Test esuat cu eroarea "+ er.getMessage());
        }
    }

    @Test
    void addEmployee_TC2() {
        employee.setSalary(0.0);
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal, "Dimensiunea listei a crescut");
        }
        catch (Exception er) {
            fail("Test esuat cu eroarea "+ er.getMessage());
        }
    }
    @Test
    void addEmployee_TC3() {
        employee.setSalary(-1.0);
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal, "Dimensiunea listei a crescut");
        } catch (Exception er) {
            fail("Test esuat cu eroarea " + er.getMessage());
        }
    }
    @Test
    void addEmployee_TC4() {
        // Trebuie setat salariul iar la o valoare corecta
        employee.setSalary(2000.0);

        employee.setFirstName("Pac");
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal-1, "Dimensiunea listei nu a crescut");
        }
        catch (Exception er) {
            fail("Test esuat cu eroarea "+ er.getMessage());
        }
    }
    @Test
    void addEmployee_TC5() {
        employee.setFirstName("Pa");
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal, "Dimensiunea listei a crescut");
        }
        catch (Exception er) {
            fail("Test esuat cu eroarea "+ er.getMessage());
        }
    }
    @Test
    void addEmployee_TC6() {
        employee.setFirstName("P");
        try {
            int nrInit = eCtrl.getEmployeesList().size();
            eCtrl.addEmployee(employee);
            int nrFinal = eCtrl.getEmployeesList().size();
            assertEquals(nrInit, nrFinal, "Dimensiunea listei a crescut");
        }
        catch (Exception er) {
            fail("Test esuat cu eroarea "+ er.getMessage());
        }
    }
}