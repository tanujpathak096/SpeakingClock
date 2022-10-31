package com.speakingclock.services.interfaces;

import com.speakingclock.requests.TimeDto;
import com.speakingclock.services.exceptions.SpeakingClockServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SpeakingClockService {

    public String getCurrentTime(TimeDto timeRequest) throws SpeakingClockServiceException;

    public String getDayType(TimeDto timeRequest) throws SpeakingClockServiceException;


}
