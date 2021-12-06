package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "FavoriteDoctor")
@Entity
@Getter
@Setter
public class FavoriteDoctor {
    @EmbeddedId
    private FavoriteDoctorKey id;


    public FavoriteDoctor(FavoriteDoctorKey id) {
        this.id = id;
    }

    public FavoriteDoctor() {

    }
}
