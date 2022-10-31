package com.speakingclock.utils;

import org.springframework.stereotype.Component;

import static com.speakingclock.constants.SpeakingClockConstants.*;

@Component
public class SpeakingClockUtils {

    public static String getWords(Integer number){

        String numberInWords = "";
        int n1=number,n2=number;
        int b=n1%10,a=n2/10; //  n1/10 means last digit is removed and n2%10 means last digit by modulus

        if(a==1)
        {
            numberInWords=two_digits[b+1];
        }
        else if(b==0)
            numberInWords = tens_multiple[a];
        else
            numberInWords = tens_multiple[a]+" "+single_digits[b];

        return numberInWords;
    }


    public static  String getDayTypeFromHour(Integer hour){
        if(hour >=6 && hour<18)
            return "Midday";
        return "Midnight";
    }


}
