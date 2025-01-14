package com.example.exchangeratebank.service;

import com.example.exchangeratebank.dto.CurrencyRate;
import com.example.exchangeratebank.dto.DateRange;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeRateService {

    public CurrencyRate[] getCurrencyRateNow(String currency) {
        System.out.println(currency);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + currency.toUpperCase() + "&json";

        CurrencyRate[] response = restTemplate.getForEntity(url, CurrencyRate[].class).getBody();
        System.out.println(response.length);

        if (response.length == 0) {
            return null;
        }

        return response;
    }

    public List<CurrencyRate> getCurrencyRateByPeriod(DateRange dateRange) {
        RestTemplate restTemplate = new RestTemplate();
        List<CurrencyRate> currencyRateList = new ArrayList<>();

        LocalDate startDate = fromStringToDate(dateRange.getDateStart());
        LocalDate endDate = fromStringToDate(dateRange.getDateEnd());

        if (startDate.isAfter(endDate)) {
            return null;
        }

        while (!startDate.isAfter(endDate)) {
            String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + dateRange.getCurrency().toUpperCase() + "&date=" + startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "&json";

            CurrencyRate[] response = restTemplate.getForEntity(url, CurrencyRate[].class).getBody();
            if (response.length > 0) {
                currencyRateList.add(response[0]);
            }
            startDate = startDate.plusDays(1);
        }

        return currencyRateList;
    }

    private LocalDate fromStringToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    }
}
