package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class User implements Serializable {
    private String name = "";
    private String password;

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPassword () {
        return this.password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getGreeting () {
        if (this.name.length() == 0)
            return "nothing...";
        return "Supimpa its working " + this.name + "! ";
    }
}
