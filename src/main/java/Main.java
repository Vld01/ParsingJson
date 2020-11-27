import Entites.Person;
import Entites.Phones;
import Organization.Organization;
import Organization.Phone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson g = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Person person = g.fromJson(new FileReader("D:\\Загрузки хром\\Учеба Appline\\10. Java 8 от 25.11.2020\\ParsingJson\\src\\main\\resources\\jsonElement.json"), Person.class);

        List<Person> persons = new ArrayList<Person>(Arrays.asList(g.fromJson(new FileReader("D:\\Загрузки хром\\Учеба Appline\\10. Java 8 от 25.11.2020\\ParsingJson\\src\\main\\resources\\personList.json"), Person[].class)));

        //List<Organization> organizations  = new ArrayList<Organization>(Arrays.asList(g.fromJson(new FileReader("D:\\Загрузки хром\\Учеба Appline\\10. Java 8 от 25.11.2020\\ParsingJson\\src\\main\\resources\\organizations.json"), Organization[].class)));
        Organization organization  = g.fromJson(new FileReader("D:\\Загрузки хром\\Учеба Appline\\10. Java 8 от 25.11.2020\\ParsingJson\\src\\main\\resources\\organization.json"), Organization.class);

        System.out.println(organization.name);
        System.out.println(organization.inn);
        System.out.println(organization.ogrn);
        System.out.println(organization.address.city);
        System.out.println(organization.address.postalCode);
        System.out.println(organization.address.state);
        System.out.println(organization.address.streetAddress);
        for (Phone phone: organization.phoneNumbers) {
            System.out.println(phone.type);
            System.out.println(phone.number);
        }
        System.out.println(organization.dateFoundation.getYear());


/*
        for (Organization organization1 : organizations) {
                System.out.print(organization1.name);
            }
*/
    }
}
