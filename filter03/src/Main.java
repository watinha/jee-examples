import java.util.ResourceBundle;
import java.util.Locale;

public class Main {
    public static void main (String args[]) {
        ResourceBundle rb = ResourceBundle.getBundle("resources.geral",
                new Locale("en_US"));
        System.out.println(rb.getString("HELLO"));
        System.out.println(rb.getString("NAME"));
    }
}
