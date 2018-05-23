public class Rule {
    private String name;
    private RuleType type;
    private String description;

    public Rule(String name, RuleType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private RuleType getType() {
        return type;
    }

    public void setType(RuleType type) {
        this.type = type;
    }

    private String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return getName() + "||" + getType()+ "||" + getDescription();
    }
}
