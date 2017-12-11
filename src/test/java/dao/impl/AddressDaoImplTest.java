package dao.impl;

import dao.DaoException;
import model.Address;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AddressDaoImplTest {


    @Test
    public void add() {

        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressDaoImpl addressImplDao = new AddressDaoImpl();
        try {
            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void getAll() {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressDaoImpl addressImplDao = new AddressDaoImpl();
        try {
            addressImplDao.add(address);
            List<Address> list = addressImplDao.getAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size() > 0);
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getById() {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressDaoImpl addressImplDao = new AddressDaoImpl();
        try {

            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void update() {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressDaoImpl addressImplDao = new AddressDaoImpl();

        try {
            addressImplDao.add(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getId(), address.getId());
            address.setCity("New City");
            address.setCountry("New Country");
            address.setStreet("new Street");
            address.setPostCode("new Post");
            addressImplDao.update(address);
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCountry(), address.getCountry());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getCity(), address.getCity());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getStreet(), address.getStreet());
            Assert.assertEquals(addressImplDao.getById(address.getId()).getPostCode(), address.getPostCode());
            addressImplDao.remove(address);
        } catch (DaoException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void remove() throws DaoException {
        Address address = new Address(999L, "Test", "Test", "Test", "Test");
        AddressDaoImpl addressImplDao = new AddressDaoImpl();
        addressImplDao.add(address);
        Assert.assertNotNull(addressImplDao.getById(address.getId()).getId());
        addressImplDao.remove(address);
        try {
            Assert.assertNull(addressImplDao.getById(address.getId()).getId());
        } catch (NullPointerException d) {
            d.printStackTrace();
        }

    }
}