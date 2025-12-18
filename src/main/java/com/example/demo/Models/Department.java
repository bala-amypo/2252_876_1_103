@Entity
public class Department {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String name;


private String description;
private String requiredSkills;


private LocalDateTime createdAt = LocalDateTime.now();
}