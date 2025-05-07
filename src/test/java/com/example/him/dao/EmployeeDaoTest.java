package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {
    private static Logger logger = Logger.getLogger(EmployeeDaoTest.class.getName());

    private static EmployeeDao employeeDao;
    @BeforeAll
    static void setUp() throws SQLException {
        employeeDao = new EmployeeDao();
    }

    @AfterEach
    public void cleanUpDatabase(){
        try(Connection connection = DatabaseConnector.getConnection();
            Statement statement = connection.createStatement()){

            statement.execute("SET FOREIGN_KEY_CHECKS = 0"); //disable fk checks
            //clear data in table
            statement.execute("TRUNCATE TABLE employee");
            statement.execute("SET FOREIGN_KEY_CHECKS = 1"); //enable fk check again

        }catch (SQLException e){
            logger.info("SQL EXCEPTION OCCURRED");
        }
    }

    @Test
    void createEmployee() throws SQLException{
        //create employee obj
        Employee employee = new Employee("Doe","Johnson","Accra","0550570368");

        //create employee in db
        employeeDao.createEmployee(employee);

        //employee list
        List<Employee> employeeList = employeeDao.getAllEmployees();

        //assertions
        assertEquals(1,employeeList.size());
        assertEquals("Doe",employeeList.getFirst().getSurname());
    }

    @Test
    void getEmployeeById() throws SQLException {
        //create employee obj
        Employee employee = new Employee("Doe","Johnson","Accra","0550570368");

        //add employee to db
        employeeDao.createEmployee(employee);
        employee = employeeDao.getEmployeeById(1);

        //assertions
        assertNotNull(employee);
        assertEquals(1,employee.getId());
        assertEquals("Doe",employee.getSurname());
    }


    @Test
    void updateEmployee() throws SQLException{
        //create employee obj
        Employee employee = new Employee("Doe","Johnson","Accra","0550570368");

        //add employee to db
        employeeDao.createEmployee(employee);

        employeeDao.updateEmployee(1,"Jane","Jackson","Adenta","0548730194");

        employee = employeeDao.getEmployeeById(1);
        //assertions
        assertNotNull(employee);
        assertEquals("Jane",employee.getSurname());
        assertEquals(1,employee.getId());
    }

    @Test
    void deleteEmployee() throws SQLException{
        //create employee obj
        Employee employee = new Employee("Doe","Johnson","Accra","0550570368");

        //add employee to db
        employeeDao.createEmployee(employee);

        List<Employee> employeeList = employeeDao.getAllEmployees();

        assertEquals(1,employeeList.size());
        //delete employee
        employeeDao.deleteEmployee(1);
        employee = employeeDao.getEmployeeById(1);
        employeeList = employeeDao.getAllEmployees();
        assertNull(employee);
        assertEquals(0,employeeList.size());

    }

    @Test
    void getAllEmployees() throws SQLException{
        //create employee obj
        Employee employee = new Employee("Doe","Johnson","Accra","0550570368");

        //add employee to db
        employeeDao.createEmployee(employee);

        List<Employee> employeeList = employeeDao.getAllEmployees();

        //assertions
        assertEquals(1,employeeList.size());
        assertFalse(employeeList.size()>1);
    }
}