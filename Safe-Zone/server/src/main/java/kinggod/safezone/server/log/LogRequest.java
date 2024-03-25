package kinggod.safezone.server.log;

import kinggod.safezone.server.safebox.SafeBox;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogRequest {

    private SafeBox safeBox;
    private LocalDateTime occurredAt;
    private LocalDateTime reportedAt;
}