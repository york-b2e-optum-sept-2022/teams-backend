package net.yorksolutions.teams.controller;

import net.yorksolutions.teams.entity.Team;
import net.yorksolutions.teams.service.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team create(@RequestBody Team newTeam) {
        return this.teamService.create(newTeam);
    }


}
