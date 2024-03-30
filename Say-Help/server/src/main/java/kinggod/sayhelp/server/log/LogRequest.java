package kinggod.sayhelp.server.log;

import kinggod.sayhelp.server.safebox.SafeBox;
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