package tech.chillo.sa.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tech.chillo.sa.enums.TypeSentiment;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String texte;
   private TypeSentiment type;

   @JsonBackReference
   @ManyToOne(cascade = {PERSIST, MERGE})
   @JoinColumn(name = "CLIENT_ID")
   private Client client;

   public Sentiment() {

   }

   public Sentiment(int id, String texte, TypeSentiment type, Client client) {
      this.id = id;
      this.texte = texte;
      this.type = type;
      this.client = client;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTexte() {
      return texte;
   }

   public void setTexte(String texte) {
      this.texte = texte;
   }

   public TypeSentiment getType() {
      return type;
   }

   public void setType(TypeSentiment type) {
      this.type = type;
   }

   public Client getClient() {
      return client;
   }

   public void setClient(Client client) {
      this.client = client;
   }
}
