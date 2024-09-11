package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ThikBhai")
public class JournalEntryController {

    private Map<Long , JournalEntry > journalentries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getall(){
        return new ArrayList<>(journalentries.values());
    }

//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry ){
//
//
//      return true;
//    }

    @GetMapping("/id/{myid}")
    public JournalEntry getJournalById(@PathVariable Long myid ){
        return journalentries.get(myid);
    }
    @DeleteMapping("/delete/{myid}")
    public String deleteJournal(@PathVariable Long myid ){

         journalentries.remove(myid);
         return "CONTENT DELETE SUCCEUSFULLY ";
    }

    @PutMapping("id/{id}")
    public String updateit(@PathVariable Long id , @RequestBody JournalEntry Myentrr ){

        journalentries.put(id,Myentrr);

        return "THING HAS BEEN UPDATED SUCCEUSFULLY ";
    }

}