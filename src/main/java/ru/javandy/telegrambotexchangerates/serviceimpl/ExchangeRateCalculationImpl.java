package ru.javandy.telegrambotexchangerates.serviceimpl;

import org.springframework.stereotype.Service;
import ru.javandy.telegrambotexchangerates.service.ExchangeRateCalculation;

@Service
public class ExchangeRateCalculationImpl implements ExchangeRateCalculation {
    @Override
    public String calculation(String inputMessage) {
        int sumCalculation;
        int currency;

        if (inputMessage.contains("$")) {
            String[] subStr = inputMessage.split("\\$");
            currency = convertingStringToInt(subStr[0]);
            sumCalculation = currency  * 1000;
        } else {
            String[] subStr = inputMessage.split(" тенге");
            currency = convertingStringToInt(subStr[0]);
            sumCalculation = currency * 1000000;
        }

        return Integer.toString(sumCalculation);
    }


    private int convertingStringToInt(String strCurrency) {
        int currency = 0;
        try {
            currency = Integer.parseInt(strCurrency);

        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }
        return currency;
    }
}
