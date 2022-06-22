package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Source;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException{
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cant be null/empty");
        }
        if(phoneNumber.isEmpty() || phoneNumber == null){
            throw new IllegalArgumentException("Phone number cant be null/empty");
        }
        if(phoneNumber.length() < 5){
            throw new IllegalArgumentException("phone number can't be less than 5 characters");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;  
        this.age = toAge(birthDate); 
    }

    public Contact (Contact source){
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cant be null/empty");
        }
        this.name = name;
    }
    
    public void setBirthDte(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Name cant be null/empty");
        }
        if(phoneNumber.length() < 5){
            throw new IllegalArgumentException("phone number can't be less than 5 characters");
        }
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }
    
    public int toAge(String birthDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //age in milliseconds
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);

    }
  
    public String toString(){
        return "Name: " + this.name + "\n" +
        "Phone number: " + this.phoneNumber + "\n" +
        "Birth Date: " + this.birthDate + "\n" +
        "Age: " + this.age + " year old" + "\n\n";
    }
  

}

