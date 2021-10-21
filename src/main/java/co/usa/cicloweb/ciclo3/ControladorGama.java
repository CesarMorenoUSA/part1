/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.cicloweb.ciclo3;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cesar
 */
@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorGama {
    @Autowired
    private ServiciosGama servicio;
    @GetMapping("/all")
    public List<Gama> getGamas(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id") int gamaId) {
        return servicio.getGama(gamaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama) {
        return servicio.save(gama);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama) {
        return servicio.update(gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaId) {
        return servicio.deleteGama(gamaId);
    }    
}
