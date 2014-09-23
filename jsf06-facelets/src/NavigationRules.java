import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class NavigationRules implements Serializable {

    public String carros () { return "carros"; }
    public String motos () { return "motos"; }
    public String aviaos () { return "aviaos"; }
    public String index () { return "index"; }

}
