package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class FrutaUI implements Serializable {

    public List <String> search (String busca) {
        List <String> new_list = new ArrayList <String> ();
        for (String fruta : this.lista) {
            if (fruta.toUpperCase().startsWith(busca.toUpperCase()))
                new_list.add(fruta);
            if (new_list.size() > 10)
                break;
        }
        return new_list;
    }

    private List <String> lista;
    private String novaFruta = "";
    private String buscaFruta = "";

    public String getBuscaFruta () { return this.buscaFruta; }
    public void setBuscaFruta (String buscaFruta) { this.buscaFruta = buscaFruta; }

    public String getNovaFruta () { return this.novaFruta; }
    public void setNovaFruta (String novaFruta) { this.novaFruta = novaFruta; }

    public FrutaUI () {
        this.lista = new ArrayList <String> ();
        this.lista.add("Abacaxi");
        this.lista.add("Mamao");
        this.lista.add("Uva");
        this.lista.add("Melão");
        this.lista.add("Amendoim");
        this.lista.add("Limão");
        this.lista.add("Tangerina");
        this.lista.add("Jaboticaba");
    }

    public void add () {
        this.lista.add(this.novaFruta);
        this.novaFruta = "";
    }

    public void editar (String editar) {
        this.remover(editar);
        this.novaFruta = editar;
    }

    public void remover (String remover) {
        for (String fruta : this.lista) {
            if (remover.equals(fruta)) {
                this.lista.remove(fruta);
                break;
            }
        }
    }

    public List <String> getLista () {
        return this.lista;
    }

}
