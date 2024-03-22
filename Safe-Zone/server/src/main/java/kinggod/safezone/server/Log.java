package kinggod.safezone.server;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class Log {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String location;
    // 도움 요청 발생 시각
    private LocalDateTime occurrenceTime;
    // 경찰 신고 시각
    private LocalDateTime reportTime;

    public Log(LogRequest logRequest) {
        this.uuid = logRequest.getUuid();
        this.location = logRequest.getLocation();
        this.occurrenceTime = logRequest.getOccurrenceTime();
        this.reportTime = LocalDateTime.now();
    }
}
