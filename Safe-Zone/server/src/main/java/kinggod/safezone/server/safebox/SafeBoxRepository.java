package kinggod.safezone.server.safebox;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SafeBoxRepository extends JpaRepository<SafeBox, UUID> {

}
