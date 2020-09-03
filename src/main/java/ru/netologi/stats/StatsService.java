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

    public long[] calculateMaxSales(long[] statistics) {
        long maxSales = statistics[0];
        long[] maxMonth = {0};
        long month = 1;
        int index = 0;
        for (long sales : statistics) {
            if (sales == maxSales) {
                index += 1;
            }
            if (sales > maxSales) {
                maxSales = sales;
                maxMonth[0] = month;
                index = 1;
            }
            month += 1;
        }
        if (index != 1) {
            long[] maxList = new long[index];
            month = 1;
            index = 0;
            for (long sales : statistics) {
                if (maxSales == sales) {
                    maxList[index] = month;
                    index += 1;
                }
                month += 1;
            }
            return maxList;
        }
        return maxMonth;
    }

    public long[] calculateMinSales(long[] statistics) {
        long minSales = statistics[0];
        long[] minMonth = {0};
        long month = 1;
        int index = 0;
        for (long sales : statistics) {
            if (sales == minSales) {
                index += 1;
            }
            if (sales < minSales) {
                minSales = sales;
                minMonth[0] = month;
                index = 1;
            }
            month += 1;
        }
        if (index != 1) {
            long[] minList = new long[index];
            month = 1;
            index = 0;
            for (long sales : statistics) {
                if (minSales == sales) {
                    minList[index] = month;
                    index += 1;
                }
                month += 1;
            }
            return minList;
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
