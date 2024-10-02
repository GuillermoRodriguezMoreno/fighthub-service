package iesvdm.org.fighthub_service.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Min(value = 1, message = "The fight order must be at least 1")
    private int fightOrder;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isTitleFight;

    private double weight;

    @ManyToOne
    @JoinColumn(name = "blue_corner_fighter_id")
    private Fighter blueCornerFighter;

    @ManyToOne
    @JoinColumn(name = "red_corner_fighter_id")
    private Fighter redCornerFighter;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;
}
