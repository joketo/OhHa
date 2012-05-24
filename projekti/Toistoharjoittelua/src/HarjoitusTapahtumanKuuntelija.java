
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author johanna
 */
public class HarjoitusTapahtumanKuuntelija implements ActionListener {

    Harjoitus harjoitus;

    public HarjoitusTapahtumanKuuntelija() {
        harjoitus = new Harjoitus();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        harjoitus.run();
    }
}
