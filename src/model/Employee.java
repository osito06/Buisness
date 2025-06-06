package model;

import java.time.LocalDateTime;

public class Employee {
    private short id;
    private String firstName;
    private Double salary;
    private Date birthDate;
    private Date hirDate;

    public Date createDate(short day, short month, short year) {
    Date date = new Date();
    date.setDay(day);
    date.setMounth(month);
    date.setYear(year);
    return date;
    }

    public Employee(short id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Employee(short id, String firstName, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.salary = salary;
    }

    public Employee (){
    }

    public Employee(short id, String firstName, Double salary,  Date birthDate, Date hideDate) {
        this.id = id;
        this.firstName = firstName;
        this.salary = salary;
        this.birthDate = birthDate;
        this. hirDate = hideDate;
    }

    /*public Date courrentDate(){
        Date dateFinal = new Date();
        LocalDateTime today = LocalDateTime.now();
        int d = 
        int m = ((birthDate.getMounth() *30) - today.getDayOfMonth())/30;
        int a = 
        dateFinal.setDay(d);
        dateFinal.setMounth(m);
        dateFinal.setYear(a);
        return dateFinal;
    }*/

    private Date getCurrentDate(){
        LocalDateTime today = LocalDateTime.now();
        return new Date((short)today.getDayOfMonth(),(short)today.getDayOfMonth(), (short)today.getYear());
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birtDate) {
        this.birthDate = birtDate;
    }
    public Date getHirDate() {
        return hirDate;
    }
    public void setHirDate(Date hirDate) {
        this.hirDate = hirDate;
    }
    public short getId() {
        return id;
    }
    public void setId(short id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private int distanceBetweenDates(Date d1){
        int  yearx = this.getCurrentDate().getYear() - d1.getYear() ; 
        if (d1.getMonth() < this.getCurrentDate().getMonth() ) {
            yearx = yearx -1;
        }else if(this.getCurrentDate().getMonth() == d1.getMonth() && this.getCurrentDate().getDay() <  d1.getDay()){ 
            yearx = yearx -1;
        }
        return yearx;
        //return ((this.getCurrentDate().getDay() + this.getCurrentDate().getMounth()*30 + this.getCurrentDate().getYear()*365)  -(d1.getDay() + d1.getMounth()*30 + d1.getYear()*365)  )/365 ;
    }

    /*private short distanceBetweenDates(Date date){
 
        // recibe una fecha cualquiera

        short realdate = (short)(this.getCurrentDate().getYear()-date.getYear());

        short num = -1;
        //vairable que guarda el resultado
        short result;

        if(getCurrentDate().getMonth()<date.getMonth()){
            result = (short) (realdate - num);
        }
        else if(getCurrentDate().getMonth()==date.getMonth()){
            if(getCurrentDate().getDay()>date.getDay()){
                result = realdate;
            }
            else{
                result = (short) (realdate - num);
            }
        }
        else{
            result = (short) (realdate - num);;
        }
        return result;

        // y retorna la resta entre estas fechas
        // llamamdo a la fecha de hoy y restandole el año del objeto que pasamos
        // return (short) (this.getCurrentDate().getYear()-date.getYear());
    }*/


    public int getAge(){
        return (int)(this.distanceBetweenDates(birthDate));
    }

    public int getAntigueti(){
        return (int)(this.distanceBetweenDates(hirDate));
    }


    public String toString() {
        // TODO Auto-generated method stub
        return "Id : " + this.id + "   First Name:" + this.firstName + "   Salary : "+ this.salary + "    Nacimiento:  " + this.birthDate + "    Contratacion: "+ this.hirDate + "   su edad es   "; //+ this.distanceBetweenDates(this.getCurrentDate(), birthDate)+"  años";
    }
}
