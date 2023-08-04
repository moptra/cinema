package com.example.cinema_exam_practice.service;

import com.example.cinema_exam_practice.domain.Screening;
import com.example.cinema_exam_practice.dto.in.ScreeningCommand;
import com.example.cinema_exam_practice.repository.ScreeningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class ScreeningService {
        private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand screeningCommand) {
        Screening screening = new Screening(screeningCommand);
        screeningRepository.save(screening);
    }
}
