package com.speakingclock.services;

import com.speakingclock.constants.SpeakingClockConstants;
import com.speakingclock.requests.TimeDto;
import com.speakingclock.services.exceptions.SpeakingClockServiceException;
import com.speakingclock.services.interfaces.SpeakingClockService;
import com.speakingclock.utils.SpeakingClockUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.*;

import static com.speakingclock.constants.SpeakingClockConstants.*;


@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

    @Override
    public String getCurrentTime(TimeDto timeDto) throws SpeakingClockServiceException {

        String timeInWords = null;
        if(timeDto.getCountryCode() == null)
            timeDto.setCountryCode("Asia/Kolkata");
        ZoneId zoneId=null;
        try {
            zoneId =  ZoneId.of(timeDto.getCountryCode());
        }catch (Exception exception){
            throw new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION, SpeakingClockConstants.UNABLE_GET_ZONEID);
        }
        if(zoneId==null)
            throw new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION,SpeakingClockConstants.UNABLE_GET_ZONEID);
        int hour,minutes;
        try {
            hour = LocalTime.now(ZoneId.of(timeDto.getCountryCode())).getHour();
        }catch (Exception exception){
            throw new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION,"Unable to get current hour");
        }
        try {
            minutes = LocalTime.now(ZoneId.of(timeDto.getCountryCode())).getMinute();
        }catch (Exception exception){
           throw  new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION,"Unable to get current min");
        }
        timeInWords = "It's " + SpeakingClockUtils.getWords(hour)+" "+SpeakingClockUtils.getWords(minutes);
        return timeInWords;

    }

    @Override
    public String getDayType(TimeDto timeDto) throws SpeakingClockServiceException {

        String dayInWords = null;
        if(timeDto.getCountryCode() == null)
            timeDto.setCountryCode("Asia/Kolkata");
        ZoneId  zoneId;
        try {
            zoneId =  ZoneId.of(timeDto.getCountryCode());
        }catch (Exception exception){
            throw new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION, SpeakingClockConstants.UNABLE_GET_ZONEID);
        }
        if(zoneId==null)
            throw new SpeakingClockServiceException(SpeakingClockConstants.SPEAKING_CLOCK_EXECPTION,SpeakingClockConstants.UNABLE_GET_ZONEID);
        Integer hour = LocalTime.now(ZoneId.of(timeDto.getCountryCode())).getHour();
        dayInWords = "It's " + SpeakingClockUtils.getDayTypeFromHour(hour);
        return dayInWords;

    }


}
