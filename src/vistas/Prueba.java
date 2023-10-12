package vistas;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author ivans
 */
public class Prueba {
    public static void main(String[] args){
        String campo = "Fecha de Alta:";
        String caracteresIngresados = "29-02-1984";
        
        
        if(campo.equals("Fecha de Alta:")){
                LocalDate fechaActual = LocalDate.now();
                final String anyoActual = String.format(String.valueOf(fechaActual.getYear())); 
                final String anyoDesde = String.format("19\\d{2}|20[01]\\d|");

                
                String adecuado = "^(?:(?:31(\\/|-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9]|1\\d|2[0-8])(\\/|-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2}))$";
                //String adecuado = "^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[012])-(19|20)\\d{2}$";
/*dios esta entrando a la matrix. D*/
                JOptionPane.showMessageDialog(null, adecuado); 
caracteresIngresados = caracteresIngresados.trim();
                if(caracteresIngresados.matches(adecuado)){
                    JOptionPane.showMessageDialog(null, "La Fecha de Alta está bien especificada");     
                }else{
                    JOptionPane.showMessageDialog(null, "La Fecha de Alta está mal especificada");
                }
        }
    }
    
}
