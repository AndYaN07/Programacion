package vocabulario;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Variables
        String text1, text2;
        String[] palabras1, palabras2;
        List<String> list1, list2;
        Scanner scn = new Scanner(System.in);

        System.out.println("Ingrese un primer texto:");
        text1 = scn.nextLine();
        System.out.println("Ingrese segundo texto:");
        text2 = scn.nextLine();

        palabras1 = text1.split(" ");
        palabras2 = text2.split(" ");

        list1 = Arrays.asList(palabras1);
        list2 = Arrays.asList(palabras2);

        Set<String> conjnt1 = new HashSet<>(list1);
        Set<String> conjnt2 = new HashSet<>(list2);
        Set<String> comunes = new HashSet<>(conjnt1);

        comunes.retainAll(conjnt2);

        Set<String> ordenarTodo = new TreeSet<>();
        ordenarTodo.addAll(conjnt1);
        ordenarTodo.addAll(conjnt2);

        List<String> listaOrdenada = new ArrayList<>(ordenarTodo);

        System.out.println("===VOCABULARIO===");
        System.out.println("Las palabras unicas del texto 1 son: " + conjnt1);
        System.out.println("Las palabras unicas del texto 2 son : " + conjnt2);
        System.out.println("Las palabras en comun en ambos textos son: " + comunes);
        System.out.println("Todas las palabras ordenadas: " + listaOrdenada);


    }//Main

}//Class
