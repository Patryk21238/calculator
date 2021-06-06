import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConvertedObject{
    private String name;
    private Map<String, Double> values = new HashMap<>();

    public ConvertedObject(String name) {
        this.name = name;
    }

    public void setValues(String name, Double value) {
        this.values.put(name, value);
    }

    public Map<String, Double> getValues() {
        return values;
    }

    public String getName() {
        return name;
    }

    public static ConvertedObject prepareCurrencies() {
        ConvertedObject currencies = new ConvertedObject("currencies");

        currencies.setValues("PLN", 1.0);
        currencies.setValues("EUR", 4.47);
        currencies.setValues("CHF", 4.07);
        currencies.setValues("USD", 3.67);
        currencies.setValues("GBP", 5.18);
        currencies.setValues("SEK", 0.43);
        currencies.setValues("NOK", 0.44);

        return currencies;
    }


    public static ConvertedObject prepareUnitsOfLength() {
        ConvertedObject unitsOfLength = new ConvertedObject("units of length");

        unitsOfLength.setValues("cm", 1.0);
        unitsOfLength.setValues("mm", 10.0);
        unitsOfLength.setValues("dm", 0.1);
        unitsOfLength.setValues("m", 0.01);
        unitsOfLength.setValues("km", 0.00001);
        unitsOfLength.setValues("cal", 0.393701);
        unitsOfLength.setValues("jard", 0.010936);


        return unitsOfLength;
    }


    public static ConvertedObject prepareSpeedUnits() {
        ConvertedObject speedUnits = new ConvertedObject("units of speed");

        speedUnits.setValues("m/s", 1.0);
        speedUnits.setValues("km/h", 3.6);
        speedUnits.setValues("węzły", 1.944012);
        speedUnits.setValues("stopy/s", 3.28084);
        speedUnits.setValues("machy", 0.002939);

        return speedUnits;
    }
}
