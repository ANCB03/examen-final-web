package com.examen.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    private int id;

    private String username;

    private String pass;

    private String email;
}
