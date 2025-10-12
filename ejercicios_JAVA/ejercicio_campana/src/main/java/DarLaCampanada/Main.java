package DarLaCampanada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
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
        boolean validacionDatos;
        boolean error;

        //Pedimos al usuario que nos rellene las primeras 4 variables
        /*
        System.out.println("Ingrese la hora de inicio:");
        horaInicio = scn.nextInt();
        System.out.println("Ingrese los minutos de inicio:");
        minutoInicio = scn.nextInt();
        System.out.println("Ingrese la hora de fin:");
        horaFin = scn.nextInt();
        System.out.println("Ingrese los minutos de fin:");
        minutoFin = scn.nextInt();

        Esta parte es creada antes de realizar el bucle, para un mejor funcionamiento lo correcto es pedir y validar
        datos dentro del bucle, por eso se comenta y se procede a meter dentro del bucle*/

        //Controlamos las entradas para verificar que esten correctas

        //Update 11:50h. Implementar Try-Catch
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

            // Si todos los bucles se cumple bien, pasamos a comprobar que las horas pertenezcan al mismo dia
            minMediNoInicio = (horaInicio * 60) + minutoInicio;
            minMediNoFin = (horaFin * 60) + minutoFin;
            validacionDatos = (minMediNoInicio >= minMediNoFin);
            if (validacionDatos) {
                System.out.println("ERROR. Los datos de fin deben ser mayores que los datos de inicio.");
            }
        } while (validacionDatos);

        //Realizamos el cambio de las variables ingresadas a minutos para tener mayor facilidad de control
        /*Este control tambien estaba en principio fuera del bucle, se procede a controlar dentro del bucle para
        probar que las horas ingresadas pertenezcan al mismo dia

        minMediNoInicio = (horaInicio * 60) + minutoInicio;
        minMediNoFin = (horaFin * 60) + minutoFin;
         */

        //Esto nos permitetener un control y realizar un bucle sin problema

        //Realizamos un bucle FOR para contar cuantas veces suena la campana
        for (int i = minMediNoInicio; i <= minMediNoFin; i++) {
            //Este bucle recoore cada minuto, incluyendo los minutos de inicio
            //Necesitamos una variable dentro para saber en que minuto estamos

            int multiplos = i % 60;

            //Comprobamos si el minuto actual es una campanada (0,15,30,45)

            if (multiplos % 15 == 0) {
                campanas++;
            }
        }

        //Mostramos el total de veces que ha sonado la campana
        System.out.println("La campana suena un total de: " + campanas + " veces.");


    }//Main
}//Class
