@Entity
public class Employee {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String email;


private String fullName;
private String role = "STAFF";
private String skills; // comma separated
private Integer maxWeeklyHours;


private LocalDateTime createdAt = LocalDateTime.now();
}