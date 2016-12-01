package org.javadriven.bootcache.cache;

import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheResult;

@Component
public class StockTracker {

    @CacheResult
    public String getPrice(String Symbol) {
        System.out.println("Generating the price...");
        return String.valueOf(20 + (200 - 20) * Math.random());
    }
}
