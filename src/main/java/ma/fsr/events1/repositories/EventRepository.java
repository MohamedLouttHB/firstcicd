package ma.fsr.events1.repositories;

import ma.fsr.events1.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
