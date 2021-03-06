package com.swapbookx.api.controllers;

import java.util.List;

import com.swapbookx.api.payloads.ApiResponse;
import com.swapbookx.api.payloads.LoginDto;
import com.swapbookx.api.payloads.UserDto;
import com.swapbookx.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserService userService;


    // Register Users
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);

        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // Login Users
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody LoginDto loginDto) {

        UserDto createLoginDto = this.userService.loginUser(loginDto);

        return new ResponseEntity<>(createLoginDto, HttpStatus.CREATED);
    }

    // Update User
    @PutMapping("/{userID}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userID") Integer uid)
    {
        UserDto updateUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updateUser);
    }

    //Delete User
    @DeleteMapping("/{userID}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userID") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted", true),HttpStatus.OK);
    }

    //Get All Users Details
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllusers());
    }

    //Get User based on his userID

    @GetMapping("/{userID}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable("userID") Integer uid){
        return ResponseEntity.ok(this.userService.getUserById(uid));
    }


}
