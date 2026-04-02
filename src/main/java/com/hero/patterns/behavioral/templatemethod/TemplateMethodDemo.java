package com.hero.patterns.behavioral.templatemethod;

import com.hero.patterns.behavioral.templatemethod.templates.HRReportTemplate;
import com.hero.patterns.behavioral.templatemethod.templates.SalesReportTemplate;

public class TemplateMethodDemo {

    public static void run() {
        System.out.println("=== Template Method Pattern ===\n");

        // Sales report — overwrite fetchData, formatReport and export (hook)
        System.out.println("-- Generating Sales Report --");
        ReportTemplate salesReport = new SalesReportTemplate();
        salesReport.generateReport("carlos");

        // HR report — overwrite fetchData and formatReport, use export base
        System.out.println("-- Generating HR Report --");
        ReportTemplate hrReport = new HRReportTemplate();
        hrReport.generateReport("maria");

        // To prove that the skeleton never changes
        System.out.println("-- Template Method guarantees --");
        System.out.println("Both reports followed the SAME pipeline:");
        System.out.println("  1. authenticate() — fixed, cannot be overridden");
        System.out.println("  2. fetchData()    — variable, each subclass implements");
        System.out.println("  3. formatReport() — variable, each subclass implements");
        System.out.println("  4. export()       — hook, subclasses can extend optionally");
        System.out.println("generateReport() is final — skeleton is protected ✓");
    }
}