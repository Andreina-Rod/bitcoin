package com.winance.bitcoin.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.winance.bitcoin.dto.BitcoinDTO;
import com.winance.bitcoin.model.Bitcoin;
import com.winance.bitcoin.repository.BitcoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

@Service
@Slf4j
@EnableScheduling
public class BitcoinService {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String LAST_PRICE_URL = "https://cex.io/api/last_price/BTC/USD";

    @Autowired
    BitcoinRepository repository;

    public Double getAverage(Date date1, Date date2){
        Collection<Bitcoin> bitcoins = repository.findAllByModifiedDateBetween(date1,date2);
        return bitcoins.stream().mapToDouble(Bitcoin::getLprice).average().orElse(Double.NaN);
    }

    public Bitcoin findByModifiedDate(Date modifiedDate){
        return repository.findByModifiedDate(modifiedDate);
    }

    @Scheduled(fixedRate = 10000)
    public void launch() {
        getAndSaveBitcoin();
    }

    private void getAndSaveBitcoin() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Bitcoin> entity = new HttpEntity("", headers);
        Gson gson = new Gson();
        Type type = new TypeToken<BitcoinDTO>() {
        }.getType();

        log.info("Call to: [" + LAST_PRICE_URL + "]");
        ResponseEntity<String> rsp = restTemplate.exchange(LAST_PRICE_URL, HttpMethod.GET, entity, String.class);
        BitcoinDTO dto = gson.fromJson(rsp.getBody(), type);
        if (dto != null) {
            Bitcoin bitcoin = new Bitcoin(null, dto.getLprice(), dto.getCurr1(), dto.getCurr2(), new Date());
            repository.save(bitcoin);
        }

    }

}
