package ru.netologi.stats;

public class StatsService {
    public long calculateSum(long[] statistics) {
        long sum = 0;
        for (long sales : statistics) {
            sum += sales;
        }
        return sum;
    }

    public float calculateAverageSum(long[] statistics) {
        float sum = 0;
        int quantity = 0;
        for (long sales : statistics) {
            sum += sales;
            quantity += 1;
        }
        return sum / quantity;
    }

    public long calculateMaxSales(long[] statistics) {
        long maxSales = statistics[0];
        long month = 1;
        long maxMonth = 0;
        for (int i = 0; i < statistics.length; i++) {
            if (statistics[i] >= maxSales) {
                maxSales = statistics[i];
                maxMonth = month;
            }
            month++;
        }
        return maxMonth;
    }

    public long calculateMinSales(long[] statistics) {
        long minSales = statistics[0];
        long minMonth = 0;
        long month = 1;
        for (int i = 0; i < statistics.length; i++) {
            if (statistics[i] <= minSales) {
                minSales = statistics[i];
                minMonth = month;
            }
            month++;
        }
        return minMonth;
    }

    public long calculateSalesUpAverage(long[] statistics){
        float average = calculateAverageSum(statistics);
        long quantityMonth = 0;
        for (long sales : statistics){
            if ((float) sales > average ){
                quantityMonth += 1;
            }
        }
        return quantityMonth;
    }

    public long calculateSalesDownAverage(long[] statistics){
        float average = calculateAverageSum(statistics);
        long quantityMonth = 0;
        for (long sales : statistics){
            if (average > (float) sales){
                quantityMonth += 1;
            }
        }
        return quantityMonth;
    }
}
