package de.dlrg.backend.Service;

import de.dlrg.backend.Entity.Benutzer;
import de.dlrg.backend.Entity.Kaufe;
import de.dlrg.backend.Entity.Ware;
import de.dlrg.backend.Repository.BenutzerRepository;
import de.dlrg.backend.Repository.KaufeRepository;
import de.dlrg.backend.Repository.WareRepository;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaufeService {

    private BenutzerRepository benutzerRepository;
    private WareRepository wareRepository;
    private KaufeRepository kaufeRepository;

    public KaufeService(BenutzerRepository benutzerRepository, WareRepository wareRepository, KaufeRepository kaufeRepository) {
        this.benutzerRepository = benutzerRepository;
        this.wareRepository = wareRepository;
        this.kaufeRepository = kaufeRepository;
    }

    public List<Kaufe> get(){
        return kaufeRepository.findAll();
    }

    public boolean add(long userid, long wareid){
        if(benutzerRepository.findById(userid).isPresent() && wareRepository.findById(wareid).isPresent()){
            Benutzer benutzer = benutzerRepository.findById(wareid).get();
            Ware ware = wareRepository.findById(wareid).get();
            Kaufe kauf = new Kaufe();
            sqlTime sqltime = new sqlTime();

            if(benutzer.getGuthaben() >0 && ware.getAnzahl() > 0){
                ware.setAnzahl(ware.getAnzahl() - 1);
                wareRepository.save(ware);

                kauf.setDatum(sqltime.getSqlDate());
                kauf.setUser(benutzer);
                kauf.setWare(ware);
                return true;
            }
            return false;

        }
        return false;
    }

}
