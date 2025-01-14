package com.example.exchangeratebank.dto;

public class DateRange {

    private String currency;
    private String dateStart;
    private String dateEnd;

    public DateRange(String currency, String dateStart, String dateEnd) {
        this.currency = currency;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public DateRange() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
