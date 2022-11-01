package net.yorksolutions.teams.service;

import net.yorksolutions.teams.dto.CreateTeamRequestDTO;
import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.entity.Team;
import net.yorksolutions.teams.repository.AccountRepository;
import net.yorksolutions.teams.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;
    private AccountRepository accountRepository;

    public TeamService(TeamRepository teamRepository, AccountRepository accountRepository) {
        this.teamRepository = teamRepository;
        this.accountRepository = accountRepository;
    }

    public Team create(CreateTeamRequestDTO requestDTO) {
        Optional<Account> accountOpt = this.accountRepository.findById(requestDTO.ownerId);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Team team = new Team(requestDTO.name, accountOpt.get());
        return this.teamRepository.save(team);
    }

    public Team get(Long id) {
        Optional<Team> teamOpt = this.teamRepository.findById(id);
        if (teamOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return teamOpt.get();
    }
}
