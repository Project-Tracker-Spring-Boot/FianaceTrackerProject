package com.fintrack.project.expense;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import static jakarta.persistence.EnumType.STRING;
@Entity
@NoArgsConstructor

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double amount;
    @Enumerated(STRING)
    public TYPE type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date date ;


    public enum TYPE {

        Bill {
            @Override
            public String toString(){return "Bill"; }
        }, Entertainment {
            @Override
            public String toString () {return "Entertainment";}
        }, Education{
            @Override
            public String toString() { return "Education" ;}
        }, Travel {
            @Override
            public String toString () { return  "Travel"; }
        }
    }
}
