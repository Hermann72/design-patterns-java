package com.hero.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class CacheReportProxy implements ReportService {

    // Reference to real object
    private final ReportService realService;

    // Caché — key: reportType + userId, value: report generated
    private final Map<String, String> cache = new HashMap<>();

    public CacheReportProxy(ReportService realService) {
        this.realService = realService;
    }

    @Override
    public String generateReport(String reportType, String userId) {
        String cacheKey = reportType + "_" + userId;

        // Verify cache before calling the actual service
        if (cache.containsKey(cacheKey)) {
            System.out.println("  [PROXY CACHE] Cache hit for: " + cacheKey);
            System.out.println("  [PROXY CACHE] Returning cached result — no DB call needed ✓");
            return cache.get(cacheKey);
        }

        // Cache miss — delegate to real servicio and save the result
        System.out.println("  [PROXY CACHE] Cache miss for: " + cacheKey);
        String result = realService.generateReport(reportType, userId);
        cache.put(cacheKey, result);
        System.out.println("  [PROXY CACHE] Result cached for future requests");
        return result;
    }

    public int getCacheSize() {
        return cache.size();
    }

    public void clearCache() {
        cache.clear();
        System.out.println("  [PROXY CACHE] Cache cleared");
    }
}
