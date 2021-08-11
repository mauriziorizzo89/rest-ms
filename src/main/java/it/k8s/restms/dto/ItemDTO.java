package it.k8s.restms.dto;

import lombok.Data;

@Data
public class ItemDTO {

    private int id;
    private String nome;
    private String cognome;
    private int anni;

}
