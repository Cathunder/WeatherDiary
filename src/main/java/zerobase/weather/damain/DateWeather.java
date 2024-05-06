package zerobase.weather.damain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "date_weather")
@NoArgsConstructor
public class DateWeather {

    @Id
    private LocalDate date;     // key값을 날짜로 했기 때문에 해당 날짜의 데이터가 있으면 저장 안함
    private String weather;
    private String icon;
    private double temperature;
}
