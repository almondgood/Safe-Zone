package kinggod.safezone.server;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Log {

    @Id @GeneratedValue
    private Long id;
    private UUID uuid;
    private String location;
    private LocalDateTime occurrenceTime;
    private LocalDateTime reportTime;

    public Log(LogRequest logRequest) {
        this.uuid = logRequest.getUuid();
        this.location = logRequest.getLocation();
        this.occurrenceTime = logRequest.getOccurrenceTime();
    }
}
