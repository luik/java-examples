import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream("src.html")));

        List<String> lines = new ArrayList<>();
        String line = bufferedReader.readLine();
        while(line != null){
            lines.add(line);
            line = bufferedReader.readLine();
        }

        lines.remove(0);

        StringJoiner stringJoiner = new StringJoiner("\n");
        lines.forEach(stringJoiner::add);

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(stringJoiner.toString().getBytes()));



        System.out.println("DONE");
    }
}
