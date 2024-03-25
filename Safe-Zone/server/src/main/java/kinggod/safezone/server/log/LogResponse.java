package kinggod.safezone.server.log;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LogResponse {
    private Long log_id;
    private UUID uuid;
    private String location;
    // 도움 요청 발생 시각
    private LocalDateTime occurredAt;
    // 경찰 신고 시각
    private LocalDateTime reportedAt;

    public LogResponse(Log log) {
        this.log_id = log.getLogId();
        this.uuid = log.getSafeBox().getUuid();
        this.location = log.getSafeBox().getLocation();
        this.occurredAt = log.getOccurredAt();
        this.reportedAt = log.getReportedAt();
    }
}
