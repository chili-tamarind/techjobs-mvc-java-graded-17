package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TO-DO #3 - Create a handler to process a search request and render the updated search view
    @PostMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        ArrayList<Job> jobs;
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);

        // If the user enters “all” in the search box, or if they leave the box empty, call the findAll() method from JobData.
        if (searchTerm.equals("all") || searchTerm.isEmpty()) {
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        }
        // Otherwise, send the search information to findByColumnAndValue
        else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }

        //Pass jobs into the search.html view via the model parameter.
        model.addAttribute("jobs", jobs);

        //Pass ListController.columnChoices into the view, as the existing search handler does.
        model.addAttribute("columns", columnChoices);

        return "search";
    }
}

