package nl.Eindopdracht.BoogieWoogie.Controller;

import nl.Eindopdracht.BoogieWoogie.Domain.PositionOnStage;
import nl.Eindopdracht.BoogieWoogie.Domain.Prop;
import nl.Eindopdracht.BoogieWoogie.Exception.PropNotFoundException;
import nl.Eindopdracht.BoogieWoogie.Persistance.PropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PropsController {

    @Autowired
    private PropRepo propRepo;

    @GetMapping(value = "/api/prop")
    public List<Prop> getAllProps() {
        return propRepo.findAll();
    }

    @GetMapping(value = "/api/prop/{id}")
    public Prop getProp(@PathVariable long id) {
        Optional<Prop> prop = propRepo.findById(id);
        if(prop.isPresent()) {
            return prop.get();
        } else {
            return null;
        }
    }

    @PostMapping(value = "/api/prop")
    public Prop addProp(@RequestBody Prop newProp) {
        return propRepo.save(newProp);
    }

    @PostMapping(value = "/api/prop/test")
    public Prop addTestProp() {
        Prop prop = new Prop();
        prop.setPosition(PositionOnStage.STAGE_LEFT);
        prop.setPropUser("Anne-Will Blankers");
        prop.setPresetBy("Anne-Will Blankers");

        return propRepo.save(prop);
    }

    @DeleteMapping(value = "/api/prop/{id}")
    public String deleteProp(@PathVariable long id) {
        Optional<Prop> prop = propRepo.findById(id);

        if(prop.isPresent()) {
            propRepo.deleteById(id);
            return "Prop with id " + prop.get().getPropId() + " is deleted.";
        }
        throw new PropNotFoundException("No prop found with that id");
    }

    @PutMapping(value = "/api/prop/{id}")
    public Prop updatePropById(@PathVariable long id, @RequestBody Prop updateProp) {
        return propRepo.findById(id).map(
                prop -> {
                    prop.setPosition(updateProp.getPosition());
                    prop.setPropUser(updateProp.getPropUser());
                    prop.setPresetBy(updateProp.getPresetBy());
                    return propRepo.save(updateProp);
                })
                .orElseGet(() -> {
                    updateProp.setPropId(id);
                    return propRepo.save(updateProp);
                });
    }
}
