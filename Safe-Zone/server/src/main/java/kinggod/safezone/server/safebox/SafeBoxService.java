package kinggod.safezone.server.safebox;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class SafeBoxService {

    private final SafeBoxRepository safeBoxRepository;
    private final DefaultMessageService messageService;

    public UUID register(SafeBoxRegisterRequest safeBoxRegisterRequest) {
        SafeBox safeBox = SafeBox.builder()
                .uuid(UUID.randomUUID())
                .serial(safeBoxRegisterRequest.getSerial())
                .location(safeBoxRegisterRequest.getLocation())
                .build();

        safeBoxRepository.save(safeBox);

        return safeBox.getUuid();
    }

    public SafeBox reportToPolice(SafeBoxReportRequest request) {
        SafeBox safeBox = safeBoxRepository.findById(request.getUuid()).orElseThrow(EntityNotFoundException::new);

        reportToPolice(request.getOccurredAt(),
                safeBox.getLocation());

        return safeBox;
    }

    // 경찰 신고
    private SingleMessageSentResponse reportToPolice(LocalDateTime occurredAt, String location) {
        // 실제 신고 대신 임의의 번호로 문자 전송
        Message msg = new Message();
        StringBuilder sb = new StringBuilder();

        msg.setFrom("01033842719");
        msg.setTo("01023578981");

        sb.append(occurredAt).append("경").append('\n')
                .append(location).append("에서 사건 발생");

        msg.setText(sb.toString());

        System.out.println(msg);
        // 실제 사용 시에는 주석 해제
        // 사용할때 돈 듦;
        SingleMessageSentResponse response = null;
        //SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(msg));


        return response;
    }

}

