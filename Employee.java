import java.util.Date;
import java.util.*;
import java.text.*;


public class Employee {
	 private int id;
	    private String name;
	    private double salary;
	    private String department;
	    private Date joiningDate;

	    public Employee(int id, String name, double salary,
	                    String department, Date joiningDate)
	    {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	        this.department = department;
	        this.joiningDate = joiningDate;
	    }

	    public int getId()
	    {
	        return id;
	    }

	    public String getName()
	    {
	        return name;
	    }

	    public double getSalary()
	    {
	        return salary;
	    }

	    public void setSalary(double salary)
	    {
	        this.salary = salary;
	    }

	    public String getDepartment()
	    {
	        return department;
	    }

	    public Date getJoiningDate()
	    {
	        return joiningDate;
	    }

	    public String toString()
	    {
	        return "ID=" + id +
	                " Name=" + name +
	                " Salary=" + salary +
	                " Department=" + department +
	                " Joining Date=" + joiningDate;
	    }

}




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


public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String msg)
    {
        super(msg);
    }

}




public class EmployeeApplication
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        EmployeeManager manager =
                new EmployeeManager();

        int choice;

        do
        {
            System.out.println("\n1.Add Employee");
            System.out.println("2.Remove Employee");
            System.out.println("3.Search Employee");
            System.out.println("4.Update Salary");
            System.out.println("5.Display All");
            System.out.println("6.Highest Paid");
            System.out.println("7.Group By Department");
            System.out.println("8.Sort By Salary");
            System.out.println("9.Sort By Joining Date");
            System.out.println("10.Count Department Wise");
            System.out.println("11.Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            try
            {
                switch(choice)
                {
                    case 1:

                        System.out.print("ID : ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Name : ");
                        String name = sc.nextLine();

                        System.out.print("Salary : ");
                        double salary = sc.nextDouble();

                        sc.nextLine();

                        System.out.print("Department : ");
                        String dept = sc.nextLine();

                        System.out.print(
                                "Joining Date(dd/MM/yyyy): ");

                        String date =
                                sc.nextLine();

                        Date joiningDate =
                                new SimpleDateFormat(
                                        "dd/MM/yyyy")
                                        .parse(date);

                        Employee emp =
                                new Employee(
                                        id,
                                        name,
                                        salary,
                                        dept,
                                        joiningDate);

                        manager.addEmployee(emp);
                        break;

                    case 2:

                        System.out.print("Enter ID : ");
                        manager.removeEmployee(
                                sc.nextInt());
                        break;

                    case 3:

                        System.out.print("Enter ID : ");
                        System.out.println(
                                manager.searchEmployee(
                                        sc.nextInt()));
                        break;

                    case 4:

                        System.out.print("ID : ");
                        int empId = sc.nextInt();

                        System.out.print(
                                "New Salary : ");

                        double sal =
                                sc.nextDouble();

                        manager.updateSalary(
                                empId,sal);
                        break;

                    case 5:
                        manager.displayAllEmployees();
                        break;

                    case 6:
                        manager.highestPaidEmployee();
                        break;

                    case 7:
                        manager.groupByDepartment();
                        break;

                    case 8:
                        manager.sortBySalary();
                        break;

                    case 9:
                        manager.sortByJoiningDate();
                        break;

                    case 10:
                        manager.countDepartmentWise();
                        break;

                    case 11:
                        System.out.println("Thank You");
                        break;

                    default:
                        System.out.println(
                                "Invalid Choice");
                }
            }
            catch(Exception e)
            {
                System.out.println(
                        e.getMessage());
            }

        }while(choice!=11);
    }
}