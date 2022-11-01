package net.yorksolutions.teams.controller;

import net.yorksolutions.teams.dto.CreateAddressRequestDTO;
import net.yorksolutions.teams.entity.Account;
import net.yorksolutions.teams.entity.Address;
import net.yorksolutions.teams.service.AccountService;
import net.yorksolutions.teams.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public Address create(@RequestBody CreateAddressRequestDTO requestDTO) {
        return this.addressService.create(requestDTO);
    }

    @GetMapping
    public Address get(@RequestParam Long id) {
        return this.addressService.get(id);
    }

}
