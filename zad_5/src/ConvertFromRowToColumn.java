import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertFromRowToColumn {
    public String inputFile;
    public String outputFile;

    public ConvertFromRowToColumn() {
    }

    public String getInputFile() {
        return this.inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String[] readFile(String arg) {
        this.inputFile = arg;
        List<String> number = new ArrayList<>();
        try {
            number = Files.readAllLines(Paths.get(inputFile));
        }
        catch (IOException ignored){
            System.out.println("File has not been opened!");
        }
        return String.join("", number).split("\\s+");
    }

    public void writeFile(String arg, String[] convertString) {
        this.outputFile = arg;
        try {
            FileWriter myWriter = new FileWriter(outputFile);
            for(String elem : convertString) {
                myWriter.write(elem+'\n');
            }
            myWriter.close();
        } catch (IOException ignored) {
            System.out.println("File has not been written!");
        }

    }
    public static void main(String[] args) {
        ConvertFromRowToColumn converter = new ConvertFromRowToColumn();
        String[] numbers = converter.readFile(args[0]);
        converter.writeFile(args[1], numbers);
    }
}
