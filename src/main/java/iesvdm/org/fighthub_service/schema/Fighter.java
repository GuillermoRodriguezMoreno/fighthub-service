package iesvdm.org.fighthub_service.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters long")
    private String name;

    @NotNull(message = "Weight cannot be null")
    @Min(value = 20, message = "Weight must be at least 20")
    @Max(value = 200, message = "Maximum allowed weight is 200")
    private double weight;

    @NotNull(message = "Height cannot be null")
    @Min(value = 100, message = "Height must be at least 100")
    @Max(value = 300, message = "Maximum allowed Height is 300")
    private int height;

    // hacer enum
    private String gender;

    private String biography;

    @ManyToOne()
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "fightersParticipating", cascade = CascadeType.MERGE)
    @JsonIgnore
    @ToString.Exclude
    private Set<Event> eventsParticipated = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "fighter_style",
            joinColumns = @JoinColumn(name = "fighter_id"),
            inverseJoinColumns = @JoinColumn(name = "style_id")
    )
    @JsonIgnore
    private Set<Style> styles = new HashSet<>();

    @OneToMany(mappedBy = "blueCornerFighter", cascade = CascadeType.MERGE)
    @JsonIgnore
    @ToString.Exclude
    private Set<Fight> blueCornerFights = new HashSet<>();

    @OneToMany(mappedBy = "redCornerFighter", cascade = CascadeType.MERGE)
    @JsonIgnore
    @ToString.Exclude
    private Set<Fight> redCornerFights = new HashSet<>();
}
