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