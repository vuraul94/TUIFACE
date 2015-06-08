/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import Modelo.Usuario;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author raul
 */
public class RegistroUsuario {

    private Document documento;
    private Element raiz;
    private String rutaDocumento;

    public RegistroUsuario(String rutaDocumento, String nombreRaiz) throws IOException {
        this.documento = new Document(this.raiz);
        this.raiz = new Element(nombreRaiz);
        this.rutaDocumento = rutaDocumento;
        this.guardar();
    }

    public RegistroUsuario(String rutaDocumento) throws JDOMException, IOException {
        SAXBuilder saBuilder = new SAXBuilder();
        saBuilder.setIgnoringElementContentWhitespace(true);
        //parseo
        this.documento = saBuilder.build(rutaDocumento);
        this.raiz = documento.getRootElement();
        this.rutaDocumento = rutaDocumento;
    }

    
    public static RegistroUsuario crearDocumento(String nombreDocumento) throws IOException {
        return new RegistroUsuario(nombreDocumento, "usuarios");
    }

    public static RegistroUsuario abrirDocumento(String nombreDocumento) throws JDOMException, IOException {
        return new RegistroUsuario(nombreDocumento);
    }

    public void guardar() throws IOException {
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(documento, System.out);//imprime en consola
        xMLOutputter.output(documento, new PrintWriter(this.rutaDocumento));
    }

    public void agregarUsuario(Usuario usuario) throws IOException {
        Element eUsuario =new Element("usuario");
        Element eNickname = new Element("nickname");
        Element eNombre = new Element("nombre");
        Element ePassword = new Element("password");

        eNickname.addContent(usuario.getNickname());
        ePassword.addContent(usuario.getPassword());

        eUsuario.addContent(eNickname);
        eUsuario.addContent(eNombre);
        eUsuario.addContent(ePassword);
        this.raiz.addContent(eUsuario);
        this.guardar();

    }

    public void eliminarUsuario(Element elementoEliminar) throws IOException {
        this.raiz.removeContent(elementoEliminar);
        this.guardar();
    }

    public ArrayList<Usuario> getUsuarios() {
        List<Element> listaElement = (List<Element>) this.raiz.getChildren();

        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();

        for (Element listaElement1 : listaElement) {
            listaUsuario.add(new Usuario(
                    listaElement1.getChildText("nickname"),
                    listaElement1.getChildText("password")));
        }
        return listaUsuario;
    }
    
    public boolean verificarLogin(String nickname, String password){
         List<Element> listaElement = (List<Element>) this.raiz.getChildren();
         for (Element listaElement1 : listaElement) {
             if(listaElement1.getChildText("nickname").equals(nickname)){
                 if(listaElement1.getChildText("password").equals(password)){
                     return true;
                 }
             }
        }
        return false;
    }
    
}
