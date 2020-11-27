package Organization;

import java.time.LocalDate;
import java.util.List;

public class Securities {
    private int id;
    private int code;
    private String name;
    private List<Currency> currency;
    private LocalDate dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int cod) {
        this.code = cod;
    }
}
