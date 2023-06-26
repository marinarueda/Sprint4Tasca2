package controllers;

import domain.Fruita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.FruitaService;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<String> addFruita(@RequestBody Fruita fruita) {
        fruitaService.addFruita(fruita);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fruita afegida amb èxit.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFruita(@RequestBody Fruita fruita) {
        fruitaService.updateFruita(fruita);
        return ResponseEntity.status(HttpStatus.OK).body("Fruita actualitzada amb èxit.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruita(@PathVariable int id) {
        fruitaService.deleteFruita(id);
        return ResponseEntity.status(HttpStatus.OK).body("Fruita eliminada amb èxit.");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable int id) {
        Fruita fruita = fruitaService.getFruitaById(id);
        if (fruita != null) {
            return ResponseEntity.status(HttpStatus.OK).body(fruita);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        List<Fruita> fruites = fruitaService.getAllFruites();
        return ResponseEntity.status(HttpStatus.OK).body(fruites);
    }
}

