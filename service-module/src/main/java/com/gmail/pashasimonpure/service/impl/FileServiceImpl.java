package com.gmail.pashasimonpure.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.gmail.pashasimonpure.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gmail.pashasimonpure.repository.FileRepository;
import com.gmail.pashasimonpure.service.SumService;

@Service
public class FileServiceImpl implements FileService {

    FileRepository fileRepository;
    SumService sumService;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, SumService sumService){
        this.fileRepository = fileRepository;
        this.sumService = sumService;
    }

    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public int getValue(String filename) {

        List<String> lines = fileRepository.readLines(filename);
        Integer sum = 0;

        for (String line : lines) {
            sum = sum + sumService.add(line);
            logger.debug("LINE SUM = " + sumService.add(line) + ", LINE = '" + line + "'");
        }

        return sum;
    }

}