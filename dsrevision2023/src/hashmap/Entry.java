package hashmap;

public class Entry {

    private Integer id;

    private String employee;

    public Entry(Integer id, String employee) {
        this.id = id;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", employee='" + employee + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
