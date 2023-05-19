/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class Tabla {
       private String titulo;
    private DefaultTableModel modeloTabla;
    public Tabla(){
    }
    /**
     * constructor de tabla
     * @param titulo nombre de la tabla
     * @param modeloTabla  modelo de la tabla
     */
    public Tabla(String titulo,DefaultTableModel modeloTabla ){
        this.titulo = titulo;
        this.modeloTabla = modeloTabla;
    }
    /**
     * obtiene el titulo
     * @return regresa el titulo de la tabla
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * establade el titulo de la tabla
     * @param titulo nombre de la tabla
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * obtiene el modelo de la tabla
     * @return regresa el modelo de la tabla
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    /**
     * establece el modelo de la tabla
     * @param modeloTabla modelo de la tabla
     */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
    
}
