package kinggod.sayhelp.server.log;

import jakarta.persistence.*;
import kinggod.sayhelp.server.safebox.SafeBox;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class Log {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    @ManyToOne
    @JoinColumn(name = "safebox_id")
    private SafeBox safeBox;
    // 도움 요청 발생 시각
    private LocalDateTime occurredAt;
    // 경찰 신고 시각
    private LocalDateTime reportedAt;

    public Log(LogRequest logRequest) {
        this.safeBox = logRequest.getSafeBox();
        this.occurredAt = logRequest.getOccurredAt();
        this.reportedAt = LocalDateTime.now();
    }
}
