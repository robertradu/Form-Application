package ro.uti.robert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primarie.model.CompanyForm;
import com.primarie.model.Form;
import com.primarie.model.HospitalForm;
import com.primarie.model.PoliceForm;
import com.primarie.service.FormValidationException;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class Reader {
    public static Properties fileProperties;

    public Reader() {
    }

    public static String setUp() {
        try {
            fileProperties = new Properties();

            fileProperties.setProperty("form_path", "C:\\Users\\robert.radu\\Desktop\\Form Files");

            // Trebuie citita calea relativa catre fisier, nu se potriveste calea absoluta daca ruleaza altcineva programul
            // https://stackoverflow.com/questions/35008377/reading-from-config-properties-file-maven-project
            File file = new File("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\application.properties");

            FileOutputStream fo = new FileOutputStream(file);
            fileProperties.store(fo, "form_path");


            InputStream inputStream = new FileInputStream("C:\\Users\\robert.radu\\IdeaProjects\\FormReader\\src\\main\\resources\\application.properties");
            fileProperties.load(inputStream);
            String formPath = fileProperties.getProperty("form_path");


            return formPath;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void initDB() {

    }

    public static Form Listener() {
        //setUp();
        String jsonFilePath = Reader.setUp();


        try {
            WatchService service = FileSystems.getDefault().newWatchService();

            Path folder = Paths.get(jsonFilePath);

            folder.register(service, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey watchKey;

            do {
                watchKey = service.take();


                for (WatchEvent event : watchKey.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();

                    Path eventPath = (Path) event.context();
                    String name = eventPath.toString();

                    Form form = validation(name);
                    return form;

                }
            } while (watchKey.reset());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Form validation(String name) {
        try {
            ObjectMapper obj = new ObjectMapper();

            if (name.startsWith("police")) {
                File policeFile = new File(fileProperties.getProperty("form_path") + "\\" + name);
                PoliceForm policeForm = obj.readValue(policeFile, PoliceForm.class);
                policeForm.setRecordDate(policeForm.getData());
                policeForm.validate();

                return policeForm;
            }

            if (name.startsWith("hospital")) {
                File hospitalFile = new File(fileProperties.getProperty("form_path") + "\\" + name);
                HospitalForm hospitalForm = obj.readValue(hospitalFile, HospitalForm.class);
                hospitalForm.setRecordDate(hospitalForm.getData());
                hospitalForm.validate();

                return hospitalForm;
            }

            if (name.startsWith("company")) {
                File companyFile = new File(fileProperties.getProperty("form_path") + "\\" + name);
                CompanyForm companyForm = obj.readValue(companyFile, CompanyForm.class);
                companyForm.setRecordDate(companyForm.getData());
                companyForm.validate();

                return companyForm;
            }

        } catch (FormValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Eroare in fisierul " + name, JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}