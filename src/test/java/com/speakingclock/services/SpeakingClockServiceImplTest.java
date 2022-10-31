package com.speakingclock.services;

import com.speakingclock.requests.TimeDto;
import com.speakingclock.services.exceptions.SpeakingClockServiceException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpeakingClockServiceImplTest {

    @InjectMocks
    SpeakingClockServiceImpl speakingClockService;

    @Test
    void getTimeCountryCodeIsEmpty() {
        TimeDto timeDto = new TimeDto();
        timeDto.setCountryCode("");
        SpeakingClockServiceException exception = assertThrows(SpeakingClockServiceException.class,() ->{
            speakingClockService.getCurrentTime(timeDto);
        });
        String expectedMessage = "Unable to get zoneId from TimeDto countryCode";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    void getTimeOfWrongCountryCode() {
        TimeDto timeDto = new TimeDto();
        timeDto.setCountryCode("XYZ/BHDLPW");
        SpeakingClockServiceException exception = assertThrows(SpeakingClockServiceException.class,() ->{
            speakingClockService.getCurrentTime(timeDto);
        });
        String expectedMessage = "Unable to get zoneId from TimeDto countryCode";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));

    }

    @Test
    void getTimeOfCountryCode() throws SpeakingClockServiceException {
        TimeDto timeDto = new TimeDto();
        timeDto.setCountryCode("Asia/Kolkata");
        String response = speakingClockService.getCurrentTime(timeDto);
        assertNotNull(response);

    }

    @Test
    void isDayCountryCodeIsNull() throws SpeakingClockServiceException {
        TimeDto timeDto = new TimeDto();
        String response = speakingClockService.getDayType(timeDto);
        assertNotNull(response);
    }

    @Test
    void isDayCountryCodeIsEmpty() {
        TimeDto timeDto = new TimeDto();
        timeDto.setCountryCode("");
        SpeakingClockServiceException exception = assertThrows(SpeakingClockServiceException.class,() ->{
            speakingClockService.getCurrentTime(timeDto);
        });
        String expectedMessage = "Unable to get zoneId from TimeDto countryCode";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }


}