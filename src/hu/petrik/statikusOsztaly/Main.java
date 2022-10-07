package hu.petrik.statikusOsztaly;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velEgesz(5, 10));
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velkarakter('A', 'Z'));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(Veletlen.velTeljesNev(false));
        }System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(Veletlen.velTeljesNev(true));
        }
    }
}
