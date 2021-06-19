import java.util.HashMap;
import java.util.Map;

public class ConvertedObject {
    private String name;
    private Map<String, Double> values = new HashMap<>();
    private Double minValue;

    public ConvertedObject(String name) {
        this.name = name;
    }

    public void setValues(String name, Double value) {
        this.values.put(name, value);
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Map<String, Double> getValues() {
        return values;
    }

    public Double getMinValue() {
        return minValue;
    }

    public String getName() {
        return name;
    }

    public static ConvertedObject prepareCurrencies() {
        ConvertedObject currencies = new ConvertedObject("Currencies");

        currencies.setValues("PLN", 1.0);
        currencies.setValues("EUR", 4.47);
        currencies.setValues("CHF", 4.07);
        currencies.setValues("USD", 3.67);
        currencies.setValues("GBP", 5.18);
        currencies.setValues("SEK", 0.43);
        currencies.setValues("NOK", 0.44);

        currencies.setMinValue(0.00);

        return currencies;
    }

    public static ConvertedObject prepareUnitsOfLength() {
        ConvertedObject unitsOfLength = new ConvertedObject("Units of length");

        unitsOfLength.setValues("cm", 1.0);
        unitsOfLength.setValues("mm", 0.1);
        unitsOfLength.setValues("dm", 10.0);
        unitsOfLength.setValues("m", 100.0);
        unitsOfLength.setValues("km", 100000.0);
        unitsOfLength.setValues("cal", 2.54);
        unitsOfLength.setValues("jard", 91.44);

        unitsOfLength.setMinValue(0.00);

        return unitsOfLength;
    }

    public static ConvertedObject prepareSpeedUnits() {
        ConvertedObject speedUnits = new ConvertedObject("Units of speed");

        speedUnits.setValues("m/s", 1.0);
        speedUnits.setValues("km/h", 3.6);
        speedUnits.setValues("węzły", 1.944012);
        speedUnits.setValues("stopy/s", 3.28084);
        speedUnits.setValues("machy", 0.002939);

        speedUnits.setMinValue(0.0);

        return speedUnits;
    }

    public static ConvertedObject prepareUnitsOfArea() {
        ConvertedObject unitsOfArea = new ConvertedObject("Units of area");

        unitsOfArea.setValues("cm^2", 10000.0);
        unitsOfArea.setValues("dm^2", 100.0);
        unitsOfArea.setValues("m^2", 1.0);
        unitsOfArea.setValues("ar", 0.01);
        unitsOfArea.setValues("ha", 0.0001);
        unitsOfArea.setValues("km^2", 0.000001);

        unitsOfArea.setMinValue(0.0);

        return unitsOfArea;
    }

    public static ConvertedObject prepareUnitsOfDataSize() {
        ConvertedObject unitsOfDataSize = new ConvertedObject("Units of data size");
        unitsOfDataSize.setValues("b", 1000000.0);
        unitsOfDataSize.setValues("Kb", 1000.0);
        unitsOfDataSize.setValues("Mb", 1.0);
        unitsOfDataSize.setValues("Gb", 0.001);
        unitsOfDataSize.setValues("Tb", 0.000001);

        unitsOfDataSize.setMinValue(0.0);

        return unitsOfDataSize;
    }

    public static ConvertedObject prepareUnitsOfVolume() {
        ConvertedObject unitsOfVolume = new ConvertedObject("Units of volume");

        unitsOfVolume.setValues("ml", 1000.0);
        unitsOfVolume.setValues("cl", 100.0);
        unitsOfVolume.setValues("dl", 10.0);
        unitsOfVolume.setValues("l", 1.0);
        unitsOfVolume.setValues("m^3", 0.001);

        unitsOfVolume.setMinValue(0.0);

        return unitsOfVolume;
    }

    public static ConvertedObject prepareUnitsOfTemperature() {
        ConvertedObject unitsOfTemperature = new ConvertedObject("Units of temperature");

        unitsOfTemperature.setValues("Celsjusz", 100.0);
        unitsOfTemperature.setValues("Fahrenheit", 212.0);
        unitsOfTemperature.setValues("Kelvin", 373.15);

        unitsOfTemperature.setMinValue(0.0);

        return unitsOfTemperature;
    }

    public static ConvertedObject prepareUnitsOfQuantity() {
        ConvertedObject unitsOfQuantity = new ConvertedObject("Units of quantity");

        unitsOfQuantity.setValues("sztuka", 1440.0);
        unitsOfQuantity.setValues("tuzin", 120.0);
        unitsOfQuantity.setValues("mendel", 96.0);
        unitsOfQuantity.setValues("mendel chłopski", 90.0);
        unitsOfQuantity.setValues("kopa", 24.0);
        unitsOfQuantity.setValues("gros", 10.0);

        unitsOfQuantity.setMinValue(0.0);

        return unitsOfQuantity;
    }
}
