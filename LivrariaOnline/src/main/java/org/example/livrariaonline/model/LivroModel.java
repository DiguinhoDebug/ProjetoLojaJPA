package org.example.livrariaonline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LivroModel {

    @Id
    private String id

}
