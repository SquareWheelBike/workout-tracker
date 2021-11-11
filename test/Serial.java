import java.io.Serializable;

public class Serial implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Serial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serial serial = (Serial) o;

        return name != null ? name.equals(serial.name) : serial.name == null;
    }
}
