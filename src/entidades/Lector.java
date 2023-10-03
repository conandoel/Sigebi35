package entidades;

public class Lector {
    private int idSocio;
    private String nombre;
    private String apellido;
    private Object domicilio;
    private String mail;
    private boolean estado;
    
    public Lector(){}

    public Lector(int idSocio, String nombre, String apellido, Object domicilio, String mail, boolean estado) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    public int getIdSocio() {
        return idSocio;
    }
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(Object domicilio) {
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
    
    public void activarLector(Lector l){
        
    }
    
    public void desactivarLector(Lector l){
        
    }
    
}
