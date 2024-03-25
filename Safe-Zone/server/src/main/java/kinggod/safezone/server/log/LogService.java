package kinggod.safezone.server.log;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public List<LogResponse> getAllLogs() {
        return logRepository.findAll().stream()
                .map(LogResponse::new)
                .toList();
    }

    public LogResponse getLogById(Long id) {
        return logRepository.findById(id)
                .map(LogResponse::new)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Log createLog(LogRequest logRequest) throws IllegalArgumentException {
        if (logRequest == null) {
            throw new IllegalArgumentException("Log cannot be null");
        }

        Log log = new Log(logRequest);
        log = logRepository.save(log);

        logger.info(log.toString());

        return log;
    }
}