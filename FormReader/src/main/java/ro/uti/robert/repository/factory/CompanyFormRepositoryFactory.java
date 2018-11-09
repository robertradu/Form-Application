package ro.uti.robert.repository.factory;

import ro.uti.robert.repository.CompanyFormRepository;
import ro.uti.robert.repository.impl.CompanyFormDBRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CompanyFormRepositoryFactory {
    private static Properties fileProperties;

    public static CompanyFormRepository getInstance() {
        try {
            InputStream input = new FileInputStream("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\application.properties");
            fileProperties = new Properties();
            fileProperties.load(input);
            String type = fileProperties.getProperty("database_type");

            if (type.equalsIgnoreCase("postgresql")) {
                return new CompanyFormDBRepository();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("DB parameter is not set!");
    }
}
