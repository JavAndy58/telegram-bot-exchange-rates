package ru.javandy.telegrambotexchangerates.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRatesBot {
    private final TelegramBot bot;

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(System.out::println);

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

}
