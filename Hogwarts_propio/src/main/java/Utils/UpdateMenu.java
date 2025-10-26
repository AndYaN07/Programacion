//Creacion de menu para actualizar datos
package Utils;

import Models.*;

import java.util.List;
import java.util.Scanner;

public class UpdateMenu {

    public static void show(Scanner scn, HouseDAO houseDAO, WandDAO wandDAO, WizardDAO wizardDAO){
        int option;

        System.out.println("\n=====ACTUALIZAR=====");
        System.out.println("1. Casa");
        System.out.println("2. Varita");
        System.out.println("3. Mago");
        System.out.println("4. Volver atras");

        option = EnterVerify.readInt(scn, "Seleccione una opcion:");

        switch (option){
            case 1: // Update casa
                updateHouse(scn, houseDAO);
                break;
            case 2: // Update varita
                updateWand(scn, wandDAO);
                break;
            case 3 : // Update mago
                updateWizard(scn, wizardDAO, houseDAO, wandDAO);
                break;
            case 4:
                System.out.println("↩️ Volviendo al menú anterior...");
                return;
            default:
                System.out.println("⚠️ Opcion no valida");
        }
    }

    //Métodos privados para actualizar cada entidad

    //Metodo que actualiza las casas
    private static void updateHouse(Scanner scn, HouseDAO houseDAO) {
        List<House> houses = houseDAO.getALL();
        if (houses.isEmpty()) {
            System.out.println("⚠️ No hay casas para actualizar.");
            return;
        }

        int houseId = ConsoleReader.readExistHouseId(scn, houses);
        House updatedHouse = ConsoleReader.readHouse(scn);
        updatedHouse.setId(houseId);

        houseDAO.update(updatedHouse);
    }

    //Metodo que actualiza las varitas
    private static void updateWand(Scanner scn, WandDAO wandDAO) {
        List<Wand> wands = wandDAO.getALL();
        if (wands.isEmpty()) {
            System.out.println("⚠️ No hay varitas para actualizar.");
            return;
        }

        int wandId = ConsoleReader.readExistingWandId(scn, wands);
        Wand updatedWand = ConsoleReader.readWand(scn);
        updatedWand.setId(wandId);

        wandDAO.update(updatedWand);
    }

    //Metodo que actualiza los magos
    private static void updateWizard(Scanner scn, WizardDAO wizardDAO, HouseDAO houseDAO, WandDAO wandDAO) {
        List<Wizard> wizards = wizardDAO.getAll();
        if (wizards.isEmpty()) {
            System.out.println("⚠️ No hay magos para actualizar.");
            return;
        }

        List<House> houses = houseDAO.getALL();
        List<Wand> wands = wandDAO.getALL();

        int wizardId = ConsoleReader.readExistingWizardId(scn, wizards, houses, wands);
        Wizard updatedWizard = ConsoleReader.readWizard(scn, houses, wands);
        updatedWizard.setId(wizardId);

        wizardDAO.update(updatedWizard);
    }

}


//



