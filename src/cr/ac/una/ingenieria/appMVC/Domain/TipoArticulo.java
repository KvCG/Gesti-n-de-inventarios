
package cr.ac.una.ingenieria.appMVC.Domain;

/**
 *
 * @author Michael
 */
public class TipoArticulo {
    private int codigo;
    private String descripcion;
    private boolean estado;

    public TipoArticulo() {}
    
    public TipoArticulo(int codigo, String descripcion,Boolean estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }    
}
