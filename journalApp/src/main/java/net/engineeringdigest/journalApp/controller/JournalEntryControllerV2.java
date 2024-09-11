package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/Journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntrySerice;







    @GetMapping
    public List<JournalEntry> getall(){

        return journalEntrySerice.getall();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry ){

        try {
            myEntry.setDate(LocalDate.now());
            journalEntrySerice.saveEntry(myEntry);
            return new ResponseEntity<>(journalEntrySerice.get(myEntry), HttpStatus.CREATED);

        }catch( Exception e ){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntry> getJournalById(@PathVariable ObjectId myid ){


        Optional<JournalEntry> journalEntry = journalEntrySerice.findbyid(myid);
        if( journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/id/{myid}")
    public void deleteJournal(@PathVariable ObjectId myid){

       journalEntrySerice.deleteid(myid);

    }

    @PutMapping("id/{thisid}")
    public JournalEntry updateit(@PathVariable ObjectId thisid , @RequestBody JournalEntry myEntry ){

        JournalEntry old = journalEntrySerice.findbyid(thisid).orElse(null);
        if(old !=null ){
            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals("") ? myEntry.getTitle() : old.getTitle());
            old.setContent(myEntry.getContent() != null && !myEntry.getContent().equals("") ? myEntry.getContent() : old.getContent());
        }



        journalEntrySerice.saveEntry(old);
        return old;


    }

}