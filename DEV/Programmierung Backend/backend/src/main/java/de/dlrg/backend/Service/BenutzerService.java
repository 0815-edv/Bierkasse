package de.dlrg.backend.Service;

import de.dlrg.backend.Entity.Benutzer;
import de.dlrg.backend.Enum.Direction;
import de.dlrg.backend.Logging.LogService;
import de.dlrg.backend.Repository.BenutzerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenutzerService {

    private BenutzerRepository benutzerRepository;

    public BenutzerService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }

    public void add(Benutzer benutzer){
        benutzerRepository.save(benutzer);
    }

    public void delete(Benutzer benutzer){
        benutzerRepository.delete(benutzer);
    }

    public List<Benutzer> get() {
        return benutzerRepository.findAll();
    }

    public void saveBenutzer(Benutzer benutzer){
        benutzerRepository.save(benutzer);
    }

    public Benutzer getbyId(long id) {
        if(benutzerRepository.findById(id).isPresent()){
            return benutzerRepository.findById(id).get();
        }
        else{
            LogService.logger.error("User with ID: " + id +" not found");
            return null;
        }

    }

    public Benutzer getbychipid(long id){
        if(benutzerRepository.findByChipid(id).isPresent()) {
            return benutzerRepository.findByChipid(id).get();
        }
        else {
            LogService.logger.error("User with CHIPID: " + id + " not found");
            return null;
        }
    }

    public boolean create(String vorname, String name, long chipid){
        if(!benutzerRepository.findByChipid(chipid).isPresent()) {
            Benutzer benutzer = new Benutzer();

            benutzer.setVorname(vorname);
            benutzer.setName(name);
            benutzer.setGuthaben(0);
            benutzer.setChipid(chipid);

            benutzerRepository.save(benutzer);

            LogService.logger.info("User created successfully");
            return true;
        }
        else{
            LogService.logger.error("User cannot create");
            return false;
        }
    }

    public Boolean change(long id, String name, String vorname, Long chipid) {

        if (benutzerRepository.findById(id).isPresent()){
            Benutzer benutzer = benutzerRepository.findById(id).get();
            if(name != null) {
                benutzer.setName(name);
            }
            if(vorname != null){
                benutzer.setVorname(vorname);
            }
            if(chipid != null){
                if (!benutzerRepository.findByChipid(chipid).isPresent()) {
                    benutzer.setChipid(chipid);
                }
                else
                {
                    benutzer.setChipid(0L);
                    LogService.logger.error("CHIPID cannot changed");
                }
            }

            benutzerRepository.save(benutzer);
            LogService.logger.info("User changed successfully");
            return true;

        }
        else {
            LogService.logger.error("User cannot changed");
            return false;
        }

    }

    public boolean deletebyid(long id){
        if(benutzerRepository.findById(id).isPresent()){
            benutzerRepository.deleteById(id);
            LogService.logger.info("User deleted successfully");
            return true;
        }
        else {
            LogService.logger.error("User not found by deleting");
            return false;
        }

    }

    public boolean changeCredit(long id, double credit, Direction direction){
        if (benutzerRepository.findById(id).isPresent()){

            Benutzer benutzer = benutzerRepository.findById(id).get();

            if(direction == Direction.add) {
                benutzer.setGuthaben(benutzer.getGuthaben() + credit);
                benutzerRepository.save(benutzer);
                LogService.logger.info("Credit successfully increased");
                return true;
            } else if (direction == Direction.sub) {

                if (benutzer.getGuthaben() > credit){
                    benutzer.setGuthaben(benutzer.getGuthaben() - credit);
                    LogService.logger.info("Credit successfully reduced");
                    return true;
                }
                else {
                    LogService.logger.error("Credit too low to minimize");
                    return false;
                }

            }
        }
        LogService.logger.error("Credit cannot change");
        return false;
    }



}



