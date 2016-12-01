package org.javadriven.bootcache;

import org.javadriven.bootcache.cache.StockTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.stream.Stream;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheApplication.class, args);
	}

	@Autowired
	private StockTracker stockTracker;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("The price is...");

		Stream.generate(() -> 1)
				.limit(10)
				.forEach(t -> System.out.println(stockTracker.getPrice("T")));

		System.out.println("Getting price with new method");
		System.out.println(stockTracker.getPriceWithManager("T"));
	}
}
