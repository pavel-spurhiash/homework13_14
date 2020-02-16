package com.gmail.pashasimonpure.repository.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import com.gmail.pashasimonpure.repository.FileRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public FileRepositoryImpl(){
    }

    @Override
    public List<String> readLines(String filename) {
        logger.debug("trying read " + filename + " ...");

        List<String> lines = new ArrayList<>();

        if (filename == null) {
            logger.error("file read error - path is null");
            return lines;
        }

        File file = new File(filename);

        if (!file.exists() || !file.isFile()) {
            logger.error("file does not exist.");
            return lines;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            logger.debug("file read successful!");

        } catch (FileNotFoundException ex) {
            logger.error("file '" + filename + "' not found.\n" + ex);
        } catch (IOException ex) {
            logger.error("file read error.\n" + ex);
        }

        return lines;
    }

}