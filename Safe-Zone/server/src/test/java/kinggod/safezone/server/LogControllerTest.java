package kinggod.safezone.server;

import net.nurigo.sdk.message.service.DefaultMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LogControllerTest {
    @Mock
    private LogService logService;

    @Mock
    private DefaultMessageService messageService;

    private LogController logController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        logController = new LogController(logService, messageService);
    }

    @Test
    public void testCreateLog() {
        // given
        LogRequest logRequest = new LogRequest();
        logRequest.setUuid(UUID.randomUUID());
        logRequest.setLocation("Test Location");
        logRequest.setOccurrenceTime(LocalDateTime.now());

        // when
        logController.createLog(logRequest);

        // then
        verify(logService, times(1)).createLog(logRequest);
    }
}