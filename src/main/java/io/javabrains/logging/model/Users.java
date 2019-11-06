package io.javabrains.logging.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String teamName;
    private Integer salary;

    public Users(String name, String teamName, Integer salary) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }
}
