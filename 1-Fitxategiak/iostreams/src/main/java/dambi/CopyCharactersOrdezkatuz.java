package dambi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karakteres karaktere irakurtzen du, 
    * karaktere bakoitza outagainCh.txt fitxategian idatziz eta 'a' letra 'o' letra gaitik aldatzen du
    */

public class CopyCharactersOrdezkatuz {
        public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader("iostreams\\xanadu.txt");
            BufferedReader br = new BufferedReader(reader);
             FileWriter writer = new FileWriter("iostreams\\outagainCh.txt")
        ) {
            int charRead;
            while ((charRead = br.read()) != -1) {
                if (charRead == 'a') {
                    writer.write('o');
                } else if(charRead == 'A'){
                    writer.write('O');
                }else{
                    writer.write(charRead);
                }
            }
        }
    }
}
