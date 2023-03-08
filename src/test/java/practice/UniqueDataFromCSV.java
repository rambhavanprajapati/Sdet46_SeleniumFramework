package practice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class UniqueDataFromCSV {
  public static void main(String[] args) {
    String csvFile = "./src/test/resources/excel/redbus.csv";
    String line = "";
    String csvSplitBy = ",";
    List<String> data = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] row = line.split(csvSplitBy);
        data.add(row[0]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    Set<String> uniqueData = new HashSet<>(data);
    System.out.println(uniqueData);
  }
}