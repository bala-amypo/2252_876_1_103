private Long id;
private String firstName;
private String lastName;
private String email;
private String role;
private List<String> skills;

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getEmail() { return email; }
public String getRole() { return role; }

public List<String> getSkills() { return skills; }

public void setFullName(String name) {
    String[] parts = name.split(" ");
    this.firstName = parts[0];
    this.lastName = parts.length > 1 ? parts[1] : "";
}

public String getFullName() {
    return firstName + " " + lastName;
}
