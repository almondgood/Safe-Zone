package kinggod.safezone.server;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class LogRequest {

    private UUID uuid;
    private String location;
    private LocalDateTime occurrenceTime;
}
