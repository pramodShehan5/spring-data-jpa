package com.pramod.springDataJpa.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "city",
                column = @Column(name = "city")
        ),
        @AttributeOverride(
                name = "houseNo",
                column = @Column(name = "houseNo")
        ),
        @AttributeOverride(
                name = "street",
                column = @Column(name = "street")
        )
})
public class Address {
    private String city;
    private String houseNo;
    private String street;
}