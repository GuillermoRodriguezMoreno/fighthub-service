package iesvdm.org.fighthub_service.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters long")
    private String name;

    @NotBlank(message = "The description cannot be blank")
    @Size(min = 10, max = 255, message = "The description must be between 10 and 255 characters long")
    private String description;

    @NotBlank(message = "The address cannot be empty")
    private String address;

    @NotNull(message = "The start date cannot be null")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate startDate;

    @ManyToOne()
    @JoinColumn(name = "organizer_id", nullable = false)
    private Club organizer;

    @ManyToMany()
    @JoinTable(
            name = "event_fighter",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "fighter_id")
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<Fighter> fightersParticipating = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.MERGE)
    @ToString.Exclude
    private Set<Fight> fights = new HashSet<>();
}
