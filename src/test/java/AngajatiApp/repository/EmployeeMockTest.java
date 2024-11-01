package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @Test
    void modifyEmployeeFunction_TC01() {
        Employee marius = employeeMock.getEmployeeList().get(0);
        employeeMock.modifyEmployeeFunction(marius, DidacticFunction.LECTURER);
        assertEquals(DidacticFunction.LECTURER,marius.getFunction());
    }

    @Test
    void modifyEmployeeFunction_TC02() {
        Employee marius = employeeMock.getEmployeeList().get(0);
        employeeMock.modifyEmployeeFunction(null, DidacticFunction.LECTURER);
        assertEquals(DidacticFunction.ASSISTENT,marius.getFunction(),"Employee " + marius.getFirstName() + " " + marius.getLastName() + " should retain their original function.");
    }

    @Test
    void modifyEmployeeFunction_TC03() {
        List<Employee> employeeList = employeeMock.getEmployeeList();
        List<DidacticFunction> originalFunctions = employeeList.stream()
                .map(Employee::getFunction)
                .collect(Collectors.toList());

        employeeMock.modifyEmployeeFunction(null, DidacticFunction.LECTURER);
        for (int i = 0; i < employeeList.size(); i++) {
            assertEquals(originalFunctions.get(i), employeeList.get(i).getFunction(), "Employee " + employeeList.get(i).getFirstName() + " " + employeeList.get(i).getLastName() + " should retain their original function.");
        }
    }

}