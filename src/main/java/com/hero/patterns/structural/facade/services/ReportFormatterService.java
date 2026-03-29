package com.hero.patterns.structural.facade.services;

import java.time.LocalDate;
import java.util.List;

public class ReportFormatterService {

    public String format(String title, String author, List<String> data) {
        System.out.println("  [FORMATTER] Formatting report: " + title);
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("Report: ").append(title).append("\n");
        sb.append("Author: ").append(author).append("\n");
        sb.append("Date: ").append(LocalDate.now()).append("\n");
        sb.append("------------------------------------------\n");
        data.forEach(item -> sb.append("  • ").append(item).append("\n"));
        sb.append("==========================================");
        return sb.toString();
    }
}
