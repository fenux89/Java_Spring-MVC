package entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class User implements Serializable {
    private String name;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }
}
