package ru.rvukolov.jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Entity
@Table
@EqualsAndHashCode
public class Person {
    @EmbeddedId
    private PersonData personData;
    private String phoneNumber;
    private String cityOfLiving;
}
