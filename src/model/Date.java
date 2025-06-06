package model;

public class Date {
    private short day;
    private  short mounth;
    private  short year;
    
    public Date() {
    }
    public Date(short day, short mounth, short year) {
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }
    
    public short getDay() {
        return day;
    }
    public void setDay(short day) {
        this.day = day;
    }
    public short getMonth() {
        return mounth;
    }
    public void setMounth(short mounth) {
        this.mounth = mounth;
    }
    public short getYear() {
        return year;
    }
    public void setYear(short year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return  this.day + "/" + this.mounth + "/" + this.year ;
    }
}
