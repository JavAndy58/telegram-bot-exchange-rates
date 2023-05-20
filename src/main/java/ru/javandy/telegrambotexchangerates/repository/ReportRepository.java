package ru.javandy.telegrambotexchangerates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javandy.telegrambotexchangerates.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
