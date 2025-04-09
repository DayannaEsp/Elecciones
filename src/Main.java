import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Candidato A"));
        candidatos.add(new Candidato("Candidato B"));
        candidatos.add(new Candidato("Candidato C"));

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Votar");
            System.out.println("2. Ver costo campaña por candidato");
            System.out.println("3. Vaciar urnas");
            System.out.println("4. Total de votos");
            System.out.println("5. Porcentaje de votos por candidato");
            System.out.println("6. Costo promedio campaña");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                for (int i = 0; i < candidatos.size(); i++) {
                    System.out.println(i + " - " + candidatos.get(i).getNombre());
                }
                System.out.print("Elegir candidato (número): ");
                int index = sc.nextInt();

                System.out.println("Medio de influencia:");
                System.out.println("1. Internet");
                System.out.println("2. Radio");
                System.out.println("3. Televisión");
                int medio = sc.nextInt();
                MedioInfluencia influencia = medio == 1 ? MedioInfluencia.INTERNET :
                        medio == 2 ? MedioInfluencia.RADIO :
                                MedioInfluencia.TELEVISION;

                candidatos.get(index).votar(influencia);
                System.out.println("Voto registrado.");
            }

            else if (opcion == 2) {
                for (Candidato c : candidatos) {
                    System.out.println(c.getNombre() + ": $" + c.getCostoCampania());
                }
            }

            else if (opcion == 3) {
                for (Candidato c : candidatos) {
                    c.reiniciar();
                }
                System.out.println("Urnas vaciadas.");
            }

            else if (opcion == 4) {
                int total = 0;
                for (Candidato c : candidatos) {
                    total += c.getTotalVotos();
                }
                System.out.println("Total de votos: " + total);
            }

            else if (opcion == 5) {
                int total = 0;
                for (Candidato c : candidatos) {
                    total += c.getTotalVotos();
                }
                for (Candidato c : candidatos) {
                    double porcentaje = total > 0 ? (double) c.getTotalVotos() * 100 / total : 0;
                    System.out.printf("%s: %.2f%%\n", c.getNombre(), porcentaje);
                }
            }

            else if (opcion == 6) {
                int suma = 0;
                for (Candidato c : candidatos) {
                    suma += c.getCostoCampania();
                }
                double promedio = candidatos.size() > 0 ? (double) suma / candidatos.size() : 0;
                System.out.println("Costo promedio de campaña: $" + promedio);
            }

        } while (opcion != 0);

        sc.close();
    }
}