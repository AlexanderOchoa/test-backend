package test.backend.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.backend.dto.GenericResponse;
import test.backend.dto.SaveMessageRequest;
import test.backend.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    private final MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Endpoint to save user.
     */
    @PostMapping
    public ResponseEntity<GenericResponse> save(@RequestBody SaveMessageRequest request) {
        GenericResponse response = messageService.save(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint to list messages.
     */
    @GetMapping(value = "/{userId}")
    public ResponseEntity<GenericResponse> get(@PathVariable Long userId, @RequestParam Long page) {
        GenericResponse response = messageService.get(userId, page);
        return ResponseEntity.ok(response);
    }
}
