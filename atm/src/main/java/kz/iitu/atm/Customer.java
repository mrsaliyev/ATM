package kz.iitu.atm;

public class Customer {
    private String name;
    private String surname;
    private Account account;

    public Customer(String name, String surname, Account account) {
        this.name = name;
        this.surname = surname;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
