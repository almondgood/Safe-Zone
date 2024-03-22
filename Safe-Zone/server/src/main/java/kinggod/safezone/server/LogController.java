package kinggod.safezone.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/api")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping(name = "/logs")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @PostMapping(name = "data")
    public void createLog(@RequestBody Log log) {
        // 이 부분에서 JSON 데이터를 Log 객체로 파싱하여 Service에 전달합니다.
        logService.createLog(log);

    }

}
