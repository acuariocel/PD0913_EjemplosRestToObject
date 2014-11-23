
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INTERNET2
 */
public class FuncionesAuto {
    public Autos jsonToObject(String formatoJSON) {
        if ((formatoJSON + "").equals("null")) {
            return null;
        }
        if (formatoJSON.equals("false")) {
            return null;
        }
        Gson gson = new Gson();
        Type tipoObjeto = new TypeToken<Autos>() {
        }.getType();
        Autos auto = gson.fromJson(formatoJSON, tipoObjeto);
        return auto;
    }
}
