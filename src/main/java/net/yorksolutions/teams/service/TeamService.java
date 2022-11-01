package net.yorksolutions.teams.service;

import net.yorksolutions.teams.entity.Team;
import net.yorksolutions.teams.repository.AccountRepository;
import net.yorksolutions.teams.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TeamService {

    private TeamRepository teamRepository;
    private AccountRepository accountRepository;

    public TeamService(TeamRepository teamRepository, AccountRepository accountRepository) {
        this.teamRepository = teamRepository;
        this.accountRepository = accountRepository;
    }

    public Team create(Team newTeam) {
        return this.teamRepository.save(newTeam);
    }
}
