package ru.netologi.stats;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/sum.csv")
    void calculateSum(String statistics, long salesSum) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        long actual = service.calculateSum(statisticsList);
        assertEquals(salesSum, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/averageSum.csv")
    void calculateAverageSum(String statistics, float averageSum) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        float actual = service.calculateAverageSum(statisticsList);
        assertEquals(averageSum, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/maxSales.csv")
    void calculateMaxSalesMonth(String str, String statistics, long maxSalesMonth) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        long actual = service.calculateMaxSales(statisticsList);
        assertEquals(maxSalesMonth, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/minSales.csv")
    void calculateMinSalesMonth(String str, String statistics, long minSalesLong) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        long actual = service.calculateMinSales(statisticsList);
        assertEquals(minSalesLong, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/upAverage.csv")
    void calculateSalesUpAverage(String str, String statistics, long salesUpAverage) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        long actual = service.calculateSalesUpAverage(statisticsList);
        assertEquals(salesUpAverage, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/downAverage.csv")
    void calculateSalesDownAverage(String str, String statistics, long salesDownAverage) {
        StatsService service = new StatsService();
        TransformStrToLong transform = new TransformStrToLong();
        long[] statisticsList = transform.calculate(statistics);
        long actual = service.calculateSalesDownAverage(statisticsList);
        assertEquals(salesDownAverage, actual);
    }

}