package ru.sapteh.models;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private char code;

    @Column
    @NonNull
    private String name;

    @OneToMany(mappedBy = "gender", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Client> clients;

    @Override
    public String toString() {
        return "Gender{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
