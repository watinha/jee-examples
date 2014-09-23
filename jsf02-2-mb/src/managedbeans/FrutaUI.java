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
    private String novaFruta = "";

    public String getNovaFruta () { return this.novaFruta; }
    public void setNovaFruta (String novaFruta) { this.novaFruta = novaFruta; }

    public FrutaUI () {
        this.lista = new ArrayList <String> ();
    }

    public void add () {
        this.lista.add(this.novaFruta);
        this.novaFruta = "";
    }

    public List <String> getLista () {
        return this.lista;
    }

}
