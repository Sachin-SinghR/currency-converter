import java.util.Scanner;
import java.util.HashMap;

public class CurrencyConverter {
    
    public static double getExchangeRate(String sourceCurrency, String targetCurrency) {
        HashMap<String, Double> exchangeRates = new HashMap<>();
        
        exchangeRates.put("USD_TO_EUR", 0.85);
        exchangeRates.put("EUR_TO_USD", 1.18);
        exchangeRates.put("USD_TO_GBP", 0.75);
        exchangeRates.put("GBP_TO_USD", 1.33);
        exchangeRates.put("EUR_TO_GBP", 0.88);
        exchangeRates.put("GBP_TO_EUR", 1.14);
        
        String key = sourceCurrency + "TO" + targetCurrency;
        return exchangeRates.getOrDefault(key, -1.0);
    }

    public static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double exchangeRate = getExchangeRate(sourceCurrency, targetCurrency);
        if (exchangeRate == -1) {
            System.out.println("Exchange rate not available for " + sourceCurrency + " to " + targetCurrency);
            return -1;
        }
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter source currency (USD, EUR, GBP): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (USD, EUR, GBP): ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
        if (convertedAmount != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);
        }
    }
}