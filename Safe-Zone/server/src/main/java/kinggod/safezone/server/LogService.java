package kinggod.safezone.server;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }


    public void createLog(LogRequest logRequest) throws IllegalArgumentException {
        validateLog(logRequest);
        Log log = new Log(logRequest);
        logRepository.save(log);

        logger.info(log.toString());
    }

    private void validateLog(LogRequest logRequest) throws IllegalArgumentException {
        if (logRequest == null) {
            throw new IllegalArgumentException("Log cannot be null");
        }
        if (logRequest.getUuid() == null) {
            throw new IllegalArgumentException("UUID cannot be null");
        }
        if (logRequest.getLocation() == null || logRequest.getLocation().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
        if (logRequest.getOccurrenceTime() == null ||
                logRequest.getOccurrenceTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Occurrence time must be in the past");
        }

    }

    public Log getLogByUuid(UUID uuid) {
        return logRepository.findByUuid(uuid).orElseThrow(EntityNotFoundException::new);
    }
}

