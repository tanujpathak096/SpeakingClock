package com.speakingclock.services.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeakingClockServiceException extends Throwable {

    int code;
    String message;

    public SpeakingClockServiceException(int errorCode, String message) {
        this.code=errorCode;
        this.message=message;
    }
}
