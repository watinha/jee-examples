import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.Date;

@ManagedBean
@SessionScoped
public class DateExample implements Serializable {

    private Date horaAgora;

    public Date getHoraAgora () { return this.horaAgora; }
    public void setHoraAgora (Date novaHora) { this.horaAgora = novaHora; }

}
