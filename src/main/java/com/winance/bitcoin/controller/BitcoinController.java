package com.winance.bitcoin.controller;

import com.winance.bitcoin.model.Bitcoin;
import com.winance.bitcoin.repository.BitcoinRepository;
import com.winance.bitcoin.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/v1/bitcoins")
public class BitcoinController {

    @Autowired
    BitcoinRepository repository;

    @Autowired
    BitcoinService service;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @GetMapping("/by-timestamp")
    public Bitcoin getByTimestamp(@RequestParam(value = "date")
                                  @DateTimeFormat(pattern = DATE_FORMAT) Date date) {
        return service.findByModifiedDate(date);
    }

    @GetMapping("/average-between-timestamps")
    public Double getBetweenTimestamp(@RequestParam(value = "date1")
                                      @DateTimeFormat(pattern = DATE_FORMAT) Date date1,
                                      @RequestParam(value = "date2")
                                      @DateTimeFormat(pattern = DATE_FORMAT) Date date2) {
        return service.getAverage(date1, date2);
    }

}
