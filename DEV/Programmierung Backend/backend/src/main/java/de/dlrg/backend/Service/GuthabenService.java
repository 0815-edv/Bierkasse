package de.dlrg.backend.Service;

import de.dlrg.backend.Entity.Benutzer;
import de.dlrg.backend.Entity.GuthabenAuftraege;
import de.dlrg.backend.Entity.GuthabenRevision;
import de.dlrg.backend.Enum.AcceptEnum;
import de.dlrg.backend.Repository.GuthabenRepository;
import de.dlrg.backend.Repository.RevisionRepository;
import de.dlrg.backend.Time.sqlTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuthabenService {

    private GuthabenRepository guthabenRepository;

    private RevisionRepository revisionRepository;

    private BenutzerService benutzerService;

    public GuthabenService(GuthabenRepository guthabenRepository, RevisionRepository revisionRepository, BenutzerService benutzerService) {
        this.guthabenRepository = guthabenRepository;
        this.revisionRepository = revisionRepository;
        this.benutzerService = benutzerService;
    }

    public List<GuthabenAuftraege> getAuftröge(){
        return guthabenRepository.findAll();
    }

    public List<GuthabenRevision> getRevision(){
        return revisionRepository.findAll();
    }


    public boolean offer (long user_id, double wert){

        if(benutzerService.getbyId(user_id) != null){
            Benutzer user;
            GuthabenAuftraege guthabenAuftraege = new GuthabenAuftraege();
            sqlTime sqltime = new sqlTime();
            user = benutzerService.getbyId(user_id);
            guthabenAuftraege.setBenutzerAuftrag(user);
            guthabenAuftraege.setAddDatum(sqltime.getSqlDate());
            guthabenAuftraege.setWert(wert);
            guthabenRepository.save(guthabenAuftraege);
            return true;
        }
        return false;

    }

    public boolean offerService(long offer_id, AcceptEnum offerHandling){
        if(guthabenRepository.findById(offer_id).isPresent()){
            GuthabenAuftraege auftrag = guthabenRepository.findById(offer_id).get();
            Benutzer benutzer = auftrag.getBenutzerAuftrag();
            sqlTime sqltime = new sqlTime();
            GuthabenRevision revision = new GuthabenRevision();

            if(offerHandling == AcceptEnum.accept){
                 benutzer.setGuthaben(benutzer.getGuthaben() + auftrag.getWert());
                 benutzerService.saveBenutzer(benutzer);
                 revision.setStatus(AcceptEnum.accept);

            }
            if (offerHandling == AcceptEnum.deny){
                revision.setStatus(AcceptEnum.deny);
            }

            revision.setBenutzerRevision(benutzer);
            revision.setWert(auftrag.getWert());
            revision.setAcceptDate(sqltime.getSqlDate());
            revisionRepository.save(revision);
            guthabenRepository.delete(auftrag);
            return true;


        }
        return false;
    }


}
