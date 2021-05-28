package io.github.dps0340.paramstoquerydslexample.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;
}
