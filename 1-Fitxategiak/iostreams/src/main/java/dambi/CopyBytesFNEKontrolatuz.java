package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte irakurtzen du, 
    * byte bakoitza outagainBt.txt fitxategian idatziz baina dokumentua ez badu aurkitzen mesu bat ipintzen du terminalean.
    */

public class CopyBytesFNEKontrolatuz {
        public static void main(String[] args) throws IOException{

        try (FileInputStream fis = new FileInputStream("iostreams\\xanadu.txt");
             FileOutputStream fos = new FileOutputStream("iostreams\\outagainBt.txt")
        ) {
            byte[] buffer = new byte[1024];

            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }catch(FileNotFoundException ex){

            System.out.println("Jatorrizko dokumentua ez da aurkitu");

        }
    }
}
