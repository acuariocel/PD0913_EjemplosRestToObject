
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INTERNET2
 */
public class Funciones {
     /**
     *
     * @param url url para realizar la consulta
     * @return
     */
    public String obtienePorGet(String url) {
        String texto = "", linea;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            while ((linea = in.readLine()) != null) {
                texto += linea;
            }
        } catch (Exception ex) {
            texto = ex + "";
        }
        return texto;
    }
}
