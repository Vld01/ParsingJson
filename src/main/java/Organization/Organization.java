package Organization;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Organization {
    public String name;
    public int inn;
    public long ogrn;
    public Address address;
    public List<Phone> phoneNumbers;
    public List<Securities> securities;
    public LocalDate dateFoundation;
}
