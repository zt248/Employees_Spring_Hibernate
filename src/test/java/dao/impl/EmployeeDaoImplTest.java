package dao.impl;

import dao.DaoException;
import model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class EmployeeDaoImplTest {

    @Test
    public void add() {
        Employee employee = new Employee(9L, "Test", "Test", new Date(92, 3, 28));
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        try {
            employeeDaoImpl.add(employee);
            Assert.assertEquals(employee.getId(), employeeDaoImpl.getById(employee.getId()).getId());
            Assert.assertEquals(employee.getBirthday(), employeeDaoImpl.getById(employee.getId()).getBirthday());
            Assert.assertEquals(employee.getFirstName(), employeeDaoImpl.getById(employee.getId()).getFirstName());
            Assert.assertEquals(employee.getLastName(), employeeDaoImpl.getById(employee.getId()).getLastName());
            employeeDaoImpl.remove(employee);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getAll() {
        Employee employee = new Employee(9L, "Test", "Test", new Date(92, 3, 28));
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        try {
            employeeDaoImpl.add(employee);
            List<Employee> list = employeeDaoImpl.getAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            employeeDaoImpl.remove(employee);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getById() {
        Employee employee = new Employee(9L, "Test", "Test", new Date(92, 3, 28));
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        try {
            employeeDaoImpl.add(employee);
            Assert.assertEquals(employee.getId(), employeeDaoImpl.getById(employee.getId()).getId());
            Assert.assertEquals(employee.getBirthday(), employeeDaoImpl.getById(employee.getId()).getBirthday());
            Assert.assertEquals(employee.getFirstName(), employeeDaoImpl.getById(employee.getId()).getFirstName());
            Assert.assertEquals(employee.getLastName(), employeeDaoImpl.getById(employee.getId()).getLastName());
            employeeDaoImpl.remove(employee);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void update() {
        Employee employee = new Employee(9L, "Test", "Test", new Date(92, 3, 28));
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        try {
            employeeDaoImpl.add(employee);
            Assert.assertEquals(employee.getId(), employeeDaoImpl.getById(employee.getId()).getId());
            employee.setBirthday(new Date(93, 4, 29));
            employee.setLastName("New");
            employee.setFirstName("New");
            employeeDaoImpl.update(employee);
            Assert.assertEquals(employee.getId(), employeeDaoImpl.getById(employee.getId()).getId());
            Assert.assertEquals(employee.getLastName(), employeeDaoImpl.getById(employee.getId()).getLastName());
            Assert.assertEquals(employee.getFirstName(), employeeDaoImpl.getById(employee.getId()).getFirstName());
            Assert.assertEquals(employee.getBirthday(), employeeDaoImpl.getById(employee.getId()).getBirthday());
            employeeDaoImpl.remove(employee);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void remove() throws DaoException {
        Employee employee = new Employee(9L, "Test", "Test", new Date(92, 3, 28));
        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        employeeDaoImpl.add(employee);
        Assert.assertNotNull(employeeDaoImpl.getById(employee.getId()).getId());
        employeeDaoImpl.remove(employee);
        try {
            Assert.assertNull(employeeDaoImpl.getById(employee.getId()).getId());
        } catch (NullPointerException d) {
            d.printStackTrace();
        }
    }
}