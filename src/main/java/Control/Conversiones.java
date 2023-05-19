/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import negocio.*;

/**
 *
 * @author jesus
 */
public class Conversiones {

    String columnaTablaHabitat[] = {"Nombre", "Clima", "Vegetacion", "Continente"};
    String columnaTablaEspecie[] = {"Nombre Especie", "Nombre Cientifico", "Descripcion", "Habitad"};
    String columnaTablaQueja[] = {"Fecha de la queja", "Descripcion"};
    String columnaTablaItinerario[] = {"Duracion", "Longitud", "Numero de visitantes", "Zona"};

    public DefaultTableModel HabitadTableModel(List<Habitad> listaHabitads) {

        Object tabla[][] = null;
        if (listaHabitads != null) {
            tabla = new Object[listaHabitads.size()][4];
            for (int i = 0; i < listaHabitads.size(); i++) {
                
                Habitad habitad = listaHabitads.get(i);
                tabla[i][0] = habitad.getNombre();
                tabla[i][1] = habitad.getClima();
                tabla[i][2] = habitad.getTipoVegetacion();
                tabla[i][3] = habitad.getListaContinentes();

            }

            return new DefaultTableModel(tabla, columnaTablaHabitat);

        }

        return null;

    }

    public DefaultTableModel EspecieTableModel(List<Especie> listaEspecies) {

        Object tabla[][] = null;
        if (listaEspecies != null) {
            tabla = new Object[listaEspecies.size()][4];
            for (int i = 0; i < listaEspecies.size(); i++) {
                
                Especie especie = listaEspecies.get(i);
                tabla[i][0] = especie.getNombreEspanol();
                tabla[i][1] = especie.getNombreCientifico();
                tabla[i][2] = especie.getDescripcion();
                tabla[i][3] = especie.getCuidadorEspecie();

            }

            return new DefaultTableModel(tabla, columnaTablaEspecie);

        }

        return null;

    }

    public DefaultTableModel QuejaTableModel(List <Queja> listaQuejas) {

        Object tabla[][] = null;
        if (listaQuejas != null) {
            tabla = new Object[listaQuejas.size()][2];
            for (int i = 0; i < listaQuejas.size(); i++) {
                
                Queja queja = listaQuejas.get(i);
                tabla[i][0] = queja.getFechaQueja();
                tabla[i][1] = queja.getDescripcion();
                

            }

            return new DefaultTableModel(tabla, columnaTablaQueja);

        }

        return null;

    }
    public DefaultTableModel ItinerarioTableModel(List<Itinerario> listaItinerario) {

        Object tabla[][] = null;
        if (listaItinerario != null) {
            tabla = new Object[listaItinerario.size()][4];
            for (int i = 0; i < listaItinerario.size(); i++) {
                
                Itinerario especie = listaItinerario.get(i);
                tabla[i][0] = especie.getDuracion();
                tabla[i][1] = especie.getLongitud();
                tabla[i][2] = especie.getNumeroEspecies();
                tabla[i][3] = especie.getNumeroEspecies();
                tabla[i][4] = especie.getGuia();

            }

            return new DefaultTableModel(tabla, columnaTablaItinerario);

        }

        return null;

    }

}
