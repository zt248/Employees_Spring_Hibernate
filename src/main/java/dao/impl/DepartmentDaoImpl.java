package dao.impl;

import Util.HibernateUtil;
import Util.SessionUtil;
import dao.DaoException;
import dao.DepartmentDAO;
import model.Department;
import org.hibernate.Session;

import java.util.List;

public class DepartmentDaoImpl extends SessionUtil implements DepartmentDAO {
    @Override
    public void add(Department department) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(department);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Department> getAll() throws DaoException {

        openTransactionSession();

//        String sql = "SELECT * FROM Department";
//
//        Session session = getSession();
//        Query query = session.createNativeQuery(sql).addEntity(Department.class);
//        List<Department> DepartmentList = query.getResultList();

        Session session = getSession();
        List<Department>  departmentList = session.createQuery("from Department").list();


        return departmentList;
    }

    @Override
    public Department getById(Long id) throws DaoException {

        openTransactionSession();

        Session session = getSession();
        Department department = session.get(Department.class, new Long(id));


//        String sql = "SELECT * FROM Department WHERE id = :Department_id";
//        Session session = getSession();
//        Query query = session.createNativeQuery(sql).addEntity(Department.class);
//        query.setParameter("Department_id", id);//
//        Department Department = (Department) query.getSingleResult();

        closeTransactionSesstion();

        return department;
    }

    @Override
    public void update(Department department) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(department);

        //close session with a transaction
        closeTransactionSesstion();

    }

    @Override
    public void remove(Department department) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(department);

        //close session with a transaction
        closeTransactionSesstion();

    }

}
