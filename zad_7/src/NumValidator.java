import java.awt.event.*;
import javax.swing.*;
class NumValidator extends JFrame implements ActionListener {
    static JTextField t;
    static JFrame f;
    static JButton b;
    static JLabel l;
    NumValidator()
    {
    }

    public static void main(String[] args)
    {

        f = new JFrame("Testowanie danych wejściowych");

        l = new JLabel();

        b = new JButton("Wpisz:");

        NumValidator nv = new NumValidator();

        b.addActionListener(nv);

        t = new JTextField(16);
        JPanel p = new JPanel();

        p.add(b);
        p.add(t);
        p.add(l);
        f.add(p);
        f.setSize(400, 150);
        f.show();
    }

    public void actionPerformed(ActionEvent e)
    {
        String n1 = JOptionPane.showInputDialog(null, "Wpisz wartość numeryczną");
        while(!isNumber(n1)) {
            JOptionPane.showMessageDialog(null, "Wprowadzono niepoprawną wartość numeryczą! Ponownie wprowadź dane!");
            n1 = JOptionPane.showInputDialog(null, "Wpisz wartość numeryczną");
        }
        JOptionPane.showMessageDialog(null, "Wprowadzono poprawną wartość numeryczną: "
                    + n1);
        t.setText(n1);
    }

    private static boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
