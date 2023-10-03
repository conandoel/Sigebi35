package entidades;

public class Autor {
    private String apellido;
    private String nombre;
    private String generoFav;
    
    public Autor(){}

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

    public String getGeneroFav() {
        return generoFav;
    }
    public void setGeneroFav(String generoFav) {
        this.generoFav = generoFav;
    }
    
    
}
