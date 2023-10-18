package tech.chillo.sa.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    @Column(unique = true)
    private String email;
    private String telephone;
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date misAjour;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Sentiment> sentiments;

    public Client() {
    }

    public Client(int id, String email, String telephone, Date creation, Date misAjour, List<Sentiment> sentiments) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAjour = misAjour;
        this.sentiments = sentiments;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getMisAjour() {
        return misAjour;
    }

    public void setMisAjour(Date misAjour) {
        this.misAjour = misAjour;
    }

    public List<Sentiment> getSentiments() {
        return sentiments;
    }

    public void setSentiments(List<Sentiment> sentiments) {
        this.sentiments = sentiments;
    }

}
