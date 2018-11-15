package com.coreteka.service.impl;

import com.coreteka.entities.Authorities;
import com.coreteka.entities.DriverProfile;
import com.coreteka.entities.User;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.service.ExcelParserService;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelParserServiceImpl implements ExcelParserService {

    @Override
    public List<DriverProfile> parse(File file) throws IOException, InvalidFormatException {

        try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            /*AuthoritiesService authoritiesService = new AuthoritiesServiceImpl();
            Set<Authorities> authoritiesSet = new HashSet<>();
            authoritiesSet.add(authoritiesService.getByName("ROLE_DRIVER"));*/

            List<DriverProfile> driverProfiles = new ArrayList<>();

            Iterator<Row> iterator = sheet.iterator();
            iterator.next();//Skipping header row

            while (iterator.hasNext()){
                Row row = iterator.next();
                String username = row.getCell(0).toString();
                String password = row.getCell(1).toString();
                String fullName = row.getCell(2).toString();
                String phone = row.getCell(3).toString();

                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setUserStatus(true);
//                user.setAuthorities(authoritiesSet);

                DriverProfile driverProfile = new DriverProfile();
                driverProfile.setFullName(fullName);
                driverProfile.setPhone(phone);
                driverProfile.setUser(user);

                driverProfiles.add(driverProfile);
            }
            return driverProfiles;
        }
    }
}
