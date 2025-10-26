//Utils para verificacion de entrada de datos

package Utils;

import java.util.Scanner;

public class EnterVerify {

    //Funcion para verificar la entrada de enteros
    public static int readInt(Scanner scn, String msg) {
        while (true) {
            System.out.println(msg);
            String entrada = scn.nextLine();
            try {
                int num = Integer.parseInt(entrada);
                if(num >=0){
                    return num;
                }
                else{
                    System.out.println("⚠️Error: Debe ser mayor o igual que 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️Error: Debe ingresar un numero entero");
            }
        }
    }

    //Funcion para verificar entrada de decimales
    public static double readDouble(Scanner scn, String msg) {
        while (true) {
            System.out.println(msg);
            String entrada = scn.nextLine();
            try {
                double num = Double.parseDouble(entrada);
                if(num>=0){
                    return num;
                }
                else{
                    System.out.println("⚠️Error: Debe ser mayor o igual que 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️Error: Debe ingresar un numero decimal");
            }
        }
    }

    //Funcion para verificar entrada de minimo dos caracteres
    public static String readString(Scanner scn, String msg) {
        while (true) {
            System.out.println(msg);
            String entrada = scn.nextLine().trim();
            if (entrada.length() >= 2) {
                return entrada;
            }
            System.out.println("⚠️Error: Debe ingresar al menos dos caracteres");
        }
    }

    public static String valSorN(Scanner scn, String msg){
        while (true){
            System.out.println(msg);
            String entrada = scn.nextLine().trim();
            if(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")){
                return entrada;
            }
            else{
                System.out.println("⚠️Error: Debe ingresas S para SI y N para NO.");
            }
        }
    }




}//Utils
