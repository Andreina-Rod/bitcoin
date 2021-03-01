package com.winance.bitcoin;

import com.winance.bitcoin.service.BitcoinService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinApplication.class, args);
        BitcoinService task = new BitcoinService();
      // new Timer().scheduleAtFixedRate(task, 0,1);
    }

}
