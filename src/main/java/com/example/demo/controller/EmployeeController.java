@GetMapping("/list")
public List<Employee> list() {
    return employeeService.getAllEmployees();
}
