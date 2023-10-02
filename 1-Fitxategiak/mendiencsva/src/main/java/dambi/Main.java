package dambi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println(" MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println(". Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2. Mendirik altuena bistaratu");
            System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- ...");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    met1();
                    break;
                case 2:
                    met2();
                    break;
                case 3:
                    met3();
                    break;
                case 4:
                    met4();
                    break;

                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void met1() throws IOException {

        try (FileReader reader = new FileReader("mendiencsva\\Mendiak.csv");
                BufferedReader br = new BufferedReader(reader);) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");

                for (int x = 0; x < lines.length; x++) {

                    System.out.printf("%-20s", lines[x]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException ex) {

            System.out.println("Jatorrizko dokumentua ez da aurkitu");

        }

    }

    public static void met2() throws IOException {

        try (FileReader reader = new FileReader("mendiencsva\\Mendiak.csv");
                BufferedReader br = new BufferedReader(reader);) {

            String line;
            String[] aundiena = {"0", "0", "0"};
            int linea = 1;
            int lalinea = 1;
            int biggest = 0;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                if ((linea != 1) && (Integer.parseInt(lines[1]) > biggest)) {

                    lalinea = linea;
                    biggest = Integer.parseInt(lines[1]);
                    aundiena = lines;

                }else if(linea == 1){
                    aundiena = line.split(";");
                }

                linea++;

            }

            System.out.println("Mendirik altuena: " + aundiena[0] + " da " + aundiena[1] + " metro ditu eta " + aundiena[2] + "n dago");

        } catch (FileNotFoundException ex) {

            System.out.println("Jatorrizko dokumentua ez da aurkitu");

        }

    }

    public static void met3() throws FileNotFoundException, IOException{

        try (FileReader reader = new FileReader("mendiencsva\\Mendiak.csv");
                BufferedReader br = new BufferedReader(reader);
                FileWriter fl = new FileWriter("mendiencsva\\Gipuzkoa.csv");
                BufferedWriter writer1 = new BufferedWriter(fl);
                FileWriter f2 = new FileWriter("mendiencsva\\Araba.csv");
                BufferedWriter writer2 = new BufferedWriter(f2);
                FileWriter f3 = new FileWriter("mendiencsva\\Bizkaia.csv");
                BufferedWriter writer3 = new BufferedWriter(f3);
                FileWriter f4 = new FileWriter("mendiencsva\\Nafarroa.csv");
                BufferedWriter writer4 = new BufferedWriter(f4);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                if(lines[2].equals("Gipuzkoa")){
                    writer1.write(line);
                    writer1.newLine();
                }else if(lines[2].equals("Araba")){
                    writer2.write(line);
                    writer2.newLine();
                }else if(lines[2].equals("Bizkaia")){
                    writer3.write(line);
                    writer3.newLine();
                }else{
                    writer4.write(line);
                    writer4.newLine();
                }
            }
        }

    }

    public static void met4(){
        System.out.println("...");
    }
}