package ma.fsr.events1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Event")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String acronym;

    private String venue;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date first_day;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date last_day;
    @OneToOne(mappedBy = "event")
    private CFP cfp;


}
