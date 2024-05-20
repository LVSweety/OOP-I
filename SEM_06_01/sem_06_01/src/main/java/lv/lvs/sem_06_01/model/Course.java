package lv.lvs.sem_06_01.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "CourseTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
    @Column(name = "IdC")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private int idC;

    @Column(name = "Title")
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-z ]+")
    private String title;

    @Min(0)
    @Max(20)
    @Column(name = "ELC")
    private int elc;

    @ManyToMany
    @JoinTable(name = "CourseOwnership",
	joinColumns = @JoinColumn(name = "IdC"),
	inverseJoinColumns = @JoinColumn(name = "IdP"))
    private Collection<Profesor> profesors = new ArrayList<Profesor>();

	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;

    public Course(String title, int elc, Profesor ... profesors) {
        setTitle(title);
        setElc(elc);
        for(Profesor prof : profesors)
            addProfesor(prof);
    }

    public Course(String title, int elc) {
        setTitle(title);
        setElc(elc);
    }

    public void addProfesor(Profesor profesor) {
        if(!profesors.contains(profesor)) profesors.add(profesor);
    }

    public void removeProfesor(Profesor profesor) {
        if (profesors.contains(profesor)) profesors.remove(profesor);
    }
}
