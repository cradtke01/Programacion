import java.util.Random;
import java.util.Scanner;

public class Taller01Sismos {

    public static void menu(double[][] sismos) {
        System.out.println("+---------------------------------------------------------------------------------------------------------+\n" +
                "|Ingrese \"1\" para obtener informacion sobre el sismo mas intenso.                                         |\n" +
                "|Ingrese \"2\" para conocer el numero de dias en los cuales se registraron sismos de intensidad 5.5 o mayor.|\n" +
                "|Ingrese \"3\" para saber que dia la intensidad sismica fue mayor.                                          |\n" +
                "+---------------------------------------------------------------------------------------------------------+\n");
        switch (leerSeleccion()) {
            case 1:
                mayorSismo(sismos);
                menu(sismos);
                break;
            case 2:
                mayorCincoCinco(sismos);
                menu(sismos);
                break;
            case 3:
                diaMasIntenso(sismos);
                menu(sismos);
                break;
            default:
                menu(sismos);
        }
    }

    public static int leerSeleccion() {
        Scanner input = new Scanner(System.in);
        int seleccion = 0;
        try {
            seleccion = input.nextInt();
        } catch (Exception e) {
            leerSeleccion();
        }
        return seleccion;
    }

    public static int leerDias() {
        Scanner input = new Scanner(System.in);
        int dias = 0;
        try {
            dias = input.nextInt();
        } catch (Exception e) {
            System.out.println("Porfavor ingrese un numero valido de dias.");
            leerDias();
        }
        return dias;
    }

    public static double[][] generarSismos(int dias) {
        double[][] sismos = new double[dias][24];
        Random random = new Random();
        for (int i = 0; i < dias; i++) {
            for (int j = 0; j < 24; j++) {
                sismos[i][j] = random.nextDouble() * (9.5);
            }
        }
        return sismos;
    }

    //Qué intensidad? Qué día? A qué hora? Ocurrió el sismo más intenso.
    public static void mayorSismo(double[][] sismos) {
        double intensidad = 0;
        int dia = 0;
        int hora = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < 24; j++) {
                if (sismos[i][j] > intensidad) {
                    intensidad = sismos[i][j];
                    dia = i;
                    hora = j;
                }
            }
        }
        System.out.println("El sismo mas intenso tuvo una intensidad de " + intensidad + " y ocurrio el dia " + dia + " a las " + hora + " horas.");
    }

    //Cuántos días se registraron sismos mayores o iguales a 5.5 grados?
    public static void mayorCincoCinco(double[][] sismos) {
        int count = 0;
        int countTotal = 0;
        for (int i = 0; i < sismos.length; i++) {
            for (int j = 0; j < 24; j++) {
                if (sismos[i][j] >= 5.5) {
                    count = 1;
                }
            }
            if (count == 1) {
                countTotal++;
            }
        }
        System.out.println("Se registraron " + countTotal + " dias en los cuales hubo sismos de intensidad mayores o iguales a 5.5.");
    }

    //Qué día de la semana, en promedio, la actividad sísmica es más intensa?
    public static void diaMasIntenso(double[][] sismos) {
        int dia = 0;
        double intensidadDia = 0;
        for (int i = 0; i < sismos.length; i++) {
            double intensidadDiaTemp = 0;
            for (int j = 0; j < 24; j++) {
                intensidadDiaTemp += sismos[i][j];
            }
            if (intensidadDiaTemp > intensidadDia) {
                intensidadDia = intensidadDiaTemp;
                dia = i;
            }
        }
        System.out.println("El dia mas intenso sismicamente fue el dia " + dia + ".");
    }
}