package junit_practice.on_collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClassForCollections {

    @Test
    public void checkRemoveDuplicates(){
        List<Integer> data = SampleOnCollections.removeDuplicates(new int[]{1,2,3,4,4,3,2,1,1,2,3,4});
        System.out.print(data);
        System.out.println("\n");
        List<Integer> list = List.of(1,2,3,4);
        System.out.print(list);

        Assert.assertEquals(list, data);
        Assert.assertEquals(list.size(), data.size());
        Assert.assertTrue( data.size() == 4);

    }

    @Test
    public void sumOfElements(){
       int sum  =  SampleOnCollections.sumOfElementInArray(new int[] {2,4,6,8});

       Assert.assertEquals(20, sum);
       Assert.assertTrue(sum==20);

    }

    @Test
    public void testHighestSalaryEmployeeDetails(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Nani", 35000, 25));
        employeeList.add(new Employee(1, "Babu", 45000, 35));
        employeeList.add(new Employee(1, "Pinky", 55000, 18));
        employeeList.add(new Employee(1, "Puppy", 35000, 29));
        employeeList.add(new Employee(1, "Geetha", 15000, 27));

        Employee employee  = employeeList.get(2);
        System.out.println("Highest Salary Employee "+employee.toString());

        Assert.assertEquals(employee, SampleOnCollections.highestSalaryEmployeeDetails(employeeList));
        Assert.assertTrue(SampleOnCollections.highestSalaryEmployeeDetails(employeeList).getSalary() == 55000);


    }
}
