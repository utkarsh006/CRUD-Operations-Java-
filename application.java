import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Employee{
    private int empNum;
    private String ename;
    private int salary;

    Employee(int empNum, String ename, int salary)
    {
        this.empNum = empNum;
        this.ename = ename;
        this.salary = salary;
    }

    public int getEmpnum(){
        return empNum;
    }

    public String getEname(){
        return ename;
    }
    public int getSalary(){
        return salary;
    }

    public String toString(){
        return empNum + " " + ename + " " + salary;
    }
}

class CRUD{
    public static void main(String[] args){

        //create instance of collections
        List<Employee> c = new ArrayList<Employee>();

        //create instance of scanner class
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        int choice;

        do{
           System.out.println("1. INSERT");
           System.out.println("2. DISPLAY");
           System.out.println("3. SEARCH");
           System.out.println("4. UPDATE");
           System.out.println("5. DELETE");
           System.out.print("Enter your choice : ");
           choice = input.nextInt();

           switch(choice)
           {
                 case 1 : System.out.print("Enter Employee Number : ");
                          int empNum = input.nextInt();

                          System.out.print("Enter Employee Name : ");
                          String ename= input2.nextLine();

                          System.out.print("Enter Employee Salary : ");
                          int salary = input.nextInt();     
                          
                          c.add(new Employee(empNum,ename,salary));
                          break;


                 case 2 : System.out.println("------------------------------------------------"); 
                          Iterator <Employee> it = c.iterator();

                           while(it.hasNext())
                           {
                            Employee e = it.next();
                            System.out.println(e);
                           }

                           System.out.println("------------------------------------------------"); 

                           break;


                 case 3 :  boolean found = false;
                           System.out.println("------------------------------------------------"); 
                           it = c.iterator();

                           System.out.println("Enter Employee number to search : ");
                           empNum = input.nextInt();

                            while(it.hasNext())
                            {
                             Employee e = it.next();
                             if(e.getEmpnum() == empNum)
                             {
                                System.out.println(e);
                                found = true;
                             }
                             
                            }

                            if(!found)
                              System.out.println("RECORD NOT FOUND !!!");

                              System.out.println("------------------------------------------------"); 
 
                            break;


                  case 4 :  found = false;

                            System.out.println("Enter Employee number whose record is to be updated : ");
                            empNum = input.nextInt();
                            System.out.println("------------------------------------------------"); 
                            ListIterator<Employee>l = c.listIterator();
 
 
                             while(l.hasNext())
                             {
                               Employee e = l.next();
                               if(e.getEmpnum() == empNum)
                               {
                                  System.out.println("Enter New Name : ");
                                  ename = input2.nextLine();

                                  System.out.println("Enter New Salary : ");
                                  salary = input.nextInt();

                                  l.set(new Employee(empNum, ename, salary));
                                  found = true;
                               }
                              
                             }
 
                             if(!found){
                                System.out.println("RECORD NOT FOUND !!!");
                             }

                             else{
                                System.out.println("RECORD SUCCESSFULLY UPDATED :)");
                             }
                               
 
                               System.out.println("------------------------------------------------"); 
  
                             break;


                case 5 :  found = false;

                            System.out.println("Enter Employee number whose record is to be deleted : ");
                            empNum = input.nextInt();
                            System.out.println("------------------------------------------------"); 
                            it = c.iterator();
 
 
                             while(it.hasNext())
                             {
                               Employee e = it.next();
                               if(e.getEmpnum() == empNum)
                               {
                                  it.remove();
                                  found = true;
                               }
                              
                             }
 
                             if(!found){
                                System.out.println("RECORD NOT FOUND !!!");
                             }

                             else{
                                System.out.println("RECORD SUCCESSFULLY DELETED :)");
                             }
                               
 
                               System.out.println("------------------------------------------------"); 
  
                             break;

                 default : System.out.println("Wrong choice Entered !!!");

           }
        }while(choice != 0);
    }
}