package Organization;

import java.time.LocalDate;
import java.util.List;

public class Organization {
    private String name;
    private int inn;
    private long ogrn;
    private Address address;
    private List<Phone> phoneNumbers;
    private List<Securities> securities;
    private LocalDate dateFoundation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

    public LocalDate getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(LocalDate dateFoundation) {
        this.dateFoundation = dateFoundation;
    }
}
