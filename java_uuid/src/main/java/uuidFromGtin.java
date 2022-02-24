import com.fasterxml.uuid.impl.NameBasedGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import com.fasterxml.uuid.Generators;
import java.util.UUID;

public class uuidFromGtin {
    private static UUID PYTHON_DNS_NAMESPACE = UUID.fromString("6ba7b810-9dad-11d1-80b4-00c04fd430c8");
    public static void main(String[] args) throws IOException {
        try {
            Scanner gtins = getDataFile();
            FileWriter outFile = getOutFile();
            NameBasedGenerator uuid5Generator = Generators.nameBasedGenerator(PYTHON_DNS_NAMESPACE);
            while (gtins.hasNextLine()) {
                String gtin = gtins.nextLine();
                String uuid = uuid5Generator.generate(gtin).toString();
                outFile.write(gtin + "; " + uuid + "\n");
            }
            outFile.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private static Scanner getDataFile() throws FileNotFoundException {
        File dataFile = new File("/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/inputs/gtins.txt");
        return new Scanner (dataFile);
    }

    private static FileWriter getOutFile() throws IOException {
        File outFile = new File("/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/outputs/java_uuids.txt");
        if (outFile.exists()) {
            outFile.delete();
        }
        outFile.createNewFile();
        return new FileWriter(outFile.getPath());

    }
}
