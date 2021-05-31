import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConvertFromRowToColumn {
    public String inputFile;
    public String outputFile;

    public ConvertFromRowToColumn() {
    }

    public ConvertFromRowToColumn(String in, String out) {
        this.inputFile = in;
        this.outputFile = out;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getInputFile() {
        return this.inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public String toString() {
        return "ConvertFromRowToColumn{" +
                "inputFile='" + inputFile + '\'' +
                ", outputFile='" + outputFile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConvertFromRowToColumn that = (ConvertFromRowToColumn) o;
        return Objects.equals(inputFile, that.inputFile) && Objects.equals(outputFile, that.outputFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputFile, outputFile);
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
    public static void main(String[] args){
        try {
            ConvertFromRowToColumn converter = new ConvertFromRowToColumn();
            String[] numbers = converter.readFile(args[0]);
            converter.writeFile(args[1], numbers);
        } catch (Exception ignored) {
            System.out.println("Pass two argument! Input file path and output file path!");
        }
    }
}
