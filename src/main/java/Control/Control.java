/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import GUIs.DlgHabitat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.Habitad;
import persistencia.Persistencia;
import Control.Conversiones;
/**
 *
 * @author jorge
 */
public class Control {
    Persistencia persistencia ;
     Conversiones conversiones;
    
     public Control() {
// Crea un objeto del tipo persistencia
        persistencia = new Persistencia();
        conversiones = new Conversiones();
    }
    
     public void agregarHabitat(JFrame frame) throws Exception {
        Habitad habitad, bHabitad = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgHabitat dlgHabitat;

        String nombreHabitad = JOptionPane.showInputDialog(frame, "Nombre de habitat ", "Agregar habitat", JOptionPane.QUESTION_MESSAGE);
// Si el usuario presiono el boton Cancelar
        if (nombreHabitad == null) {

            throw new Exception("Cancelado");
        }
// Crea un objeto libro con solo la clave
        if (nombreHabitad.isEmpty()) {
            throw new Exception("Espacio vacio, cancelado");
        }
        habitad = new Habitad(nombreHabitad);
        try {
// Obten el libro del catalogo de libros
            bHabitad = persistencia.obten(habitad);
        } catch (Exception e) {
// Si ocurrio un error al leer del catalogo de libros,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.", JOptionPane.ERROR_MESSAGE);
        }

        if (bHabitad != null) {
            dlgHabitat = new DlgHabitat(frame, true);

        }
// Si el libro no existe captura los datos del nuevo libro
        dlgHabitat = new DlgHabitat(frame, true);

// Agrega el nuevo libro al catalogo de libros
        try {
            persistencia.actualizar(habitad);
        } catch (Exception e) {
// Si ocurrio un error al escribir al catalogo de libros,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    
     
     
    public Tabla getTablaLibros(JFrame frame) {
        List<Habitad> listaHabitats;
        try {
// Obtiene la lista de libros
            listaHabitats = persistencia.consultarHabitats();
        } catch (Exception e) {
// Si ocurrio un error al obtener la lista de la base de datos,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.", JOptionPane.ERROR_MESSAGE);
            return null;
        }
// Regresa el objeto Tabla con todos los libros
        return new Tabla("", conversiones.HabitadTableModel(listaHabitats));
    }
    
    
    
    
    
    public void actualizarLibro(JFrame frame) {

        Habitad habitad;
        StringBuffer respuesta = new StringBuffer("");
        DlgHabitat dlgHabitat;
        List<Habitad> listaHabitats;
// Captura el isbn del libro
        String nombreHabitat = JOptionPane.showInputDialog(frame, "Nombre del habitat: ",
                "Actualizar habitat",
                JOptionPane.QUESTION_MESSAGE);
// Si el usuario presiono el boton Cancelar
        if (nombreHabitat == null) {
        }
// Crea un objeto libro con solo el isbn
        habitad = new Habitad(nombreHabitat);
        try {
// Obten el libro del catalogo de libros
            habitad = persistencia.obten(habitad);
        } catch (Exception e) {
// Si ocurrio un error al leer del catalogo de libros,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
        }
// Si la el libro no existe, despliega un mensaje de error
        if (habitad == null) {
            JOptionPane.showMessageDialog(frame,
                    "El libro no existe", "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
        }
        try {

            listaHabitats = persistencia.consultarHabitats();
        } catch (Exception e) {
// Si ocurrio un error al obtener la lista de la base de datos,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
        }

      
// Actualiza el libro del catalogo de libros
        try {
            persistencia.actualizar(habitad);
        } catch (Exception e) {
// Si ocurrio un error al escribir al catalogo de libros,
// despliega mensaje de error
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error!!.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
