package com.speakingclock.controllers;

import com.speakingclock.requests.TimeDto;
import com.speakingclock.services.exceptions.SpeakingClockServiceException;
import com.speakingclock.services.interfaces.SpeakingClockService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpeakingClockControllerTest {

    @InjectMocks
    SpeakingClockController speakingClockController;

    @Mock
    SpeakingClockService speakingClockService;

    @Test
    void getCurrentTime() throws SpeakingClockServiceException {

        TimeDto timeDto  =  new TimeDto();
        ResponseEntity<Object> currentTime = speakingClockController.getCurrentTime(timeDto);
        assertNotNull(currentTime);

    }

    @Test
    void getDay() throws SpeakingClockServiceException {
        TimeDto timeDto  =  new TimeDto();
        ResponseEntity<String> currentTime = speakingClockController.getDayType(timeDto);
        assertNotNull(currentTime);
    }
}