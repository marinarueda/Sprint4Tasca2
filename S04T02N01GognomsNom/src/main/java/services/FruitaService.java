package services;

import domain.Fruita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FruitaRepository;

import java.util.List;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public boolean addFruita(Fruita fruita) {
        try {
            fruitaRepository.save(fruita);
            return true; // L'operació s'ha realitzat amb èxit
        } catch (Exception e) {
            // Aquí pots gestionar l'error o registrar-lo en algun lloc
            return false; // L'operació ha fallat
        }
    }

    public boolean updateFruita(Fruita fruita) {
        try {
            if (fruitaRepository.existsById(fruita.getId())) {
                fruitaRepository.save(fruita);
                return true; // L'operació s'ha realitzat amb èxit
            } else {
                return false; // No s'ha trobat la fruita per actualitzar
            }
        } catch (Exception e) {
            // Aquí pots gestionar l'error o registrar-lo en algun lloc
            return false; // L'operació ha fallat
        }
    }

    public void deleteFruita(int id) {
        fruitaRepository.deleteById(id);
    }

    public Fruita getFruitaById(int id) {
        return fruitaRepository.findById(id).orElse(null);
    }

    public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }
}
