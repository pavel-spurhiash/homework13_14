package com.gmail.pashasimonpure.repository;

import java.util.List;

public interface FileRepository {

    List<String> readLines(String filename);

}