//Clase para asociar nombres a ID
package Utils;

import Models.House;
import Models.Wand;

import java.util.List;

public class FinderUtils {

    //Buscar el nombre de casa por ID
    public static String getHouseNameById(int id, List<House> houses){
        return houses.stream().filter(h -> h.getId() == id).map(House :: getName).findFirst().orElse("Sin Casa");
    }//HouseNameById

    //Buscar el nombre del fundador por ID
    public static String getFounderNameById(int id, List<House> houses){
        return houses.stream().filter(h -> h.getId() == id).map(House :: getFounder).findFirst().orElse("Desconocido");
    }

    //Buscar tipo de madera de la varita
    public static String getWandWoodById(int id, List<Wand> wands){
        return wands.stream().filter(w -> w.getId() == id).map(Wand :: getWood).findFirst().orElse("Sin varita");
    }

    //Buscar nucleo de la varita
    public static String getWandCoreById(int id, List<Wand>wands){
        return wands.stream().filter(w -> w.getId() == id).map(Wand :: getCore).findFirst().orElse("Desconocido");
    }

}//FinderUtils
