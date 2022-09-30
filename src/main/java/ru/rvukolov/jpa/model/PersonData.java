package ru.rvukolov.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class PersonData implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
