@Entity
public class EmployeeAvailability {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private Employee employee;


private LocalDate availableDate;
private boolean available;
}