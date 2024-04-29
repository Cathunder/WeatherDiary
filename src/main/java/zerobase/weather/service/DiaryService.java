package zerobase.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

@Service
public class DiaryService {

    // @Value: 민감한 값들을 그대로 코드에 넣으면 위험함. 환경에 따른 유연한 값 설정을 위해 사용
    @Value("${openweathermap.key}")
    private String apiKey;

    public void createDiary(LocalDate date, String text) {
        // open weather map에서 날씨 데이터 가져오기
        String weatherData = getWeatherString();

        // 받아온 날씨 json 파싱하기

        // 파싱된 데이터 + 일기값 우리 db에 넣기

    }

    private String getWeatherString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // url을 http형식으로 연결
            connection.setRequestMethod("GET"); // get으로 호출
            int responseCode = connection.getResponseCode(); // 요청에 대한 응답 결과를 코드로 받아옴
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            return response.toString();
        } catch (Exception e) {
            return "failed to get response";
        }
    }
}
