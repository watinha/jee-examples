package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class FrutaUI implements Serializable {

    private List <String> lista;

    public FrutaUI () {
        this.lista = new ArrayList <String> ();
        this.lista.add("abobrinha");
        this.lista.add("pepino");
        this.lista.add("abacate");
    }

    public List <String> getLista () {
        return this.lista;
    }

}
