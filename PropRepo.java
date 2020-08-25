package nl.Eindopdracht.BoogieWoogie.Persistance;

import nl.Eindopdracht.BoogieWoogie.Domain.Prop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropRepo extends JpaRepository<Prop, Long> {
}
