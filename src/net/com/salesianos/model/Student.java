package net.com.salesianos.model;

public class Student {
    private String id;
    private String nombre;
    private String apellidos;
    private int añoNacimiento;
    private String centro;

    public Student() {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.añoNacimiento = añoNacimiento;
        this.centro = centro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellidos + " (" + añoNacimiento + ") - " + centro;

    }

}
