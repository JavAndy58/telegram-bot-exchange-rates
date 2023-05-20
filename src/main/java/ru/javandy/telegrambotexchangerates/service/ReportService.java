package ru.javandy.telegrambotexchangerates.service;

import com.pengrad.telegrambot.model.Message;
import ru.javandy.telegrambotexchangerates.model.Report;

public interface ReportService {
    Report saveReport(Message message);
}
