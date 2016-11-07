/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.ingenieria.appMVC.Domain;

/**
 *
 * @author Gustavo
 */
public class BaseDomain {
      private String ultUsuario;
        private String ultFecha;

    /**
     *
     */
    public BaseDomain() {
    }

    /**
     *
     * @param ultUsuario
     * @param ultFecha
     */
    public BaseDomain(String ultUsuario, String ultFecha) {
        this.ultUsuario = ultUsuario;
        this.ultFecha = ultFecha;
    }

    /**
     *
     * @return
     */
    public String getUltUsuario() {
        return ultUsuario;
    }

    /**
     *
     * @param ultUsuario
     */
    public void setUltUsuario(String ultUsuario) {
        this.ultUsuario = ultUsuario;
    }

    /**
     *
     * @return
     */
    public String getUltFecha() {
        return ultFecha;
    }

    /**
     *
     * @param ultFecha
     */
    public void setUltFecha(String ultFecha) {
        this.ultFecha = ultFecha;
    }
}
