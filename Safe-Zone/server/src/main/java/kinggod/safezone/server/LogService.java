package kinggod.safezone.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public void parse(String body) {
        
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }


    public void createLog(Log log) throws IllegalArgumentException {
        validateLog(log);
        logRepository.save(log);
    }

    private void validateLog(Log log) throws IllegalArgumentException {
        if (log == null) {
            throw new IllegalArgumentException("Log cannot be null");
        }
        if (log.getUuid() == null) {
            throw new IllegalArgumentException("UUID cannot be null");
        }
        if (log.getLocation() == null || log.getLocation().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        if (log.getOccurrenceTime() == null || log.getReportTime() == null ||
                log.getOccurrenceTime().isAfter(LocalDateTime.now()) ||
                log.getReportTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Occurrence time and report time must be in the past");
        }
    }
}

