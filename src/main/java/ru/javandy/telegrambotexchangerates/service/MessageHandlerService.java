package ru.javandy.telegrambotexchangerates.service;

import com.pengrad.telegrambot.model.Message;

public interface MessageHandlerService {
    void handleMessage(Message inputMessage, long chatId);
    void sendMessage(Long chatId, String inputMessage);
}
