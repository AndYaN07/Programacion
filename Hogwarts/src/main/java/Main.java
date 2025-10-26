import Models.*;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args){

        //Instanciamos las clases para BBDD

        HouseDAO houseDAO = new HouseDAO();
        WandDAO wandDAO = new WandDAO();
        WizardDAO wizardDAO = new WizardDAO();


        //Creacion de casas

        House gryffindor = new House("Gryffindor", "Godric Gryffindor");
        House slytherin = new House("Slytherin", "Salazar Slytherin");
        House huffelpuff = new House("Huffelpuff", "Helga Huffelpuff");
        House ravenclaw = new House("Ravenclaw", "Rowenna Ravenclaw");


        //Esto crearia las casas en BBDD

        houseDAO.create(gryffindor);
        houseDAO.create(slytherin);
        houseDAO.create(ravenclaw);
        houseDAO.create(huffelpuff);

        List<House> houses = houseDAO.getALL(); //Lista con los datos de las casas en la BBDD

        //Creacion de Varitas

        Wand wand1 = new Wand("Acebo","Pluma de fénix",28.0); //Harry
        Wand wand2 = new Wand("Espino", "Pelo de unicornio", 23.0); //Draco
        Wand wand3 = new Wand("Vid", "Corazón de dragón", 25.4); //Hermione
        Wand wand4 = new Wand("Sauce", "Pelo de unicornio", 25.4); //Ronald

        //Creacion de las Varitas en BBDD

        wandDAO.create(wand1);
        wandDAO.create(wand2);
        wandDAO.create(wand3);
        wandDAO.create(wand4);

        List<Wand> wands = wandDAO.getALL(); //Lista con los datos de las varitas en la BBDD

        //Creacion de magos

        Wizard harry = new Wizard("Harry Potter", 17, gryffindor.getId(), wand1.getId());
        Wizard ron = new Wizard("Ronald Weasley", 17, gryffindor.getId(), wand4.getId());
        Wizard hermione = new Wizard("Hermione Granger", 17, gryffindor.getId(), wand3.getId());
        Wizard draco = new Wizard("Draco Malfoy", 17, slytherin.getId(), wand2.getId());

        //Antes de crear los magos necesitamos obtener los ID de las casas y varitas para asignarlos



        //Creacion de magos en BBDD

        wizardDAO.create(harry);
        wizardDAO.create(ron);
        wizardDAO.create(hermione);
        wizardDAO.create(draco);

        List<Wizard> wizards = wizardDAO.getAll(); //Lista con los datos de los magos en la BBDD

        //Esto mostraria todas las casas que tenemos en BBDD

        houses.forEach(System.out :: println);

        //La convencion seria hacerla con forEach asi:
        /*for(House h : houses){
            System.out.prinln(h.toString)}*/

        //Mostrar todas las varitas que tenemos en BBDD

        wands.forEach(System.out :: println);

        //Mostramos todos los magos que tenemos en BBDD


        wizards.forEach(System.out :: println);



/*
        System.out.println(gryffindor.toString());
        System.out.println(slytherin.toString());
        System.out.println(huffelpuff.toString());
        System.out.println(ravenclaw.toString());

        System.out.println(wand1.toString());
        System.out.println(wand2.toString());
        System.out.println(wand3.toString());
        System.out.println(wand4.toString());

        System.out.println(harry.toString());
        System.out.println(ron.toString());
        System.out.println(hermione.toString());
        System.out.println(draco.toString());


         */

























    }//Main


}//Class
