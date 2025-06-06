package controller;
import model.Business;
import model.Employee;
import persitence.MyFile;
import view.IoManager;

public class Control {
    private IoManager io = new IoManager();
    Business businessObj = new Business();
    
    
    public void init() {
        
        int j = this.loadDataFile("c:/temp/datos.csv");
        io.showGraphicMessage("se agregaron " + j + " empleados al sistema");
        businessObj.setName(io.readGraphicString("Nombre de la Empresa"));
        businessObj.setCity(io.readGraphicString("Ciudad de la Empresa"));
        
        this.menu();

        
    }

    public int loadDataFile(String soulsData) {
    MyFile fyle = new MyFile(soulsData);
    int count = 0;
    fyle.open('r');
    String reg;
        while ((reg = fyle.read()) != null){
            String [] data = reg.split(";");
            if(data.length == 5){
                Employee emp = new Employee();
                emp.setId(Short.parseShort(data[0]));
                emp.setFirstName(data[1]);
                emp.setSalary(Double.parseDouble(data[2]));
                String [] date1 = data[3].split("/");
                emp.setBirthDate(emp.createDate(Short.parseShort(date1[0]), Short.parseShort(date1[1]), Short.parseShort(date1[2])));
                String [] date2 = data[4].split("/");
                emp.setHirDate(emp.createDate(Short.parseShort(date2[0]), Short.parseShort(date2[1]), Short.parseShort(date2[2])));
                businessObj.addEmployee(emp);
                count++;
            } else {
                io.showErrorMessage("Error en el formato del archivo de datos");

            }
        }
        fyle.close();
        return count;
    }
    public void menu() {
        int op=0;
        do {
            try{
                op = io.readMenu();
                switch (op) {
                case 1:
                    createEmployees();
                    break; 
                    
                case 2:
                    modifuEmploye();
                    break;

                case 3:
                    delateEmploye();
                    break;

                case 4:
                    showOneEmploye();
                    break;

                case 5:
                    showAllEmploye();
                    break;

                case 6:
                    showDataBuisnes();
                    break;

                case 7:
                    io.showGraphicMessage("Finalización");
                    break;

                    default:
                    io.showErrorMessage("Opción no válida");     
                }
            }catch (NumberFormatException e){
                io.showErrorMessage("Debe ingresar un numero entero");

            }
        
        } while (op != 7);
    }
    
    

    public void createEmployees() {
        io.showGraphicMessage("ingrese los datos del empleado");
        short id = io.readGraphicShort("Codigo");
        try{
            if(businessObj.serchEmploye(id) != -1){
                throw new Exception("El empleado ya existe");
            }else{
                Employee newEm = new Employee();
                newEm.setId(id);
                newEm.setFirstName(io.readGraphicString("ingrese su primer nmbre"));
                newEm.setSalary(io.readGraphicDouble("ingrese su salario"));
                newEm.setBirthDate(newEm.createDate(io.readGraphicShort("ingrese su dia de nacimiento"), io.readGraphicShort("ingrese su mes de nacimiento"), io.readGraphicShort("ingrese su año de nacimiento")));
                newEm.setHirDate(newEm.createDate(io.readGraphicShort("ingrese su dia de ingreso"), io.readGraphicShort("ingrese su mes de ingreso"), io.readGraphicShort("ingrese su año de ingreso")));
                businessObj.addEmployee(newEm);
                io.showGraphicMessage("Empleado creado con éxito");
            }
        } catch (Exception e){
            io.showErrorMessage(e.getMessage());
        }
        
    }

    public void loadEmployees(){

    }
    public void modifuEmploye() {

    }
    
    public void delateEmploye() {
        Short id = io.readGraphicShort("ingrese el id del empleado a eliminar");
        int position = businessObj.serchEmploye(id);
        if (position != -1) {
            businessObj.getEmployeesArray()[position] = null;
            io.showGraphicMessage("Empleado eliminado con éxito");
        } else {
            io.showErrorMessage("Empleado no encontrado");
        }   
    }


    public void showOneEmploye() {
        String id = io.readGraphicString("ingree el nombre del empleado a buscar");
        int position = businessObj.serchEmploye(id);
        if (position != -1) {
            Employee emp = businessObj.getEmployeesArray()[position];
            io.showGraphicMessage("ID: " + emp.getId() + "\nNombre: " + emp.getFirstName() + "\nSalario: " + emp.getSalary() + "\nFecha de nacimiento: " + emp.getBirthDate().toString() + "\nFecha de ingreso: " + emp.getHirDate().toString());
        } else {
            io.showErrorMessage("Empleado no encontrado");
        }

    }
    //metodo que muestre todos los empleados
    public StringBuilder showAllEmploye() {
        StringBuilder sb = new StringBuilder();
        Employee emp [] =  businessObj.getEmployeesArray();
        for(int i = 0 ; i < emp.length-1; i++) {
            if (emp != null) {

                sb.append("ID: ").append(emp[i].getId() );
                sb .append("\nNombre: ").append(emp[i].getFirstName());
                sb.append("\nSalario: ").append(emp[i].getSalary());
                sb.append("\nFecha de nacimiento: ").append(emp[i].getBirthDate().toString());
                sb.append("\nFecha de ingreso: ").append(emp[i].getHirDate().toString());
                sb.append("\n");
            }
        }
        if (sb.length() > 0) {
            io.showGraphicMessage(sb.toString());
        } else {
            io.showErrorMessage("No hay empleados registrados");
        }
        return sb;
    }
    public void showDataBuisnes() {
        io.showGraphicMessage(businessObj.getName() + businessObj.getCity());
    }

}
    