
package cr.ac.una.ingenieria.appMVC.Domain;

public class Bodega {
    private int IdBodega;
    private String Tipo;
    private String Nombre;
    private Boolean Estado;
    

    public Bodega() {}
    
    public Bodega(int IdBodega, String Tipo,String Nombre,Boolean Estado) {
        this.IdBodega = IdBodega;
        this.Tipo = Tipo;
        this.Nombre = Nombre;
        this.Estado = Estado;
    }
//---------------------get's----------------------
    public int getIdBodega() {
        return IdBodega;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public Boolean getEstado() {
        return Estado;
    }
    //---------------------Set's----------------------
    public void setIdBodega(int IdBodega) {
        this.IdBodega = IdBodega;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
}
