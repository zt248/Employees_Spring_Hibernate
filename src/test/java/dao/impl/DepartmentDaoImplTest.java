package dao.impl;

import dao.DaoException;
import model.Department;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDaoImplTest {

    @Test
    public void add() {

        Department department = new Department(9L, "Test");
        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        try {
            departmentDaoImpl.add(department);
            Assert.assertEquals(department.getId(), departmentDaoImpl.getById(department.getId()).getId());
            Assert.assertEquals(department.getTitle(), departmentDaoImpl.getById(department.getId()).getTitle());
            departmentDaoImpl.remove(department);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getAll() {

        Department department = new Department(9L, "Test");
        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        try {
            departmentDaoImpl.add(department);
            List<Department> list = departmentDaoImpl.getAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            departmentDaoImpl.remove(department);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getById() {

        Department department = new Department(9L, "Test");
        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        try {
            departmentDaoImpl.add(department);
            Assert.assertEquals(department.getId(), departmentDaoImpl.getById(department.getId()).getId());
            Assert.assertEquals(department.getTitle(), departmentDaoImpl.getById(department.getId()).getTitle());
            departmentDaoImpl.remove(department);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void update() {
        Department department = new Department(9L, "Test");
        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        try {
            departmentDaoImpl.add(department);
            Assert.assertEquals(department.getId(), departmentDaoImpl.getById(department.getId()).getId());
            department.setTitle("New Test");
            departmentDaoImpl.update(department);
            Assert.assertEquals(department.getId(), departmentDaoImpl.getById(department.getId()).getId());
            Assert.assertEquals(department.getTitle(), departmentDaoImpl.getById(department.getId()).getTitle());
            departmentDaoImpl.remove(department);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void remove() throws DaoException {

        Department department = new Department(9L, "Test");
        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        departmentDaoImpl.add(department);
        Assert.assertNotNull(departmentDaoImpl.getById(department.getId()).getId());
        departmentDaoImpl.remove(department);
        try {
            Assert.assertNull(departmentDaoImpl.getById(department.getId()).getId());
        } catch (NullPointerException d) {
            d.printStackTrace();
        }
    }
}
