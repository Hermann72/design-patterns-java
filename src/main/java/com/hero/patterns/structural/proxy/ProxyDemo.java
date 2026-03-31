package com.hero.patterns.structural.proxy;

public class ProxyDemo {

    public static void run() {
        System.out.println("=== Proxy Pattern (Cache Proxy) ===\n");

        // The client receives ReportService — it does not know if is real or proxy
        ReportService service = new CacheReportProxy(new RealReportService());

        // First request — cache miss, call to real service
        System.out.println("-- Request 1: SALES report for carlos (first time) --");
        long start = System.currentTimeMillis();
        String report1 = service.generateReport("SALES", "carlos");
        long time1 = System.currentTimeMillis() - start;
        System.out.println("Time: " + time1 + "ms\n");

        // Second request — same parameters, cache hit
        System.out.println("-- Request 2: SALES report for carlos (second time) --");
        start = System.currentTimeMillis();
        String report2 = service.generateReport("SALES", "carlos");
        long time2 = System.currentTimeMillis() - start;
        System.out.println("Time: " + time2 + "ms\n");

        // Third request — different user, cache miss
        System.out.println("-- Request 3: SALES report for maria (different user) --");
        start = System.currentTimeMillis();
        String report3 = service.generateReport("SALES", "maria");
        long time3 = System.currentTimeMillis() - start;
        System.out.println("Time: " + time3 + "ms\n");

        // Demonstrate idéntical results
        System.out.println("-- Cache correctness verification --");
        System.out.println("report1 equals report2: " + report1.equals(report2) + " ✓");
        System.out.println("Cache size: " + ((CacheReportProxy) service).getCacheSize());

        // Demonstrate time difference
        System.out.println("\n-- Performance comparison --");
        System.out.println("Request 1 (real call): " + time1 + "ms");
        System.out.println("Request 2 (cached):    " + time2 + "ms");
        System.out.println("Time saved: ~" + (time1 - time2) + "ms ✓");

        // Clear cache
        System.out.println("\n-- Clearing cache --");
        ((CacheReportProxy) service).clearCache();
        System.out.println("Cache size after clear: " +
                ((CacheReportProxy) service).getCacheSize());
    }
}