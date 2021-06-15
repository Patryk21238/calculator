import java.util.HashMap;
import java.util.Map;

public class ConvertedObject {
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
        unitsOfLength.setValues("mm", 0.1);
        unitsOfLength.setValues("dm", 10.0);
        unitsOfLength.setValues("m", 100.0);
        unitsOfLength.setValues("km", 100000.0);
        unitsOfLength.setValues("cal", 2.54);
        unitsOfLength.setValues("jard", 91.44);

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

    public static ConvertedObject prepareUnitsOfArea() {
        ConvertedObject unitsOfArea = new ConvertedObject("units of area");

        unitsOfArea.setValues("cm^2", 10000.0);
        unitsOfArea.setValues("dm^2", 100.0);
        unitsOfArea.setValues("m^2", 1.0);
        unitsOfArea.setValues("ar", 0.01);
        unitsOfArea.setValues("ha", 0.0001);
        unitsOfArea.setValues("km^2", 0.000001);

        return unitsOfArea;
    }

    public static ConvertedObject prepareUnitsOfDataSize() {
        ConvertedObject unitsOfDataSize = new ConvertedObject("units of data size");
        unitsOfDataSize.setValues("B", 1048576.0);
        unitsOfDataSize.setValues("KB", 1024.0);
        unitsOfDataSize.setValues("MB", 1.0);
        unitsOfDataSize.setValues("GB", 0.000977);
        return unitsOfDataSize;
    }

    public static ConvertedObject prepareUnitsOfVolume() {
        ConvertedObject unitsOfVolume = new ConvertedObject("units of volume");

        unitsOfVolume.setValues("ml", 1000.0);
        unitsOfVolume.setValues("cl", 100.0);
        unitsOfVolume.setValues("dl", 10.0);
        unitsOfVolume.setValues("l", 1.0);
        unitsOfVolume.setValues("m^3", 0.001);

        return unitsOfVolume;
    }

    public static ConvertedObject prepareUnitsOfTemperature() {
        ConvertedObject unitsOfTemperature = new ConvertedObject("units of temperature");

        unitsOfTemperature.setValues("Celsjusz", 100.0);
        unitsOfTemperature.setValues("Fahrenheit", 212.0);
        unitsOfTemperature.setValues("Kelvin", 373.15);
        unitsOfTemperature.setValues("Rankine", 671.67);
        unitsOfTemperature.setValues("Reamur", 80.0);

        return unitsOfTemperature;
    }

    public static ConvertedObject prepareUnitsOfQuantity() {
        ConvertedObject unitsOfQuantity = new ConvertedObject("units of quantity");

        unitsOfQuantity.setValues("sztuka", 1440.0);
        unitsOfQuantity.setValues("tuzin", 120.0);
        unitsOfQuantity.setValues("mendel", 96.0);
        unitsOfQuantity.setValues("mendel chłopski", 90.0);
        unitsOfQuantity.setValues("kopa", 24.0);
        unitsOfQuantity.setValues("gros", 10.0);

        return unitsOfQuantity;
    }
}
