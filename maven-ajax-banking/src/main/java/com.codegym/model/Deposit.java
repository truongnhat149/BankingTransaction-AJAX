package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    private Date created_at = new Date();

    private Long create_by ;

    @Digits(integer= 12,fraction= 0)
    private BigDecimal transaction_amount;

    private boolean isDelete = false ;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    private Date update_at = new Date();

    private Long update_by ;



    public Deposit(Long id, Customer customer, BigDecimal transaction_amount) {
        this.id = id;
        this.customer = customer;
        this.transaction_amount = transaction_amount;
    }
    public Deposit(Long id, BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
        this.id = id ;
    }
    public Deposit( BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

}
