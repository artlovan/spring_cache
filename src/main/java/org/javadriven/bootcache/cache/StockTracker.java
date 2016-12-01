package org.javadriven.bootcache.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheResult;

@Component
public class StockTracker {

    @Autowired
    private CacheManager manager;

    public String getPriceWithManager(String sybmol) {
        Cache cache = manager.getCache("price");

        return (String) cache.get(sybmol).getObjectValue();
    }

    @CacheResult(cacheName="price")
    public String getPrice(String Symbol) {
        System.out.println("Generating the price...");
        return String.valueOf(20 + (200 - 20) * Math.random());
    }
}
