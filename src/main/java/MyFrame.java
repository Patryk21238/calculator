import javax.swing.*;

import dateTimeInfo.DTInfoESP;
import dateTimeInfo.DTInfoEng;
import dateTimeInfo.DTInfoRU;
import dateTimeInfo.DateTimeInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;

public class MyFrame extends JFrame {
    private static final JPanel contentPane = new JPanel();
    private static JComboBox<String> comboBox;
    private static JComboBox<String> comboBox1;
    private JTextField fromField;
    private static JTextField toField;
    JComboBox<String> conversionType;
    private static final ArrayList<ConvertedObject> arrayOfObjects = new ArrayList<ConvertedObject>();
    private static int fromPosition = 75;
    private static int toPosition = 150;

    public MyFrame() {
        super("Konwenter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillArrayOfObjects();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width / 2, dim.height - 50);
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel dateInfoLabel = prepareDataInfoInRandomLanguage();
        contentPane.add(dateInfoLabel);

        conversionType = pickConversionTypeComboBox();
        contentPane.add(conversionType);

        JButton conversionTypeButton = pickConversionTypeActionButton();
        contentPane.add(conversionTypeButton);

        setVisible(true);

    }

    private JButton pickConversionTypeActionButton() {
        JButton btnConvert = new JButton("CHOOSE");
        btnConvert.setBounds(475, 10, 129, 50);
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox != null)
                    contentPane.remove(comboBox);
                if (comboBox1 != null)
                    contentPane.remove(comboBox1);
                if (fromField != null)
                    contentPane.remove(fromField);
                if (toField != null)
                    contentPane.remove(toField);
                contentPane.updateUI();

                JLabel fromLabel = pickValueTypeLabel("FROM:", fromPosition);
                JLabel toLabel = pickValueTypeLabel("TO:", toPosition);
                fromField = prepareAmountField(75, "");
                toField = prepareAmountField(150, "");
                JButton countButton = countButton();

                contentPane.add(fromLabel);
                contentPane.add(toLabel);
                contentPane.add(fromField);
                contentPane.add(toField);
                contentPane.add(countButton);

                contentPane.revalidate();
                contentPane.repaint();

                String conversion = Objects.requireNonNull(conversionType.getSelectedItem()).toString();

                switch (conversion) {
                    case "Currencies":
                        chooseValueType(arrayOfObjects.get(0));
                        break;
                    case "Units of length":
                        chooseValueType(arrayOfObjects.get(1));
                        break;
                    case "Units of speed":
                        chooseValueType(arrayOfObjects.get(2));
                        break;
                    case "Units of area":
                        chooseValueType(arrayOfObjects.get(3));
                        break;
                    case "Units of data size":
                        chooseValueType(arrayOfObjects.get(4));
                        break;
                    case "Units of volume":
                        chooseValueType(arrayOfObjects.get(5));
                        break;
                    case "Units of temperature":
                        chooseValueType(arrayOfObjects.get(6));
                        break;
                    case "Units of quantity":
                        chooseValueType(arrayOfObjects.get(6));
                        break;

                    default:
                        break;

                }

            }
        });
        return btnConvert;
    }

    private JButton countButton() {
        JButton count = new JButton("COUNT");
        count.setBounds(50, 225, 554, 50);
        count.setBackground(Color.GREEN);
        count.setForeground(Color.white);
        count.setFont(new Font("Arial", Font.PLAIN, 40));
        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conversion = Objects.requireNonNull(conversionType.getSelectedItem()).toString();
                String from = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
                String to = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                double typedValue;

                try {
                    typedValue = Double.parseDouble(fromField.getText());
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    typedValue = 0.0;
                }

                if (toField != null)
                    contentPane.remove(toField);
                contentPane.updateUI();

                switch (conversion) {
                    case "Currencies":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(0), from, to, typedValue);
                        } catch (InvalidInputDataException e3) {

                        }
                        break;

                    case "Units of length":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(1), from, to, typedValue);
                        } catch (InvalidInputDataException e3) {

                        }
                        break;

                    case "Units of speed":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(2), from, to, typedValue);
                        } catch (InvalidInputDataException e1) {
                        }
                        break;

                    case "Units of area":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(3), from, to, typedValue);
                        } catch (InvalidInputDataException e1) {
                        }
                        break;
                    case "Units of data size":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(4), from, to, typedValue);
                        } catch (InvalidInputDataException e2) {
                        }
                        break;
                    case "Units of volume":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(5), from, to, typedValue);
                        } catch (InvalidInputDataException e2) {

                        }
                        break;
                    case "Units of temperature":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(6), from, to, typedValue);
                        } catch (InvalidInputDataException e2) {
                        }
                        break;
                    case "Units of quantity":
                        try {
                            chooseFieldAndCountResult(arrayOfObjects.get(6), from, to, typedValue);
                        } catch (InvalidInputDataException e1) {

                        }
                        break;

                }
            }

        });

        return count;
    }

    public static void fillArrayOfObjects() {
        arrayOfObjects.add(ConvertedObject.prepareCurrencies());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfLength());
        arrayOfObjects.add(ConvertedObject.prepareSpeedUnits());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfArea());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfDataSize());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfVolume());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfTemperature());
        arrayOfObjects.add(ConvertedObject.prepareUnitsOfQuantity());
    }

    public static void chooseValueType(ConvertedObject inputObject) {
        comboBox = pickValueType(inputObject, fromPosition);
        contentPane.add(comboBox);
        comboBox1 = pickValueType(inputObject, toPosition);
        contentPane.add(comboBox1);
        contentPane.revalidate();
        contentPane.repaint();
        System.out.println();
    }

    public static void chooseFieldAndCountResult(ConvertedObject inputObject, String from, String to, double typedValue)
            throws InvalidInputDataException {
        String result = countResult(inputObject, from, to, typedValue);
        if (Double.parseDouble(result) < inputObject.getMinValue()) {
            throw new InvalidInputDataException();
        }
        toField = prepareAmountField(150, result);
        contentPane.add(toField);
        contentPane.revalidate();
        contentPane.repaint();
        System.out.println();
    }

    private static String countResult(ConvertedObject convertedObject, String from, String to, double typedValue) {
        double result = 1.0;
        double value1 = 1.0;
        double value2 = 1.0;

        for (Map.Entry<String, Double> entry : convertedObject.getValues().entrySet()) {
            if (entry.getKey().equals(from))
                value1 = entry.getValue();
            if (entry.getKey().equals(to))
                value2 = entry.getValue();
        }
        if (convertedObject.getName() == "Units of temperature")
            result = countTemperature(typedValue, from, to);
        else {

            if (value1 < value2) {
                result = typedValue / (value1 / value2);
            } else if (value1 > value2) {
                result = typedValue * (value2 / value1);
            } else
                result = typedValue;
        }
        result = result * 1000000;
        result = Math.round(result);
        result = result / 1000000;

        return Double.toString(result);
    }

    private static Double countTemperature(Double typedValue, String from, String to) {
        Double result;

        if (from == "Celsjusz" && to == "Fahrenheit") {
            result = typedValue * 1.8 + 32;
        } else if (from == "Celsjusz" && to == "Kelvin") {
            result = typedValue + 273.15;
        } else if (from == "Fahrenheit" && to == "Celsjusz") {
            result = (typedValue - 32) * (5 / 9);
        } else if (from == "Fahrenheit" && to == "Celsjusz") {
            result = ((typedValue - 32) * (5 / 9)) + 273.15;
        } else if (from == "Kelvin" && to == "Celsjusz") {
            result = typedValue - 273.15;
        } else if (from == "Kelvin" && to == "Fahrenheit") {
            result = ((typedValue - 273.15) * 1.8) + 32;
        } else {
            result = typedValue;
        }
        return result;

    }

    public static void fillComboBox(JComboBox<String> comboBox, ConvertedObject convertedObject) {
        for (String name : convertedObject.getValues().keySet()) {
            comboBox.addItem(name);
        }
    }

    public static JComboBox<String> pickConversionTypeComboBox() {
        final JComboBox<String> comboBoxConversionType = new JComboBox<>();
        comboBoxConversionType.setBounds(50, 10, 400, 50);
        fillComboBoxConversionType(comboBoxConversionType);
        return comboBoxConversionType;
    }

    private static JLabel pickValueTypeLabel(String message, int yPosition) {
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBounds(50, yPosition, 90, 50);

        return label;
    }

    private static JLabel prepareDataInfoInRandomLanguage() {
        Random random = new Random();
        int randInt = random.nextInt(4);
        String message;
        if (randInt == 0) {
            DateTimeInfo dateTimeInfo = new DateTimeInfo();
            message = dateTimeInfo.getGreetingMessage();
        } else if (randInt == 1) {
            DTInfoEng dtInfoEng = new DTInfoEng();
            message = dtInfoEng.getGreetingMessage();
        } else if (randInt == 2) {
            DTInfoRU dtInfoRU = new DTInfoRU();
            message = dtInfoRU.getGreetingMessage();
        } else {
            DTInfoESP dtInfoESP = new DTInfoESP();
            message = dtInfoESP.getGreetingMessage();
        }

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBounds(50, 700, 500, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        return label;
    }

    public static JComboBox<String> pickValueType(ConvertedObject convertedObject, int yPosition) {
        final JComboBox<String> comboBoxValueType = new JComboBox<>();
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

    public static void fillComboBoxConversionType(JComboBox<String> comboBox) {
        for (int i = 0; i < arrayOfObjects.size(); i++) {
            ConvertedObject tmp = (ConvertedObject) arrayOfObjects.get(i);
            comboBox.addItem(tmp.getName());
        }
    }
}
