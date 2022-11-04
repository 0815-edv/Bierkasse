package de.dlrg.backend.Service;

import de.dlrg.backend.Entity.Ware;
import de.dlrg.backend.Enum.Direction;
import de.dlrg.backend.Logging.LogService;
import de.dlrg.backend.Repository.WareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareService {

    private WareRepository wareRepository;

    public WareService(WareRepository wareRepository) {
        this.wareRepository = wareRepository;
    }


    public void add(Ware ware){
        wareRepository.save(ware);
    }
    public void delete(Ware ware){
        wareRepository.delete(ware);
    }

    public List<Ware> get() {
        return wareRepository.findAll();
    }

    public Ware getbyId(long id){
        if(wareRepository.findById(id).isPresent()){
            return wareRepository.findById(id).get();
        }
        else{
            LogService.logger.error("Ware with ID: " + id +" not found");
            return null;
        }
    }

    public boolean create(String name, int anzahl) {
        if (!wareRepository.findWareByName(name).isPresent()) {
            Ware ware = new Ware();
            ware.setName(name);
            ware.setAnzahl(anzahl);

            wareRepository.save(ware);

            return true;
        }
        else {
            LogService.logger.error("Name of the ware already present");

            return false;
        }
    }

    public boolean delete(long id){
        if(wareRepository.findById(id).isPresent()){
            wareRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean changeCount(long id, int count, Direction direction){
        if(wareRepository.findById(id).isPresent()){
            Ware ware =wareRepository.findById(id).get();

            if(direction == Direction.add){
                ware.setAnzahl(ware.getAnzahl() + count);
                wareRepository.save(ware);
                LogService.logger.info("Count successfully increased");
                return true;
            }
            else if(direction == Direction.sub){
                if(ware.getAnzahl() > count) {
                    ware.setAnzahl(ware.getAnzahl() - count);
                    wareRepository.save(ware);
                    LogService.logger.info("Count successfully reduced");
                    return true;
                }
                else {
                    LogService.logger.error("WareCount too low to minimize");
                    return false;
                }
            }
        }
        return false;
    }




}
