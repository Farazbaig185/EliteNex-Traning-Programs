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



