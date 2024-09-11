package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;


    public void saveEntry(JournalEntry entry ){

        journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getall(){

        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findbyid(ObjectId id ){
        return journalEntryRepo.findById(id);
    }

    public void deleteid(ObjectId id ){

        journalEntryRepo.deleteById(id);
    }


    public JournalEntry get(JournalEntry myEntry) {

        return journalEntryRepo.findById(myEntry);
    }
}
