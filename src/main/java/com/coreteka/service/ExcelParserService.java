package com.coreteka.service;

import com.coreteka.entities.DriverProfile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ExcelParserService {
    List<DriverProfile> parse(File file) throws IOException, InvalidFormatException;
}
