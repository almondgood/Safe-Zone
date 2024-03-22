package kinggod.safezone.server;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;
    private final DefaultMessageService messageService;

    @GetMapping("/logs")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/log/{uuid}")
    public Log getLogByUuid(@RequestParam UUID uuid) {
        return logService.getLogByUuid(uuid);
    }

    @PostMapping(value="/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogRequest> createLog(@RequestBody LogRequest logRequest) {
        reportToPolice(logRequest);
        try {
            logService.createLog(logRequest);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(logRequest, HttpStatus.OK);
    }

    // 경찰 신고
    private SingleMessageSentResponse reportToPolice(LogRequest logRequest) {
        // 실제 신고 대신 임의의 번호로 문자 전송
        Message msg = new Message();
        StringBuilder sb = new StringBuilder();

        msg.setFrom("01033842719");
        msg.setTo("01023578981");
        msg.setText("도와주세용");

        // 실제 사용 시에는 주석 해제
        // 사용할때 돈 듦;
        SingleMessageSentResponse response = null;
        //SingleMessageSentResponse response =
        //        this.messageService.sendOne(new SingleMessageSendingRequest(msg));


        return response;
    }
}
