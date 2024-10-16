package com.dmpreroll.app.encounterbuilder.controller;

import com.dmpreroll.app.encounterbuilder.controller.request.MonsterRequest;
import com.open5e.client.ApiException;
import com.open5e.client.api.MonstersApi;
import com.open5e.client.model.ListMonsters200ResponseResultsInner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MainController {
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("applicationName", applicationName);
        model.addAttribute("request", new MonsterRequest());
        return "index";
    }

    @PostMapping("/")
    public String post(@ModelAttribute MonsterRequest request, Model model) {
        MonstersApi api = new MonstersApi();

        ListMonsters200ResponseResultsInner monster;
        try {
            monster = api.retrieveMonster(request.getSlug(),
                    request.getChallengeRating(),
                    request.getArmorClass(),
                    request.getType(),
                    request.getName(),
                    request.getPageNo(),
                    request.getDocument(),
                    request.getDocumentSlug(),
                    request.getOrdering(),
                    request.getSearch());

            model.addAttribute("monster", monster);
        } catch (ApiException e) {

            log.error("Error retrieving {}: {}", request, e.getMessage());
            model.addAttribute("monster", null);
        }

        model.addAttribute("applicationName", applicationName);
        model.addAttribute("request", request);
        return "index";
    }
}
