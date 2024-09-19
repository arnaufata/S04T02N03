package cat.itacademy.s04.t02.n03.model.services;

import cat.itacademy.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.s04.t02.n03.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita addFruita(Fruita fruita){
        return fruitaRepository.save(fruita);
    }

    public Fruita updateFruita(String id, Fruita fruita) throws NoSuchElementException {
        Fruita fruitaActualitzada = fruitaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fruita no trobada amb ID: " + id));

        fruitaActualitzada.setNom(fruita.getNom());
        fruitaActualitzada.setQuantitatQuilos(fruita.getQuantitatQuilos());
        return fruitaRepository.save(fruitaActualitzada);
    }

    public void deleteFruita(String id) throws Exception {
        fruitaRepository.deleteById(id);
    }

    public Fruita getFruitaByID(String id) throws NoSuchElementException {
        return fruitaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fruita no trobada amb ID: " + id));
    }

    public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }
}
