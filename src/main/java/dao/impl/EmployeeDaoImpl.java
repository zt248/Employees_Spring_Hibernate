package dao.impl;

import Util.SessionUtil;
import dao.DaoException;
import dao.EmployeeDAO;
import model.Employee;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDaoImpl extends SessionUtil implements EmployeeDAO {


    @Override
    public void add(Employee employee) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
//        session.saveOrUpdate(employee);
        session.save(employee);

        //close session with a transaction
        closeTransactionSesstion();

    }

    @Override
    public List<Employee> getAll() throws DaoException {
        openTransactionSession();

        Session session = getSession();
        List<Employee> employeeList = session.createQuery("from Employee ").list();


        return employeeList;
    }

    @Override
    public Employee getById(Long id) throws DaoException {

        openTransactionSession();

        Session session = getSession();
        Employee employee = session.get(Employee.class, new Long(id));


//        String sql = "SELECT * FROM employee WHERE id = :employee_id";
//        Session session = getSession();
//        Query query = session.createNativeQuery(sql).addEntity(employee.class);
//        query.setParameter("employee_id", id);//
//        employee employee = (employee) query.getSingleResult();

        closeTransactionSesstion();

        return employee;
    }

    @Override
    public void update(Employee employee) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        //close session with a transaction
        closeTransactionSesstion();

    }

    @Override
    public void remove(Employee employee) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        //close session with a transaction
        closeTransactionSesstion();

    }
}
