package dao.impl;

import Util.SessionUtil;
import dao.AddressDAO;
import dao.DaoException;
import model.Address;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AddressDaoImpl extends SessionUtil implements AddressDAO {


    @Override
    public void add(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(address);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Address> getAll() throws DaoException {

        openTransactionSession();

//        String sql = "SELECT * FROM address";
//
//        Session session = getSession();
//        Query query = session.createNativeQuery(sql).addEntity(Address.class);
//        List<Address> addressList = query.getResultList();

        Session session = getSession();
        List<Address> addressList = session.createQuery("from Address").list();

        closeTransactionSesstion();

        return addressList;
    }

    @Override
    public Address getById(Long id) throws DaoException {

        openTransactionSession();

        Session session = getSession();
        Address address = session.get(Address.class, new Long(id));


//        String sql = "SELECT * FROM address WHERE id = :address_id";
//        Session session = getSession();
//        Query query = session.createNativeQuery(sql).addEntity(Address.class);
//        query.setParameter("address_id", id);//
//        Address address = (Address) query.getSingleResult();

        closeTransactionSesstion();

        return address;
    }

    @Override
    public void update(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        //close session with a transaction
        closeTransactionSesstion();

    }

    @Override
    public void remove(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        //close session with a transaction
        closeTransactionSesstion();

    }

}
