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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Column
    @NonNull
    private String patronymic;

    @Column
    @NonNull
    private Date registrationDate;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String phone;

    @Column
    @NonNull
    private String photoPath;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GenderCode")
    private Gender gender;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClientService> clientServices;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender=" + gender +
                '}';
    }
}
