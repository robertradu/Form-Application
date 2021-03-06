package ro.uti.robert.repository.factory;

import ro.uti.robert.repository.CoordinatesRepository;
import ro.uti.robert.repository.impl.CoordinatesDBRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CoordinatesRepositoryFactory {
    private static Properties fileProperties;

    public static CoordinatesRepository getInstance() {
      try {
            InputStream input = new FileInputStream("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\application.properties");
            fileProperties = new Properties();
            fileProperties.load(input);
            String type = fileProperties.getProperty("database_type");
            if (type.equalsIgnoreCase("postgresql")) {
                return new CoordinatesDBRepository();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("DB parameter is not set!");
    }
}
