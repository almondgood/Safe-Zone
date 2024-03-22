package kinggod.safezone.server;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    Optional<Log> findByUuid(UUID uuid);
}
