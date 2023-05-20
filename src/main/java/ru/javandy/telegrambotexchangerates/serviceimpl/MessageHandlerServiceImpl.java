package ru.javandy.telegrambotexchangerates.serviceimpl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.javandy.telegrambotexchangerates.service.ExchangeRateCalculation;
import ru.javandy.telegrambotexchangerates.service.MessageHandlerService;
import static ru.javandy.telegrambotexchangerates.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class MessageHandlerServiceImpl implements MessageHandlerService {
    private final TelegramBot bot;
    private final ExchangeRateCalculation exchangeRateCalculation;

    @Override
    public void handleMessage(Message inputMessage, long chatId) {


        String inputMessageStr = inputMessage.text();

        if (inputMessageStr != null) {
            if ((inputMessageStr == START_CMD)) {
                sendMessage(chatId, GREETINGS_TEXT + "\n" + CHOOSE_OPTION);
            } else if (inputMessageStr.contains("$") || inputMessageStr.contains("тенге")) {
                sendMessage(chatId, exchangeRateCalculation.calculation(inputMessage.text()));
            } else {
                sendMessage(chatId, INVALID_TEXT + "\n" + CHOOSE_OPTION);
            }
        }
    }

    @Override
    public void sendMessage(Long chatId, String inputMessage) {
        SendMessage outputMessage = new SendMessage(chatId, inputMessage);
        try {
            bot.execute(outputMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
