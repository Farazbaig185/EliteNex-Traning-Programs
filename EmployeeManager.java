import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeManager
{
    private ArrayList<Employee> employees =
            new ArrayList<Employee>();

    public void addEmployee(Employee emp)
    {
        employees.add(emp);
        System.out.println("Employee Added");
    }

    public void removeEmployee(int id)
            throws EmployeeNotFoundException
    {
        boolean found = false;

        for(int i=0;i<employees.size();i++)
        {
            if(employees.get(i).getId()==id)
            {
                employees.remove(i);
                found = true;
                System.out.println("Employee Removed");
                break;
            }
        }

        if(!found)
        {
            throw new EmployeeNotFoundException(
                    "Employee ID Not Found");
        }
    }

    public Employee searchEmployee(int id)
            throws EmployeeNotFoundException
    {
        for(Employee e : employees)
        {
            if(e.getId()==id)
            {
                return e;
            }
        }

        throw new EmployeeNotFoundException(
                "Employee ID Not Found");
    }

    public void updateSalary(int id,double salary)
            throws EmployeeNotFoundException
    {
        Employee e = searchEmployee(id);
        e.setSalary(salary);

        System.out.println("Salary Updated");
    }

    public void displayAllEmployees()
    {
        if(employees.isEmpty())
        {
            System.out.println("No Employees");
            return;
        }

        for(Employee e : employees)
        {
            System.out.println(e);
        }
    }

    public void highestPaidEmployee()
    {
        if(employees.isEmpty())
        {
            System.out.println("No Employees");
            return;
        }

        Employee highest = employees.get(0);

        for(Employee e : employees)
        {
            if(e.getSalary() > highest.getSalary())
            {
                highest = e;
            }
        }

        System.out.println("Highest Paid Employee");
        System.out.println(highest);
    }

    public void groupByDepartment()
    {
        for(Employee e : employees)
        {
            System.out.println(
                    e.getDepartment() +
                    " --> " +
                    e.getName());
        }
    }

    public void countDepartmentWise()
    {
        HashMap<String,Integer> map =
                new HashMap<String,Integer>();

        for(Employee e : employees)
        {
            String dept = e.getDepartment();

            if(map.containsKey(dept))
            {
                map.put(dept,map.get(dept)+1);
            }
            else
            {
                map.put(dept,1);
            }
        }

        System.out.println(map);
    }

    public void sortBySalary()
    {
        Collections.sort(employees,
                new Comparator<Employee>()
                {
                    public int compare(Employee e1,
                                       Employee e2)
                    {
                        if(e1.getSalary() >
                                e2.getSalary())
                            return 1;
                        else if(e1.getSalary() <
                                e2.getSalary())
                            return -1;
                        else
                            return 0;
                    }
                });

        displayAllEmployees();
    }

    public void sortByJoiningDate()
    {
        Collections.sort(employees,
                new Comparator<Employee>()
                {
                    public int compare(Employee e1,
                                       Employee e2)
                    {
                        return e1.getJoiningDate().
                                compareTo(
                                        e2.getJoiningDate());
                    }
                });

        displayAllEmployees();
    }
}
