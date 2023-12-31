package entidades;

public class Ejemplar {
    private int codigo;
    private Libro libro;
    private String estado;
    
    public Ejemplar(){}

    public Ejemplar(int codigo, Libro libro, String estado) {
        this.codigo = codigo;
        this.libro = libro;
        this.estado = estado;
    }
    

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
