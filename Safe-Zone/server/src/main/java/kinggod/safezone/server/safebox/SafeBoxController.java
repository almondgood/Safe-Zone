package kinggod.safezone.server.safebox;

import kinggod.safezone.server.log.Log;
import kinggod.safezone.server.log.LogRequest;
import kinggod.safezone.server.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SafeBoxController {

    private final SafeBoxService safeBoxService;
    private final LogService logService;

    @PostMapping("/register")
    public ResponseEntity<UUID> register(@RequestBody SafeBoxRegisterRequest safeBoxRegisterRequest) {
        return new ResponseEntity<>(safeBoxService.register(safeBoxRegisterRequest), HttpStatus.OK);
    }

    @PostMapping("/report")
    public ResponseEntity<Log> report(@RequestBody SafeBoxReportRequest safeBoxReportRequest) {

        SafeBox detectedBox = safeBoxService.reportToPolice(safeBoxReportRequest);

        LogRequest logRequest = LogRequest.builder()
                        .safeBox(detectedBox)
                        .occurredAt(safeBoxReportRequest.getOccurredAt())
                        .reportedAt(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(logService.createLog(logRequest),
                                    HttpStatus.OK);

    }
}
