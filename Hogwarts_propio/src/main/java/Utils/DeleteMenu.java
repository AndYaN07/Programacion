//Creacion de menu para eliminacion

package Utils;

import Models.*;

import java.util.List;
import java.util.Scanner;

public class DeleteMenu {

    public static void show (Scanner scn, HouseDAO houseDAO, WandDAO wandDAO, WizardDAO wizardDAO){

        int tipe;

        do{
        List<House> houses = houseDAO.getALL();
        List<Wand> wands = wandDAO.getALL();
        List<Wizard> wizards = wizardDAO.getAll();

        System.out.println("\n=====ELIMINAR=====");
        System.out.println("1. Casa");
        System.out.println("2. Varita");
        System.out.println("3. Mago");
        System.out.println("4. Volver atras");
        System.out.println("***** NO SE PUEDEN ELIMINAR CASAS O VARITAS CON MAGOS ASOCIADOS!! *****");

        tipe = EnterVerify.readInt(scn, "Seleccione una opcion:");

        switch (tipe){
            case 1: //Eliminacion de casa
                if(houses.isEmpty()){
                    System.out.println("⚠️ No hay casas para eliminar");
                    break;
                }
                int houseId = ConsoleReader.readExistHouseId(scn, houses);
                House house = houses.stream().filter(h ->h.getId() == houseId).findFirst().orElse(null);
                if(house != null){
                    String confirm = EnterVerify.valSorN(scn, "⚠️ Esta apunto de eliminar la casa: " +house.getName() + ". Desea continuar? (S/N): ");
                    if(confirm.equalsIgnoreCase("S")){
                        houseDAO.delete(houseId);
                    }
                }else{
                    System.out.println("ELIMINACION CANCELADA");
                }
                break;
            case 2: // Eliminacion de varita
                if (wands.isEmpty()){
                    System.out.println("⚠️ No hay varitas para eliminar");
                    break;
                }
                int wandId = ConsoleReader.readExistingWandId(scn, wands);
                Wand wand = wands.stream().filter(w -> w.getId() == wandId).findFirst().orElse(null);
                if(wand != null) {
                    String confirm = EnterVerify.valSorN(scn, "⚠️ Esta apunto de eliminar la varita: " + wand.getId() + ". Desea continuar? (S/N): ");
                    if (confirm.equalsIgnoreCase("S")) {
                        wandDAO.delete(wandId);
                    }
                }else{
                    System.out.println("ELIMINACION CANCELADA")
                }
                break;
            case 3: //Eliminacion de mago
                if (wizards.isEmpty()){
                    System.out.println("⚠️ No hay magos para eliminar");
                    return;
                }
                int wizardId = ConsoleReader.readExistingWizardId(scn, wizards, houses, wands);
                wizardDAO.delete(wizardId);
                break;
            case 4:
                System.out.println("↩️ Volviendo al menú anterior...");
                return;
            default:
                System.out.println("⚠️ Opcion no valida");
        }
    }//show


}//DeleteMenu
