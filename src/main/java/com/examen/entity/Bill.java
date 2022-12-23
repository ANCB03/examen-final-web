package com.examen.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private Date date_bill;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private User user_id;

    private int value;

    private int type;

    private String observation;


}
