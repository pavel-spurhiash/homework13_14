package com.gmail.pashasimonpure.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.gmail.pashasimonpure.service.SumService;

@Service
public class SumServiceImpl implements SumService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private static final String REGEX_LINE_FILTER = "^\\D*[0-9]+\\D*[0-9]*\\D*$";

    public SumServiceImpl(){
    }

    @Override
    public int add(String numbers) {
        int sum = 0;

        if (numbers == null || numbers.isEmpty()) {
            return sum;
        }

        Pattern pattern = Pattern.compile(REGEX_LINE_FILTER);
        Matcher matcher = pattern.matcher(numbers);

        if (matcher.matches()) {

            //search numbers:
            matcher = Pattern.compile("[0-9]+").matcher(numbers);

            while (matcher.find()) {
                Integer number = Integer.parseInt(matcher.group());
                sum = sum + number;
            }

        }

        return sum;
    }

}