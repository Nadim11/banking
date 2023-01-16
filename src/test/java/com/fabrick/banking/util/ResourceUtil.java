package com.fabrick.banking.util;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class ResourceUtil {

    public static File getFile(String path) throws IOException {
        return new ClassPathResource(path).getFile();
    }
}
