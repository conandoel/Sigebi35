package entidades;

import java.time.LocalDate;

public class Socio {
    private int idSocio;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String mail;
    private LocalDate fechaDeAlta;
    private LocalDate fechaDeBaja;
    private boolean estado;
    
    public Socio(){}

    public Socio(int idSocio, String apellido, String nombre, LocalDate fechaDeAlta, String domicilio, String mail, boolean estado) {
        this.idSocio = idSocio;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.fechaDeAlta = fechaDeAlta;
        this.estado = estado;
    }

    public int getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }
    
    
    public void activarLector(Socio l){
        
    }
    
    public void desactivarLector(Socio l){
        
    }
    
}
