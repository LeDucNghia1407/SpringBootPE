package com.System.PharmacyManagement.models;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@Entity
public class DrugStore {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(
            name = "drugStore_sequence",
            sequenceName = "drugStore_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "drugStore_sequence"
    )
    private long id;

    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String address;


    @ManyToOne
    @JoinColumn(name = "drugSupplierID",nullable = true)
    private DrugSupplier drugSupplier;

    public DrugStore() {}
    public DrugStore(long id, String name, String address, DrugSupplier drugSupplier) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.drugSupplier = drugSupplier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DrugSupplier getDrugSupplier() {
        return drugSupplier;
    }

    public void setDrugSupplier(DrugSupplier drugSupplier) {
        this.drugSupplier = drugSupplier;
    }
}
