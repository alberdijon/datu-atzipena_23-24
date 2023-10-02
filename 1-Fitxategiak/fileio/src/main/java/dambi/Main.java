package dambi;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("FILEIO MENUA");
            System.out.println("====================================");
            System.out.println("1.- Direktorio bat dugun zihurtatu");
            System.out.println("2.- Karpeta baten edukia bistaratu");
            System.out.println("3.- Karpeta egitura sortu  (Sortuta ez badago)");
            System.out.println("4.- Fitxategiak sortu galdera bidez");
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

        in.close();
    }

    public static void met1() throws IOException {

        //file.exists;
        String pathstr;

        Scanner in = new Scanner(System.in);
        System.out.println("Sartu existitzen den begiratu nahi duzun path-a");
        pathstr = in.next();
        in.close();

        Path path = Paths.get(pathstr);

        if(Files.exists(path)){

            System.out.println("Sartutako path-a existitzen da.");

        }else{
            System.out.println("Sartutako path-a ez da existitzen.");
        }

    }

     public static void met2() throws IOException {

        File directorio = new File("C:\\Users\\Usuario\\Desktop\\clases\\DAM2\\datu-atzipena_23-24\\1-Fitxategiak\\fileio\\karpeta_berriak");                                         
        String[] lista = directorio.list();
        Arrays.sort(lista);
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }

    }

    public static void met3() throws IOException {

        Path karpetaBerria = Paths.get(("karpeta_berriak"));
        try{
            Files.createDirectories(karpetaBerria);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path animaliak = Paths.get(("karpeta_berriak/animaliak"));
        try{
            Files.createDirectories(animaliak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path elikagaiak = Paths.get(("kareptaBerria/elikagaiak"));
        try{
            Files.createDirectories(elikagaiak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path barazkiak = Paths.get(("kareptaBerria/elikagaiak/barazkiak"));
        try{
            Files.createDirectories(barazkiak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path esnekiak = Paths.get(("kareptaBerria/elikagaiak/esnekiak"));
        try{
            Files.createDirectories(esnekiak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path arrainak = Paths.get(("kareptaBerria/animaliak/arrainak"));
        try{
            Files.createDirectories(arrainak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
        Path ugaztunak = Paths.get(("kareptaBerria/animaliak/ugaztunak"));
        try{
            Files.createDirectories(ugaztunak);
        } catch (Exception e){
            System.out.println("Zerbait gaizki joan da");
        
        }
    }

    static Path barazkiak = Paths.get("kareptaBerria/elikagaiak/barazkiak");
    static Path esnekiak = Paths.get("kareptaBerria/elikagaiak/esnekiak");
    static Path arrainak = Paths.get("kareptaBerria/animaliak/arrainak");
    static Path ugaztunak = Paths.get("kareptaBerria/animaliak/ugaztunak");

    public static void met4() throws IOException {
        
            Scanner in = new Scanner(System.in);
        
            boolean ondo = false;
            while (!ondo) {
                System.out.println("Zer zoaz deskribatzera?");
                String zer = in.next();
        
                if (zer.equals("barazkiak") || zer.equals("esnekiak") || zer.equals("arrainak") || zer.equals("ugaztunak")) {
                    ondo = true;
                } else {
                    System.out.println("Deskribatzea nahi duzuna ez da existitzen, mesedez berriro aukeratu.");
                }
            }
        
            System.out.println("Zein?");
            String zein = in.next();
            boolean existe = existe(zein);
            char zeregina = 'N';
        
            if (existe) {
                System.out.println("Deskribatu nahi duzuna deskribaturik dago jada, deskribapen gehiago gehitzea nahi duzu edo aurrekoa borratzea? [G/B]");
                zeregina = in.next().charAt(0);
            }
        
            System.out.println("Nolakoa da?");
            String nola = in.next();
        
            in.close();
        
            // Realizar acciones según el valor de zeregina y si el archivo existe o no
            if (existe) {
                if (zeregina == 'G') {
                    agregarDescripcion(zein, nola);
                } else if (zeregina == 'B') {
                    borrarYAgregarDescripcion(zein, nola);
                }
            } else {
                crearYAgregarDescripcion(zein, nola);
            }
    }
    

    public static boolean existe(String nombreArchivo) {
        // Comprueba si el archivo existe en alguna de las rutas predefinidas
        Path[] rutas = {barazkiak, esnekiak, arrainak, ugaztunak};
        for (Path ruta : rutas) {
            Path archivo = ruta.resolve(nombreArchivo + ".txt");
            if (Files.exists(archivo)) {
                return true;
            }
        }
        return false;
    }

    public static void agregarDescripcion(String nombreArchivo, String descripcion) throws IOException {
        // Agrega la descripción al archivo
        Path[] rutas = {barazkiak, esnekiak, arrainak, ugaztunak};
        for (Path ruta : rutas) {
            Path archivo = ruta.resolve(nombreArchivo + ".txt");
            if (Files.exists(archivo)) {
                try (BufferedWriter writer = Files.newBufferedWriter(archivo, StandardOpenOption.APPEND)) {
                    writer.write(descripcion);
                    writer.newLine();
                }
            }
        }
    }

    public static void borrarYAgregarDescripcion(String nombreArchivo, String descripcion) throws IOException {
        // Borra el contenido existente y agrega la nueva descripción al archivo
        Path[] rutas = {barazkiak, esnekiak, arrainak, ugaztunak};
        for (Path ruta : rutas) {
            Path archivo = ruta.resolve(nombreArchivo + ".txt");
            if (Files.exists(archivo)) {
                Files.delete(archivo);
                try (BufferedWriter writer = Files.newBufferedWriter(archivo, StandardOpenOption.CREATE)) {
                    writer.write(descripcion);
                    writer.newLine();
                }
            }
        }
    }

    public static void crearYAgregarDescripcion(String nombreArchivo, String descripcion) throws IOException {
        // Crea un nuevo archivo y agrega la descripción
        Path[] rutas = {barazkiak, esnekiak, arrainak, ugaztunak};
        for (Path ruta : rutas) {
            Path archivo = ruta.resolve(nombreArchivo + ".txt");
            try (FileWriter f = new FileWriter(archivo);
                BufferedWriter writer = new BufferedWriter(f);) {
                writer.write(descripcion);
                writer.newLine();
            }
        }
    }

}