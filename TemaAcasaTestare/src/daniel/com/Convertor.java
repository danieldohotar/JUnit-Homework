package daniel.com;

public class Convertor {

    private double mm = 1;
    private int mmToCm = 10;
    private int mmToDm = 100;
    private int mmToM = 1000;
    private int mmToKm = 1000000;
    private double conv;


    public int convertToSpecificUnit(int value, String unit) {
        switch (unit) {
            case "mm":
                return value;
            case "cm":
                return value * mmToCm;
            case "dm":
                return value * mmToDm;
            case "m":
                return value * mmToM;
            case "km":
                return value * mmToKm;
            default:
                return 0;
        }
    }
}
