package edu.utfpr.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.utfpr.model.FrutaModel;
import edu.utfpr.model.pojo.Fruta;

@ManagedBean
public class FrutaUI {
    private String novaFruta = "";
    private String novaCor = "";
    public void setNovaFruta(String novaFruta){ this.novaFruta = novaFruta; }
    public String getNovaFruta(){ return this.novaFruta; }
    public void setNovaCor(String novaCor){ this.novaCor = novaCor; }
    public String getNovaCor(){ return this.novaCor; }

    public void inserir () {
        FrutaModel model = new FrutaModel();
        model.inserir(this.novaFruta, this.novaCor);
        this.novaFruta = "";
        this.novaCor = "";
    }

    public List <Fruta> getLista () {
        FrutaModel model = new FrutaModel();
        return model.getFrutas();
    }

}
