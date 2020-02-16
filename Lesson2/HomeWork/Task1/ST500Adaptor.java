import java.time.*;

public class ST500Adaptor{

    private ST500Info st500sensor;
    private SensorTemperature sensorTemperature;

    public ST500Adaptor(ST500Info st500sensor) {
        this.st500sensor = st500sensor;
        this.sensorTemperature = st500sensor.getData();
    }

    public MeteoSensor getData() {
        return new MeteoSensor() {
            @Override
            public int getId() {
                 return sensorTemperature.identifier();
            }

            @Override
            public Float getTemperature() {
                double tempDouble = sensorTemperature.temperature();
                Float tempFloat = Float.parseFloat(String.valueOf(tempDouble));
                return tempFloat;
            }

            @Override
            public Float getHumidity() {
                return 0f;
            }

            @Override
            public Float getPressure() {
                return 0f;
            }

            @Override
            public LocalDateTime getDateTime() {
                return LocalDateTime.now();
            }
        };
    }
}
