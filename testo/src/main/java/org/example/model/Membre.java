package org.example.model;

public class Membre {
    private String nom;
    private boolean cotisationPayee;
    private int livresLusCeMois;

    public Membre(String nom) {
        this.nom = nom;
        this.cotisationPayee = false;
        this.livresLusCeMois = 0;
    }

    public void payerCotisation() {
        this.cotisationPayee = true;
    }

    public void ajouterLivreLu() {
        this.livresLusCeMois += 1;
    }

    public boolean aPayeCotisation() {
        return cotisationPayee;
    }

    public boolean aAtteintQuotaLivres(int quota) {
        return livresLusCeMois >= quota;
    }
}
