@Entity
public class ShiftTemplate {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String templateName;
private LocalTime startTime;
private LocalTime endTime;
private String requiredSkills;


@ManyToOne
private Department department;
}