import br.com.eletronicos.DispositivoMovel;
import br.com.eletronicos.Eletronico;
import br.com.eletronicos.Produto;

import javax.swing.*;

public class teste {

    public static void main(String[] args) {
        Eletronico celular = new DispositivoMovel(6,"quatum","Oled",8,10);
        Produto celular1 = new Produto(40.00,"Samsung",celular,"1254643987");
        JOptionPane.showMessageDialog(null,celular1.fichaTecnica());

    }
}
