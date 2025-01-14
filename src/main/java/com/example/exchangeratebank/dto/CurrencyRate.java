package com.example.exchangeratebank.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRate {
    private String r030;
    private String txt;
    private Double rate;
    private String cc;
    private String exchangeDate;

    public CurrencyRate() {
    }

    public CurrencyRate(String r030, String txt, Double rate, String cc, String exchangeDate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangeDate = exchangeDate;
    }

    public String getR030() {
        return r030;
    }

    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }
}
