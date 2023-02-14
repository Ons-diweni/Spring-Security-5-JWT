package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Evenement;
import tn.esprit.kaddemspringbootproject.repositories.IEvenenemtDao;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service @Transactional
public class EvenementServices implements IEvenementServices{

    private final IEvenenemtDao iEvenenemtDao ;
    @Override
    public Evenement addOrSaveOne(Evenement event) {
        return iEvenenemtDao.save(event);
    }

    @Override
    public void deleteOneById(Integer idEvent) {
     iEvenenemtDao.deleteById(idEvent);
    }

    @Override
    public List<Evenement> getAll() {
        return iEvenenemtDao.findAll();
    }

    @Override
    public List<Evenement> getEventsByUniv(String nomUniv) {
     return iEvenenemtDao.findAllByUniversite_NomUniv(nomUniv);
    }

    @Override
    public Evenement AddEventAddUnivAndAffect(Evenement evenement) {

       return iEvenenemtDao.save(evenement);


    }


}
