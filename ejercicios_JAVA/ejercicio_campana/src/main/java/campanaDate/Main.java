package campanaDate;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*En este ejercicio realizare la refactorizacion del codigo del ejercicio de la campana,
    utilizando para ello segun lo aprendido de manera autodidacta del "LocalTime" con "java.time.LocalTime"*/

    public static void main(String[] args) {

        //Necesitamos Scanner para pedir datos al usuario
        Scanner scn = new Scanner(System.in);

        //Creamos 4 variables para guardar los tiempos
        int horaInicio = 0;
        int horaFin = 0;
        int minutoInicio = 0;
        int minutoFin = 0;
        int minMediNoInicio = 0;
        int minMediNoFin = 0;
        int campanas = 0;
        boolean validacionDatos = false;
        boolean error;
        LocalTime inicio, fin;

        do {
            //Valiamos hora de entrada
            do {
                //Realizamos bucle de verificacion de entrada de datos para verificar que se ingrese un numero
                boolean esNumero = false;
                while (!esNumero) {
                    try {
                        System.out.println("Ingrese la hora de inicio:");
                        horaInicio = scn.nextInt();
                        esNumero = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR. Solo se admiten numeros enteros. Intente de nuevo.");
                        scn.nextLine();
                        esNumero = false;
                    }
                }//While de validacion esNumero
                error = (horaInicio < 0 || horaInicio > 23);
                if (error) {
                    System.out.println("Debe ingresar una hora de inicio valida. (0-23).");
                }
            } while (error);

            //Validamos los minutos de entrada
            do {
                //Implementamos misma logica de try-catch
                boolean esNumero = false;
                while (!esNumero) {
                    try {
                        System.out.println("Ingrese los minutos de inicio:");
                        minutoInicio = scn.nextInt();
                        esNumero = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR. Solo se admiten numeros enteros. Intente de nuevo.");
                        scn.nextLine();
                        esNumero = false;
                    }
                }//While de validacion esNumero
                error = (minutoInicio < 0 || minutoInicio > 59);
                if (error) {
                    System.out.println("ERROR. Debe ingresar los minutos de inicio validos. (0-59).");
                }
            } while (error);

            //Validamos hora de fin
            do {
                //Implementamos misma logica de try-catch
                boolean esNumero = false;
                while (!esNumero) {
                    try {
                        System.out.println("Ingrese la hora de fin:");
                        horaFin = scn.nextInt();
                        esNumero = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR. Solo se admiten numeros enteros. Intente de nuevo.");
                        scn.nextLine();
                        esNumero = false;
                    }
                }//While de validacion esNumero
                error = (horaFin < 0 || horaFin > 23);
                if (error) {
                    System.out.println("ERROR. Debe ingresar una hora de fin valida. (0-23).");
                }
            } while (error);

            //Validamos minutos de fin
            do {
                //Implementamos misma logica de try-catch
                boolean esNumero = false;
                while (!esNumero) {
                    try {
                        System.out.println("Ingrese los minutos de fin:");
                        minutoFin = scn.nextInt();
                        esNumero = true;
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR. Solo se admiten numeros enteros. Intente de nuevo.");
                        scn.nextLine();
                        esNumero = false;
                    }
                }//While de validacion esNumero
                error = (minutoFin < 0 || minutoFin > 59);
                if (error) {
                    System.out.println("ERROR. Debe ingresar los minutos de fin validos. (0-59).");
                }
            } while (error);

            //Refactorizacion de cogido aplicando el LocalTime
            inicio = LocalTime.of(horaInicio, minutoInicio);
            fin = LocalTime.of(horaFin, minutoFin);

            if (inicio.compareTo(fin) >= 0) {
                System.out.println("ERROR. La hora de inicio debe ser menor que la hora de fin.");
                validacionDatos = true;
            } else{
                validacionDatos = false;
            }
        } while (validacionDatos);

        LocalTime tiempoAct = inicio;

        while (tiempoAct.compareTo(fin) <= 0) {
            int minutoAct = tiempoAct.getMinute();

            if (minutoAct % 15 == 0) {
                campanas++;
            }
            tiempoAct = tiempoAct.plusMinutes(1);
        }

        //Mostramos el total de veces que ha sonado la campana
        System.out.println("La campana suena un total de: " + campanas + " veces.");


    }//Main
}//Class

