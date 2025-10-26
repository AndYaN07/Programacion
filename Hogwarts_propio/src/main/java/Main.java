//Main para hacer el ejercicio mas interactivo

import Models.*;
import Utils.ConsoleReader;
import Utils.DeleteMenu;
import Utils.EnterVerify;
import Utils.UpdateMenu;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        HouseDAO houseDAO = new HouseDAO();
        WandDAO wandDAO = new WandDAO();
        WizardDAO wizardDAO = new WizardDAO();
        List<House> houses;
        List<Wand> wands;
        List<Wizard> wizards;
        int option;

        //Creacion el menu necesario
        do{
            System.out.println("\n=====MENU PRINCIPAL=====");
            System.out.println("1. Crear casa 🏠");
            System.out.println("2. Crear varita 🪄");
            System.out.println("3. Crear Mago 🧙‍♂️");
            System.out.println("4. Mostrar datos guardados 🔓");
            System.out.println("5. Eliminar casa/varita/mago ☢️");
            System.out.println("6. Actualizar casa/varita/mago 🖌️");
            System.out.println("0. Salir 🫂");

            option = EnterVerify.readInt(scn, "Seleccione una opcion:");

            switch (option){
                case 1:
                    //Crear casa
                    House house = ConsoleReader.readHouse(scn);
                    houseDAO.create(house);
                    System.out.println("☑️ Casa creada: " + house);
                    break;
                case 2:
                    //Crear Varita
                    Wand wand = ConsoleReader.readWand(scn);
                    wandDAO.create(wand);
                    System.out.println("☑️ Varita creada: " + wand);
                    break;
                case 3:
                    //Crear mago
                    houses = houseDAO.getALL(); //Listamos todas las casas que hay hasta el momento
                    wands = wandDAO.getALL(); //Listamos todas las varitas que hay hasta el momento
                    // Se listan las casas y varitas para dar a escoger a donde asignar el mago.

                    Wizard wizard = ConsoleReader.readWizard(scn, houses, wands);
                    wizardDAO.create(wizard);
                    System.out.println("☑️ Mago creado: " + wizard);
                    break;
                case 4:
                    //Listar datos
                    houses = houseDAO.getALL();
                    System.out.println("🏠 Casas:");
                    houses.forEach(System.out::println);
                    wands = wandDAO.getALL();
                    System.out.println("\n🪄 Varitas:");
                    wands.forEach(System.out::println);
                    wizards = wizardDAO.getAll();
                    System.out.println("\n🧙 Magos:");
                    wizards.forEach(System.out::println);
                    break;
                case 5:
                    //Eliminar datos
                    DeleteMenu.show(scn, houseDAO, wandDAO, wizardDAO);
                    break;
                case 6:
                    //Actializar datos
                    UpdateMenu.show(scn, houseDAO, wandDAO,wizardDAO);
                    break;
                case 0:
                    System.out.println("Hasta pronto! 😊");
                    scn.close();
                    break;
                default:
                    System.out.println("⚠️ Opcion no valida");
            }
        }while (option != 0);







    }//Main


}//Class
