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
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private int discount;

    @Column
    @NonNull
    private String  description;

    @Column
    @NonNull
    private int cost;

    @Column
    @NonNull
    private int durationInSecond;

    @Column
    @NonNull
    private String mainImagePath;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClientService> clientServices;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", durationInSecond=" + durationInSecond +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
