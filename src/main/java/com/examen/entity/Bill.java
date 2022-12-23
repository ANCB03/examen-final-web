package com.examen.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    private int id;

    private Date date_bill;

    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private User user_id;

    private int value;

    private int type;

    private String observation;


}
