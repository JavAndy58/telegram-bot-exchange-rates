package ru.javandy.telegrambotexchangerates.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "reporting")
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "id_user")
    private Long clientId;

    @Column(name = "report_text")
    private String reportText;

    @Column(name = "sent_date")
    private LocalDate sentDate;
}
