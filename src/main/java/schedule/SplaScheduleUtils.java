package schedule;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.time.format.*;

/**
 * Splatoon 3 のスケジュールを取得したり、時間をフォーマットしたりするためのユーティリティクラスです。
 */
public class SplaScheduleUtils {

    /**
     * URLオブジェクトを取得します。
     *
     * @param scheduleURL スケジュールのURL
     * @return URLオブジェクト
     */
    public static URL getURL(String scheduleURL) {
        try {
            URI uri = new URI(scheduleURL);
            return uri.toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 日付と時刻をフォーマットします。
     *
     * @param originalStartDateTime 開始日時
     * @param originalEndDateTime   終了日時
     * @return フォーマットされた日付と時刻の文字列
     */
    public static String getFormattedDateTime(String originalStartDateTime, String originalEndDateTime) {
        // 日付と時刻を解析
        ZonedDateTime startZonedDateTime = ZonedDateTime.parse(originalStartDateTime);
        ZonedDateTime endZonedDateTime = ZonedDateTime.parse(originalEndDateTime);

        LocalDateTime startLocalDateTime = startZonedDateTime.toLocalDateTime();
        LocalDateTime endLocalDateTime = endZonedDateTime.toLocalDateTime();

        DateTimeFormatter dateFormatter;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm"); // 先頭の0を消す
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d H:mm"); // 先頭の0を消す

        // 年が同じ場合は年を省略する
        if (startLocalDateTime.getYear() == LocalDateTime.now().getYear()) {
            dateFormatter = DateTimeFormatter.ofPattern("M/d"); // 先頭の0を消す
        } else {
            dateFormatter = DateTimeFormatter.ofPattern("yyyy/M/d"); // 先頭の0を消す
        }

        String formattedStartDateTime = startLocalDateTime.format(dateTimeFormatter);
        String formattedEndDateTime = endLocalDateTime.format(timeFormatter);

        // 日付が同じ場合は日付を省略する
        if (startLocalDateTime.toLocalDate().isEqual(endLocalDateTime.toLocalDate())) {
            return formattedStartDateTime + " –> " + formattedEndDateTime;
        } else {
            String formattedEndDate = endLocalDateTime.format(dateFormatter);
            return formattedStartDateTime + " –> " + formattedEndDate + " " + formattedEndDateTime;
        }
    }

    /**
     * JSONデータを取得し、ArrayNodeとして返します。
     *
     * @param scheduleURL スケジュールのURL
     * @return ArrayNodeオブジェクト
     */
    public static ArrayNode getArrayNode(String scheduleURL) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        try {
            // JSONをURLから取得
            JsonNode rootNode = objectMapper.readTree(getURL(scheduleURL));
            JsonNode resultsNode = rootNode.get("results");
            for (JsonNode resultNode : resultsNode) {
                arrayNode.add(resultNode);
            }
            return arrayNode;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}