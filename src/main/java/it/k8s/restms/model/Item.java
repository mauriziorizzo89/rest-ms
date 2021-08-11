package it.k8s.restms.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private int anni;

}
