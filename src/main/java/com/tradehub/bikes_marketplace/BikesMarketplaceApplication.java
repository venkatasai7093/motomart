package com.tradehub.bikes_marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BikesMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesMarketplaceApplication.class, args);
	}

}
