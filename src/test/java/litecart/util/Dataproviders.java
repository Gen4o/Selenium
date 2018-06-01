package litecart.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dataproviders {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "AdminTest1", "passwordnew" },
                { "StatusAdmin3", "ShotoTam"},
                { "Status4", "ShotoTam"},
                { "StatusAdmi55555", "ShotoTam"}
        };
    }

    @DataProvider(name = "loginFormCheck")
    public Iterator<Object[]> passwordFieldCheckedData() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/test_data/login_form_data.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split =  line.split(";");
            list.add(new Object[]{split[0], split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
