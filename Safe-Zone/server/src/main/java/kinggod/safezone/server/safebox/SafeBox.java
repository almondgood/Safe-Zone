package kinggod.safezone.server.safebox;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SafeBox {

    @Id
    @Column(name = "safebox_id")
    private UUID uuid;
    private String serial;
    private String location;
}
