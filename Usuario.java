/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasdemetodosyestructuras;

/**
 *
 * @author Walter
 */
public class Usuario {
    private String usuario;
    private String mail;
    private String contrasena;

    public Usuario(String usuario, String mail, String contrasena) {
        this.usuario = usuario;
        this.mail = mail;
        this.contrasena = contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMail() {
        return mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Usuario() {
    }
    
    public String toString(){
    String aux;
        if (this==null) {
            aux="INEXISTENTE";
        }else{
        aux="Usuario: "+this.usuario+ " Mail: "+this.mail+ " Contraseña: "+this.contrasena;
        }
        return aux;
    }
    
}
