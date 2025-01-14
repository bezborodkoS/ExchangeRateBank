package com.example.exchangeratebank;

import com.example.exchangeratebank.dto.CurrencyRate;
import com.example.exchangeratebank.dto.DateRange;
import com.example.exchangeratebank.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/to")
    public String get() {
        System.out.println("come");
        return "HIIIIIIIIII";
    }

    @GetMapping("/{currency}")
    public ResponseEntity<CurrencyRate[]> getTodayRate(@PathVariable String currency) {
        if (exchangeRateService.getCurrencyRateNow(currency) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(exchangeRateService.getCurrencyRateNow(currency));
    }

    @PostMapping("/range")
    public ResponseEntity<List<CurrencyRate>> getRatesInRange(@RequestBody DateRange dateRange) {
        if (exchangeRateService.getCurrencyRateByPeriod(dateRange) == null) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok(exchangeRateService.getCurrencyRateByPeriod(dateRange));
    }

}
