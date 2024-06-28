package schedule.schedules;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.time.format.*;

public abstract class SplaScheduleUtils {
    protected String scheduleURL = "";

    public static URL getURL(String scheduleURL) {
        try {
            URI uri = new URI(scheduleURL);
            return uri.toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getFormattedDateTime(String originalStartDateTime, String originalEndDateTime) {

        // 日付と時刻を解析
        ZonedDateTime startZonedDateTime = ZonedDateTime.parse(originalStartDateTime);
        ZonedDateTime endZonedDateTime = ZonedDateTime.parse(originalEndDateTime);

        LocalDateTime startLocalDateTime = startZonedDateTime.toLocalDateTime();
        LocalDateTime endLocalDateTime = endZonedDateTime.toLocalDateTime();

        String formattedStartDateTime;
        String formattedEndDateTime;

        // 年が同じ場合は年を省略する
        if (startLocalDateTime.getYear() == LocalDateTime.now().getYear()) {
            formattedStartDateTime = startLocalDateTime.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
            formattedEndDateTime = endLocalDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        } else {
            formattedStartDateTime = startLocalDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            formattedEndDateTime = endLocalDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }

        // 日付が同じ場合は日付を省略する
        if (startLocalDateTime.toLocalDate().isEqual(endLocalDateTime.toLocalDate())) {
            return formattedStartDateTime + " ~ " + formattedEndDateTime;
        } else {
            return formattedStartDateTime + " ~ " + endLocalDateTime.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
        }
    }

    public abstract void showSchedule();

    public ArrayNode getArrayNode() {
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
