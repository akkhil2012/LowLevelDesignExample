public class Flight {


    String flightNumber;

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", FLightData=" + FLightData +
                '}';
    }

    FlightData FLightData;

    public Flight(String flightNumber, FlightData FLightData) {
        this.flightNumber = flightNumber;
        this.FLightData = FLightData;
    }

    public FlightData getFLightData() {
        return FLightData;
    }
}
