package net.yorksolutions.teams.service;

import net.yorksolutions.teams.dto.CreateAddressRequestDTO;
import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.entity.Address;
import net.yorksolutions.teams.repository.AccountRepository;
import net.yorksolutions.teams.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AddressService {

    AddressRepository addressRepository;
    AccountRepository accountRepository;

    public AddressService(AddressRepository addressRepository, AccountRepository accountRepository) {
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    public Address get(Long id) {
        Optional<Address> addressOp = this.addressRepository.findById(id);
        if (addressOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return addressOp.get();
    }

    public Address create(CreateAddressRequestDTO requestDTO) {
        Optional<Account> accountOp = this.accountRepository.findById(requestDTO.accountId);
        if (accountOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Address address = new Address(accountOp.get());
        accountOp.get().setAddress(address);

        return this.addressRepository.save(address);
    }
}
