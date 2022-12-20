package com.example.inheritance.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EARTH")
public class EarthTypePokemon extends Pokemon {
}
