package dambi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lerroz lerro irakurtzen du, 
    * lerro bakoitza outagainLn.txt fitxategian idatziz baina lerro hazieran lerro zenbakia gehitzen du.
    */

public class CopyLinesZenbakiekin {
        public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader("iostreams\\xanadu.txt");
             BufferedReader br = new BufferedReader(reader);
             FileWriter fl = new FileWriter("iostreams\\outagainLn.txt");
             BufferedWriter writer = new BufferedWriter(fl);
        ) {
            String line;
            int linea=1;
            while ((line = br.readLine()) != null) {
                writer.write(linea + " " + line);
                writer.newLine();
                linea++;
            }
        }
    }
}
