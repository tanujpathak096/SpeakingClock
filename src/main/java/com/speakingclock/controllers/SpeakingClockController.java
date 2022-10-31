package com.speakingclock.controllers;

import com.speakingclock.requests.TimeDto;
import com.speakingclock.services.exceptions.SpeakingClockServiceException;
import com.speakingclock.services.interfaces.SpeakingClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clock")
public class SpeakingClockController {

    @Autowired
    SpeakingClockService speakingClockService;

    /*
    get the currentTime of specific region
    is not mentioned in requirement
    By default we will consider IST
     */
    @GetMapping("/time")
    public ResponseEntity<Object> getCurrentTime(@RequestBody TimeDto timeDto) throws SpeakingClockServiceException {

        try{
          String timeInWords = speakingClockService.getCurrentTime(timeDto);
          return ResponseEntity.ok(timeInWords);
        }catch (SpeakingClockServiceException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.valueOf(exception.getCode()));
        }

    }

    /*
      resource to get the dayType
     */
    @GetMapping("/dayType")
    public ResponseEntity<String> getDayType(@RequestBody TimeDto timeDto) throws SpeakingClockServiceException {
        String dayInWords =  speakingClockService.getDayType(timeDto);
        return ResponseEntity.ok(dayInWords);
    }

}
