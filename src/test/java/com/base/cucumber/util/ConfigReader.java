package com.base.cucumber.util;

import com.base.cucumber.exception.CustomException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    public static void initialize_Properties() {
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH);
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new CustomException(
                        CustomException.ExceptionMessageEnum.CONFIG_READER_ERROR,
                        CustomException.ExceptionMessageEnum.CONFIG_READER_ERROR.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new CustomException(
                    CustomException.ExceptionMessageEnum.FILE_NOT_FOUND_EXCEPTION,
                    CustomException.ExceptionMessageEnum.FILE_NOT_FOUND_EXCEPTION.getMessage());
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
