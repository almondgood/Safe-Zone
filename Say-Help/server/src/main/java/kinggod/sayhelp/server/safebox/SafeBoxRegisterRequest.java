package kinggod.sayhelp.server.safebox;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SafeBoxRegisterRequest {

    private String serial;
    private String location;
}
