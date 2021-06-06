import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Map;

public class MyFrame extends JFrame {
    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox1;
    private JTextField fromField;
    private JTextField toField;
    private static ConvertedObject currencies = ConvertedObject.prepareCurrencies();
    private static ConvertedObject unitsOfLength = ConvertedObject.prepareUnitsOfLength();
    private static ConvertedObject speedUnits = ConvertedObject.prepareSpeedUnits();

    public MyFrame() {
        super("Konwenter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width / 2, dim.height - 50);
        setResizable(false);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> conversionType = pickConversionTypeComboBox();
        contentPane.add(conversionType);

        JButton conversionTypeButton = pickConversionTypeActionButton(conversionType);
        contentPane.add(conversionTypeButton);

        setVisible(true);


    }

    private JButton pickConversionTypeActionButton(JComboBox<String> conversionType) {
        JButton btnConvert = new JButton("CHOOSE");
        btnConvert.setBounds(475, 10, 129, 50);
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox != null) contentPane.remove(comboBox);
                if (comboBox1 != null) contentPane.remove(comboBox1);
                contentPane.updateUI();

                int fromPosition = 75;
                int toPosition = 150;
                JLabel fromLabel = pickValueTypeLabel("FROM:", fromPosition);
                JLabel toLabel = pickValueTypeLabel("TO:", toPosition);
                fromField = prepareAmountField(75, "");
                toField = prepareAmountField(150, "");
                JButton countButton = countButton(conversionType);

                contentPane.add(fromLabel);
                contentPane.add(toLabel);
                contentPane.add(fromField);
                contentPane.add(toField);
                contentPane.add(countButton);

                contentPane.revalidate();
                contentPane.repaint();

                String conversion = conversionType.getSelectedItem().toString();

                switch (conversion) {
                    case "currencies":
                        comboBox = pickValueType(currencies, fromPosition);
                        contentPane.add(comboBox);
                        comboBox1 = pickValueType(currencies, toPosition);
                        contentPane.add(comboBox1);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;
                    case "units of length":
                        comboBox = pickValueType(unitsOfLength, fromPosition);
                        contentPane.add(comboBox);
                        comboBox1 = pickValueType(unitsOfLength, toPosition);
                        contentPane.add(comboBox1);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;
                    case "units of speed":
                        comboBox = pickValueType(speedUnits, fromPosition);
                        contentPane.add(comboBox);
                        comboBox1 = pickValueType(speedUnits, toPosition);
                        contentPane.add(comboBox1);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;

                    default:
                        break;

                }

            }
        });
        return btnConvert;
    }

    private JButton countButton(JComboBox<String> conversionType) {
        JButton count = new JButton("COUNT");
        count.setBounds(50, 225, 554, 50);
        count.setBackground(Color.GREEN);
        count.setForeground(Color.white);
        count.setFont(new Font("Arial", Font.PLAIN, 40));
        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conversion = conversionType.getSelectedItem().toString();
                String from = comboBox.getSelectedItem().toString();
                String to = comboBox1.getSelectedItem().toString();
                String v = fromField.getText();
                double value1 = 1.0;
                double value2 = 1.0;
                double typedValue;
                String result;
                System.out.println(v);
                try {
                    typedValue = Double.parseDouble(v);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    typedValue = 0.0;
                }

                if(toField != null) contentPane.remove(toField);
                contentPane.updateUI();

                switch (conversion) {
                    case "currencies":
                        result = countResult(currencies, from, to, value1, value2, typedValue);
                        toField = prepareAmountField(150, result);
                        contentPane.add(toField);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;

                    case "units of length":
                        result = countResult(unitsOfLength, from, to, value1, value2, typedValue);
                        toField = prepareAmountField(150, result);
                        contentPane.add(toField);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;

                    case "units of speed":
                        result = countResult(speedUnits, from, to, value1, value2, typedValue);
                        toField = prepareAmountField(150, result);
                        contentPane.add(toField);
                        contentPane.revalidate();
                        contentPane.repaint();
                        break;
                }


            }

            private String countResult(ConvertedObject convertedObject, String from, String to, double value1, double value2, double typedValue) {
                double result;
                for (Map.Entry<String, Double> entry : convertedObject.getValues().entrySet()) {
                    if (entry.getKey().equals(from)) value1 = entry.getValue();
                    if (entry.getKey().equals(to)) value2 = entry.getValue();
                }
                result = typedValue * (value1/value2);

                return Double.toString(result);
            }
        });

        return count;
    }

    public static void fillComboBox(JComboBox<String> comboBox, ConvertedObject convertedObject) {
        for (String name : convertedObject.getValues().keySet()) {
            comboBox.addItem(name);
        }
    }

    public static JComboBox<String> pickConversionTypeComboBox() {
        final JComboBox<String> comboBoxConversionType = new JComboBox<String>();
        comboBoxConversionType.setBounds(50, 10, 400, 50);
        fillComboBoxConversionType(comboBoxConversionType, currencies, speedUnits, unitsOfLength);
        return comboBoxConversionType;
    }

    private static JLabel pickValueTypeLabel(String message, int yPosition) {
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBounds(50, yPosition, 90, 50);

        return label;
    }

    public static JComboBox<String> pickValueType(ConvertedObject convertedObject, int yPosition) {
        final JComboBox<String> comboBoxValueType = new JComboBox<String>();
        comboBoxValueType.setBounds(100, yPosition, 350, 50);
        fillComboBox(comboBoxValueType, convertedObject);

        return comboBoxValueType;
    }

    public static JTextField prepareAmountField(int yPosition, String text) {
        JTextField fieldAmount = new JTextField();
        fieldAmount.setBounds(475, yPosition, 129, 50);
        fieldAmount.setText(text);

        return fieldAmount;
    }

    public static void fillComboBoxConversionType(JComboBox<String> comboBox, ConvertedObject convertedObject1,
                                                  ConvertedObject convertedObject2, ConvertedObject convertedObject3) {
        comboBox.addItem(convertedObject1.getName());
        comboBox.addItem(convertedObject2.getName());
        comboBox.addItem(convertedObject3.getName());
    }
}
