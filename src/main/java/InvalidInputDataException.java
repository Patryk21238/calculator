import javax.swing.JOptionPane;

public class InvalidInputDataException extends Exception {

    public InvalidInputDataException() {
        JOptionPane.showMessageDialog(null, "Podana wartość jest za niska!", "Ostrzeżenie!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
