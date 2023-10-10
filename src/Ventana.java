import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtTexto;
    private JButton btnVerificar;

    public boolean balanceado (String codigo) throws Exception {
        Pila p = new Pila();
        for (int i=0; i< codigo.length(); i++){
            if(codigo.charAt(i) == '(')
                p.insertar('(');
            else{
                if(codigo.charAt(i) == ')'){
                    if(p.eliminar() != '(')
                        return false;
                }
            }

            if(codigo.charAt(i) == '[')
                p.insertar('[');
            else{
                if(codigo.charAt(i) == ']'){
                    if(p.eliminar() != '[')
                        return false;
                }
            }

            if(codigo.charAt(i) == '{')
                p.insertar('{');
            else{
                if(codigo.charAt(i) == '}'){
                    if(p.eliminar() != '{')
                        return false;
                }
            }
        }
        if(p.esVacia())
            return true;
        return false;
    }

    public Ventana() {

        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = txtTexto.getText();
                try {
                    if (balanceado(texto))
                        JOptionPane.showMessageDialog(null, "Codigo Equilibrado");
                    else
                        JOptionPane.showMessageDialog(null, "Codigo no equilibrado");
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Faltaba apertura "+ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
