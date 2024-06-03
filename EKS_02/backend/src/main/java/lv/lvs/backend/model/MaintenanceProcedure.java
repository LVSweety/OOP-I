package lv.lvs.backend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "MaintenanceProcedureTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MaintenanceProcedure {
    @Column(name = "IdMP")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idMP;

    @Column(name = "StartDateTime")
    @NonNull
    private LocalDateTime startDateTime;

    @ManyToOne
    @JoinColumn(name = "IdCA")
    @JsonManagedReference
    private Car car;

    @ManyToOne
    @JoinColumn(name = "IdM")
    @JsonManagedReference
    private Mechanic mechanic;

    public MaintenanceProcedure(LocalDateTime start, Car car, Mechanic mechanic) {
        setStartDateTime(start);
        setCar(car);
        setMechanic(mechanic);
    }
}
