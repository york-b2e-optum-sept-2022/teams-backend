package net.yorksolutions.teams.controller;

import net.yorksolutions.teams.dto.CreateTeamRequestDTO;
import net.yorksolutions.teams.entity.Team;
import net.yorksolutions.teams.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team create(@RequestBody CreateTeamRequestDTO requestDTO) {
        return this.teamService.create(requestDTO);
    }

    @GetMapping
    public Team get(@RequestParam Long id) {
        return this.teamService.get(id);
    }
}
