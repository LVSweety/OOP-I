package lv.lvs.sem_06_01.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.lvs.sem_06_01.model.properties.Degree;

@Table(name = "ProfesorTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Profesor {
    @Column(name = "IdS")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idS;

    @Column(name = "Name")
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z ]+")
    private String name;

    @Column(name = "Name")
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Z]{1}[a-z ]+")
    private String surname;

    @Column(name = "Degree")
    @NotNull
    private Degree degree;

    public Profesor(String name, String surname, Degree degree) {
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }
}
