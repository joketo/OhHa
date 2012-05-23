/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johanna
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tapahtumankuuntelija implements ActionListener{
    Koe koe;
    public Tapahtumankuuntelija(){
        this.koe = new Koe();
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        koe.run();
    }
}
