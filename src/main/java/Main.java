import Util.HibernateUtil;
import dao.DaoException;
import dao.impl.AddressDaoImpl;
import dao.impl.DepartmentDaoImpl;
import dao.impl.EmployeeDaoImpl;
import model.Address;
import model.Department;
import model.Employee;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws DaoException {
        System.out.println("Hibernate one to one (Annotation)");


        AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
        Address address = new Address();
        address.setCountry("Россия");
        address.setCity("Москва");
        address.setStreet("Первомайская 89");
        address.setPostCode("982342");

        DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
        Department department = new Department();
        department.setTitle("Отдел Кадров");


        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setLastName("Иванович");
        employee.setFirstName("Петросян");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(1992, Calendar.APRIL, 28);
//        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setBirthday(new Date(92, 3, 28));
        employee.setAddress(address);


        Set<Department> departments = new HashSet<>();
        departments.add(department);
        employee.setDepartments(departments);



        employeeDaoImpl.add(employee);
        addressDaoImpl.add(address);
        departmentDaoImpl.add(department);

        for (Employee employeeList : employeeDaoImpl.getAll()) {
            System.out.print("Employee - ");
            System.out.println(employeeList);
            System.out.print("Employee-Department - ");
            System.out.println(employeeList.getDepartments());
            System.out.print("Employee-Address - ");
            System.out.println(employeeList.getAddress());
        }

        for (Department departmentList : departmentDaoImpl.getAll()) {
            System.out.print("Department - ");
            System.out.println(departmentList);
        }

        for (Address address1 : addressDaoImpl.getAll()) {
            System.out.print("Address - ");
            System.out.println(address1);
        }
        HibernateUtil.shutdown();


    }
}
