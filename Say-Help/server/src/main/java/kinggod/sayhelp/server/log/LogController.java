package kinggod.sayhelp.server.log;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;
    private final DefaultMessageService messageService;

    @GetMapping("/logs")
    public List<LogResponse> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/log/{id}")
    public LogResponse getLogById(@PathVariable("id") Long id) {
        return logService.getLogById(id);
    }
}
