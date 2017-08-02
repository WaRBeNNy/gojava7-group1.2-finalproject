import annotations.JsonIgnore;
import annotations.JsonProperty;

public class Developer {
    public String name;
    @JsonIgnore
    public int age;

    private Double salary;
    @JsonProperty
    private Double bonuses;
    transient Boolean isFriendly;
    @JsonProperty(name = "Not afraid of hard work")
    transient Boolean isHardWorker;

    public Developer(String name, int age, Double salary, Double bonuses, Boolean isFriendly, Boolean isHardWorker) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonuses = bonuses;
        this.isFriendly = isFriendly;
        this.isHardWorker = isHardWorker;
    }
}
