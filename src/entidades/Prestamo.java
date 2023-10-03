package entidades;

import java.util.Date;

public class Prestamo {
    private Date fechaInicio;
    private Date fechaFin;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;
    
    public Prestamo(){};

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }
    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }
    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void solicitarLibro(Ejemplar e, Lector l){
        
    }
    
    public void devolverLibro(Ejemplar e, Lector l){
        
    }
}
