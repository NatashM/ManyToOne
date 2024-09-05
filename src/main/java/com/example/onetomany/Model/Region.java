package com.example.onetomany.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Region {
@Id
@Column(length = 4)
    private String kode;
@Column(nullable = false)
    private String navn;
    private String href;
    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "kode")
    private Region region;

   @OneToMany(mappedBy = "region")

   @JsonBackReference
   private Set<Kommune> kommuner = new HashSet<>();

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


}
