package co.edu.sena.jonathan.jsonexample578464;

/**
 * Created by Jonathan on 24/02/2015.
 */
public class Producto {

    private String codigo;
    private String nombre;
    private String precio;
    private String imagen;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String precio, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
