@Entity
public class GeneratedShiftSchedule {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private LocalDate shiftDate;
private LocalTime startTime;
private LocalTime endTime;


@ManyToOne private ShiftTemplate shiftTemplate;
@ManyToOne private Department department;
@ManyToOne private Employee employee;
}