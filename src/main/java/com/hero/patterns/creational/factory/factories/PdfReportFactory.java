package com.hero.patterns.creational.factory.factories;

import com.hero.patterns.creational.factory.Report;
import com.hero.patterns.creational.factory.ReportFactory;
import com.hero.patterns.creational.factory.reports.PdfReport;

public class PdfReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new PdfReport();
    }
}
