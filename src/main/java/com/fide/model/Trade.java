package com.fide.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Trade implements Serializable {

    private static final long serialVersionUID = -2824620874805070559L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String symbol;
    private Integer shares;
    private Float price;
    private Timestamp timestamp;

    @OneToOne()
    @JoinColumn(name = "id")
    private User user;
}
