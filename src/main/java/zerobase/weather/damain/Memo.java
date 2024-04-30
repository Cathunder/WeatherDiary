package zerobase.weather.damain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "memo")      // db에 있는 memo 테이블과 매핑
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: 키값 생성을 db에 맡김
    private int id;
    private String text;
}
