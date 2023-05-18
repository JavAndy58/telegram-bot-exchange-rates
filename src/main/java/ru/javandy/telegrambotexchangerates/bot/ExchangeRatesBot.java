package ru.javandy.telegrambotexchangerates.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeRatesBot implements UpdatesListener {
    private final TelegramBot bot;


    @PostConstruct
    public void init() {
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            updates.forEach(System.out::println);
            bot.execute(new SendMessage(update.message().chat().id(), "Приветус"));

        });

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
