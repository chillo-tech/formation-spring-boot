package tech.chillo.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client n'existe avec cet id")
        );
    }

    public Client lireOuCreer(Client clientAcreer){
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLaBDD == null) {
            clientDansLaBDD = this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;
    }

    public void modifier(int id, Client client) {
        Client clientDansLaBDD = this.lire(id);
        if(clientDansLaBDD.getId() == client.getId()) {
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
