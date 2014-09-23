package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.AbobrinhaValidator")
public class AbobrinhaValidator implements Validator {
    public void validate (FacesContext context,
                          UIComponent component,
                          Object value) throws ValidatorException{
        if (value.toString().equals("abobrinha")) {
            FacesMessage msg = new FacesMessage("Sem abobrinha por favor");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
