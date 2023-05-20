package ru.javandy.telegrambotexchangerates.serviceimpl;

import com.pengrad.telegrambot.model.Message;
import org.springframework.stereotype.Service;
import ru.javandy.telegrambotexchangerates.model.Report;
import ru.javandy.telegrambotexchangerates.service.ReportService;

import java.time.LocalDate;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public Report saveReport(Message message) {
        LocalDate datedddd = LocalDate.now();
        Report reportInput = new Report();
        reportInput.setClientId(message.chat().id());
        reportInput.setReportText(message.);





        return null;
    }
}
