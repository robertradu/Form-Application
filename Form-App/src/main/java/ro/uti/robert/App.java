package ro.uti.robert;

import com.primarie.model.Form;

import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        List<Form> formList = new ArrayList<>();
//        AdvancedWriter.connect();
        //   AdvancedWriter.initDB();
        while (true) {
            Form form = Reader.Listener();
            formList.add(form);
            //  Form savedForm = Writer.write(form);
            Form savedForm1 = AdvancedWriter.write(form);

        }
    }
}
