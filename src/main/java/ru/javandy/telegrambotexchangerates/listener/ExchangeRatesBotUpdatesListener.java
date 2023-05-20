package ru.javandy.telegrambotexchangerates.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javandy.telegrambotexchangerates.service.MessageHandlerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRatesBotUpdatesListener implements UpdatesListener {
    private final TelegramBot bot;
    private final MessageHandlerService messageHandler;

    @PostConstruct
    public void init() {
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            Message message = update.message();
            if (message != null) {
                messageHandler.handleMessage(message, extractChatId(message));

            }
            updates.forEach(System.out::println);
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private long extractChatId(Message message) {
        return message.chat().id();
    }
}
