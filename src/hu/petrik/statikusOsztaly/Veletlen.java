package hu.petrik.statikusOsztaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen(){}

     private static final Random RND = new Random();

    private static final List<String> VEZETEK_NEVEK = feltolt("files/veznev.txt");
    private static final List<String> NOI_KERESZT_NEVEK = feltolt("files/noikernev.txt");
    private static final List<String> FERFI_KERESZT_NEVEK = feltolt("files/ferfikernev.txt");

    private static List<String> feltolt(String fajlnev){
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fajlnev));
            while (file.hasNext()){
                lista.add(file.nextLine());
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static int velEgesz(int min, int max){
        if (min > max){
            throw new IllegalArgumentException("'min' must be <= 'max'");
        }
        return RND.nextInt(max - min + 1) + min;
    }

    public static char velkarakter(char min, char max){
        return (char) velEgesz(min, max);
    }

    public static String velVezeteknev(){
        return VEZETEK_NEVEK.get(RND.nextInt(VEZETEK_NEVEK.size()));
    }

    /**
     * Véletlen kereszt nevet generál a megadott paraméterek alapján.
     * Paraméter értéktől függően férfi vagy női keresztnevet
     * @param nem A generált név neme. Igaz(True), ha férfi, Hamis(False), ha nő.
     * @return Generált keresztnév.
     */
    public static String velKeresztnev(boolean nem){
        String keresztNev;
        if (nem){
            keresztNev = velFerfiKeresztnev();
        }
        else{
            keresztNev = velNoiKeresztnev();
        }
        return keresztNev;
    }

    private static String velNoiKeresztnev() {
        return NOI_KERESZT_NEVEK.get(RND.nextInt(NOI_KERESZT_NEVEK.size()));
    }

    private static String velFerfiKeresztnev() {
        return FERFI_KERESZT_NEVEK.get(RND.nextInt(FERFI_KERESZT_NEVEK.size()));
    }

    /**
     * Véletlen nevet generál a megadott paraméterek alapján.
     * Paraméter értéktől függően férfi vagy női nevet
     * @param nem A generált név neme. Igaz(True), ha férfi, Hamis(False), ha nő.
     * @return Generált név.
     */
    public static String velTeljesNev(boolean nem){
        return velVezeteknev() +" "+ velKeresztnev(nem);
    }
}
