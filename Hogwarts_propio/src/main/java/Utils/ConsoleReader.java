package Utils;

//CLase con metodos para controlar si existen o no los datos solicitados

import Models.House;
import Models.Wand;
import Models.Wizard;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    //Metodo para crear un objeto completo Hoouse
    public static House readHouse(Scanner scn){
        String name = EnterVerify.readString(scn, "Ingrese el nombre de la casa:");
        String founder = EnterVerify.readString(scn, "Ingrese el nombre del fundador:");
        return new House(name, founder);
    }

    //Metodo para crear un objeto completo Wand
    public static Wand readWand(Scanner scn){
        String wood = EnterVerify.readString(scn, "Ingrese el tipo de madera de la varita:");
        String core = EnterVerify.readString(scn, "Ingrese el nucleo de la varita:");
        Double length = EnterVerify.readDouble(scn, "Ingrese la longitud de la varita:");
        return new Wand(wood, core, length);
    }

    //Metodo para crear un objeto completo Wizard
    public static Wizard readWizard(Scanner scn, List<House> houses, List<Wand> wands){
        String name = EnterVerify.readString(scn, "Ingrese el nombre del mago:");
        int age = EnterVerify.readInt(scn, "Ingrese la edad del mago:");
        int houseId = readExistHouseId(scn, houses);
        int wantId = readExistingWandId(scn, wands);
        return new Wizard(name, age, houseId, wantId);

    }

    //Metodo para verificar ID de House
    public static int readExistHouseId(Scanner scn, List<House> houses){
        while(true){
            System.out.println("Casas disponibles: ");
            for(House h : houses){
                System.out.printf("%d - %s\n", h.getId(), h.getName());
            }
            int id = EnterVerify.readInt(scn, "Ingrese el ID de la casa: ");
            /*
            ESto se llama STREAM y es lo mismo que el for.
            boolean exist = houses.stream().anyMatch(h -> h.getId() == id);
             */
            boolean exist = false;
            for(House h : houses){
                if(h.getId() == id){
                    exist = true;
                    break;
                }
            }
            if(exist){
                return id;
            }else{
            System.out.println("⚠️El ID ingresado no existe.");
            }
        }
    }

    //Metodo para verificar ID de Wand
    public static int readExistingWandId(Scanner scn, List<Wand> wands) {
        while(true){
            System.out.println("Varitas disponibles:");
            for(Wand w : wands){
                System.out.printf("%d - %s (%s) %.1f\n", w.getId(), w.getWood(), w.getCore(), w.getLength());
            }
            int id = EnterVerify.readInt(scn, "Ingrese el ID de la varita:");
            boolean exist = wands.stream().anyMatch(w -> w.getId() == id);
            if(exist){
                return id;
            }else{
            System.out.println("⚠️ Error: El ID ingresado no existe");
            }
        }
    }

    //Metodo para verificar ID de mago
    public static int readExistingWizardId(Scanner scn, List<Wizard> wizards, List<House> houses, List<Wand> wands){
        while (true){
            System.out.println("Magos disponibles:");
            for(Wizard w : wizards){
                String houseName = FinderUtils.getHouseNameById(w.getHouseId(), houses);
                String wandWood = FinderUtils.getWandWoodById(w.getWandId(), wands);
                System.out.printf("%d - %s (Edad: %d, Casa: %s, Varita: %s)%n", w.getId(), w.getName(), w.getAge(), houseName, wandWood);            }
            int id = EnterVerify.readInt(scn, "Ingrese el ID del mago:");
            boolean exist = wizards.stream().anyMatch(w -> w.getId() == id);
            if(exist){
                return id;
            }
            System.out.println("⚠️ Error: El ID ingresado no existe");
        }
    }



}//ConsoleReader
