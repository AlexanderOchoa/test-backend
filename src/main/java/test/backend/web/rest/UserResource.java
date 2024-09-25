package test.backend.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.backend.dto.GenericResponse;
import test.backend.dto.SaveUserRequest;
import test.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to save user.
     */
    @PostMapping
    public ResponseEntity<GenericResponse> save(@RequestBody SaveUserRequest request) {
        GenericResponse response = userService.save(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint to list.
     */
    @GetMapping(value = "/{userId}")
    public ResponseEntity<GenericResponse> get(@PathVariable Long userId) {
        GenericResponse response = userService.get(userId);
        return ResponseEntity.ok(response);
    }
}
