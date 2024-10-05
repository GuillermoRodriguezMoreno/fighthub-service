package iesvdm.org.fighthub_service.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters long")
    private String name;

    @NotNull(message = "The address cannot be null")
    private String address;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "The description cannot be blank")
    @Size(min = 10, max = 255, message = "The description must be between 10 and 255 characters long")
    private String description;

    private String phone;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.MERGE)
    @JsonIgnore
    @ToString.Exclude
    private Set<Event> eventsOrganized = new HashSet<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.MERGE)
    @JsonIgnore
    @ToString.Exclude
    private Set<Fighter> fighters = new HashSet<>();
}
