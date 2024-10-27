package org.launchcode.techjobsmvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.HashMap;

// You do NOT need to add the @Controller annotation to this class.
public class TechJobsController {

//    This new controller should have a static HashMap, populated via a no-argument constructor
    static HashMap<String , String> actionChoices = new HashMap<>();

//    Update your code so that columnChoices also lives in TechJobsController
    static HashMap<String, String> columnChoices = new HashMap<>();

//    Write a static method getActionChoices that returns the actions HashMap -- with Getter
//    The @ModelAttribute("actions") will cause the return value of the method to be set in the model with key "actions"
//    for every controller that extends TechJobsController.

    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoices(Model model) {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
        model.addAttribute("actions", actionChoices);
        model.addAttribute("columns", columnChoices);

        return actionChoices;
    }

//    Modify every one of your other controllers to extend TechJobsController.
//    Modify fragments.html to use the passed-in action choices to generate the navigation links.

}
