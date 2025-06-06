package model;
import model.Employee;

public class Business {
    private String name = "";
    private String city = "";
    private  Employee [] employeesArray;

    public Business() {
        
        this.employeesArray = new Employee[1];
        employeesArray[0] = null;

    }


    public Employee[] getEmployeesArray() {
        return employeesArray;
    }
    public void setEmployeesArray(Employee[] employeesArray) {
        this.employeesArray = employeesArray;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void inremVectorSize() {
        Employee[] newArray = new Employee[employeesArray.length + 1];
        for (int i = 0; i < employeesArray.length; i++) {
            newArray[i] = employeesArray[i];
        }
        employeesArray = newArray;
    }
    public void decrementSize(int position) {
        
        Employee[] newArray = new Employee[employeesArray.length - 1];
        for (int i = 0; i < employeesArray.length; i++) {
            newArray[i] = employeesArray[i];
        }
        employeesArray = newArray;
    }


    public int serchEmploye(Short id) {
        int position = -1;
        for (int i = 0; i < employeesArray.length-1; i++) {
            if (employeesArray[i] != null) {
                if (employeesArray[i].getId() == id) {
                    position = i;
                }
            }
        }
        return position;
    }

    public int serchEmploye(String name) {
        int position = -1;
        for (int i = 0; i < employeesArray.length-1; i++) {
            if (employeesArray[i] != null) {
                if (employeesArray[i].getFirstName().equals(name)) {
                    position = i;
                }
            }
        }
        return position;
    }

    public void addEmployee(Employee employee) {
        employeesArray[employeesArray.length - 1] = employee;
        this.inremVectorSize();
    }
 
        
    
    
    @Override
    public String toString(){
        return super.toString();
    }

}
