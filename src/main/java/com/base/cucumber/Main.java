package com.base.cucumber;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // JSON rapor dosyasının yolu
        String jsonReportPath = "target/cucumber-reports/cucumber.json";

        // HTML raporunun çıkış dizini
        String reportOutputPath = "src/test/java/com/base/cucumber/report/custom-report";

        // HTML raporunu oluşturacak konfigürasyon
        Configuration configuration = new Configuration(new File(reportOutputPath), "cucumber-base-test");
        configuration.addClassifications("Platform", "Mac");
        configuration.addClassifications("Browser", "Chrome");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonReportPath);

        // Raporu oluştur
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}