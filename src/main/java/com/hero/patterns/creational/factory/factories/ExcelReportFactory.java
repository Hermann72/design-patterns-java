package com.hero.patterns.creational.factory.factories;

import com.hero.patterns.creational.factory.Report;
import com.hero.patterns.creational.factory.ReportFactory;
import com.hero.patterns.creational.factory.reports.ExcelReport;

public class ExcelReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new ExcelReport();
    }
}
