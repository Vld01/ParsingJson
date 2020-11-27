import Organization.Organization;
import Organization.Currency;
import Organization.Securities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson g = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        List<Organization> organizations  = new ArrayList<Organization>(Arrays.asList(g.fromJson(new FileReader("D:\\Загрузки хром\\Учеба Appline\\10. Java 8 от 25.11.2020\\ParsingJson\\src\\main\\resources\\organizations.json"), Organization[].class)));

        taskOne(organizations);
        taskTwo(organizations);
        taskThree(organizations);
        taskFour(organizations);
    }

    public static void taskOne(List<Organization> list){
        System.out.println("Task 1:");
        for (Organization orgnz : list) {
            System.out.println(orgnz.getName() + " - Дата основания " + orgnz.getDateFoundation().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        }
    }

    public static void taskTwo(List<Organization> list){
        System.out.println("Task 2:");
        int count = 0;
        for (Organization orgnz : list) {
            for (Securities s : orgnz.getSecurities()) {
                if (s.getDateTime().isBefore(LocalDate.now())) {
                    System.out.println("Просроченая ценная бумага: Код №" +
                                    s.getId() +
                                    ", дата истечения: " +
                                    s.getDateTime() +
                                    ", организация-владелец: " +
                                    orgnz.getName());
                    count++;
                }
            }
        }
        System.out.println("Суммарное число просроченых бумаг " + count);
    }

    public static void taskThree(List<Organization> list) {
        System.out.println("Task 3:");
        System.out.println("Прошу Вас ввести дату в любом из форматов «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»");
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM,yy");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yy");

        String date = "";
        LocalDate localDate = null;
        while (localDate == null){
            try {
                date = reader.readLine();
                localDate = LocalDate.parse(date, formatter1);
            } catch (DateTimeParseException | IOException e) {
                try {
                    localDate = LocalDate.parse(date, formatter2);
                }
                catch (DateTimeParseException e2) {
                    try {
                        localDate = LocalDate.parse(date, formatter3);
                    } catch (DateTimeParseException e3) {
                        try {
                            localDate = LocalDate.parse(date, formatter4);
                        } catch (DateTimeParseException e4) {
                            System.out.println("Введена некорректная дата попробуйте еще.");
                        }
                    }
                }
            }
        }
        System.out.println(localDate.format(formatter4));

        System.out.println("Все огранизации основанные после " + localDate.format(formatter1) +":");
        for (Organization orgnz : list) {
            if (orgnz.getDateFoundation().isAfter(localDate)) {
                System.out.println("Название организации " +
                        orgnz.getName() +
                        ", дата её создания: " +
                        orgnz.getDateFoundation().format(formatter1));
            }
        }
    }

    public static void taskFour(List<Organization> list) {
        System.out.println("Task 4:");
        List<Securities> securities = new ArrayList<Securities>();
        for (Organization org:
             list) {
            securities.addAll(org.getSecurities());
        }

        System.out.println("Прошу Вас ввести код валюты");
        InputStreamReader input2 = new InputStreamReader(System.in);
        BufferedReader reader2 = new BufferedReader(input2);

        String code = "";

        try {
            code = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (code) {
            case "EU":
                for (Securities sec:
                     securities) {
                    for (Currency cur:
                         sec.getCurrency()) {
                        if(cur != null && cur.equals(Currency.EU)) {
                            System.out.println("id ценной бумаги = " +
                                    sec.getId() +
                                    ", код ценной бумаги = " +
                                    sec.getCode());
                        }
                    }
                }
                break;
            case "USD":
                for (Securities sec:
                        securities) {
                    for (Currency cur:
                            sec.getCurrency()) {
                        if(cur != null && cur.equals(Currency.USD)) {
                            System.out.println("id ценной бумаги = " +
                                    sec.getId() +
                                    ", код ценной бумаги = " +
                                    sec.getCode());
                        }
                    }
                }
                break;
            case "RUB":
                for (Securities sec:
                        securities) {
                    for (Currency cur:
                            sec.getCurrency()) {
                        if(cur != null && cur.equals(Currency.RUB)) {
                            System.out.println("id ценной бумаги = " +
                                    sec.getId() +
                                    ", код ценной бумаги = " +
                                    sec.getCode());
                        }
                    }
                }
                break;
            default:
                System.out.println("Введенной валюты не найдено.");
                break;
        }
    }
}
