package dk.hrpclausen.consentcoin.model;

public class Person {

    String name;
    String Email;
    int Number;

    public Person(String name, String email, int number) {
        this.name = name;
        Email = email;
        Number = number;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email) {
        this.name = name;
        Email = email;
    }

    public Person(String name, int number) {
        this.name = name;
        Number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
