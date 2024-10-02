package iesvdm.org.fighthub_service.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Size(min = 3, max = 20, message = "User name must be between 3 and 20 characters")
    @Column(unique = true)
    private String userName;

    @NotNull(message = "The birth date cannot be null")
    @Past(message = "The birth date must be in the past")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDate;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
