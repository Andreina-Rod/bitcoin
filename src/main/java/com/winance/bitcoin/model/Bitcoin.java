package com.winance.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bitcoin")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bitcoin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;
    @Column(name = "last_price")
    @Setter @Getter
    private Float lprice;
    @Column(name = "currency1")
    @Setter @Getter
    private String curr1;
    @Column(name = "currency2")
    @Setter @Getter
    private String curr2;
    @Column(name = "modified_date")
    @Setter @Getter
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;
}
