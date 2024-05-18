package streaming.streaming;

public class Film {

    public Film(String nom, String description, int ageMin, int duree, int anneSotrie, String bandeAnonce) {
        this.nom = nom;
        this.description = description;
        this.ageMin = ageMin;
        this.duree = duree;
        this.anneSotrie = anneSotrie;
        this.bandeAnonce = bandeAnonce;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getAnneSotrie() {
        return anneSotrie;
    }

    public void setAnneSotrie(int anneSotrie) {
        this.anneSotrie = anneSotrie;
    }

    public String getBandeAnonce() {
        return bandeAnonce;
    }

    public void setBandeAnonce(String bandeAnonce) {
        this.bandeAnonce = bandeAnonce;
    }

    public String nom;
    public String description;
    public int ageMin;
    public int duree;
    public int anneSotrie;
    public String bandeAnonce;

}
