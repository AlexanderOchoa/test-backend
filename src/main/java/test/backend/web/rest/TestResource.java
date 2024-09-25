package test.backend.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.backend.service.TestService;

@RestController
@RequestMapping
public class TestResource {

    private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    /**
     * Endpoint para probar que la conexión a backend y a la bd funciona correctamente.
     */
    @GetMapping("test")
    public ResponseEntity<String> test() throws Exception {
        testService.testDB();
        return ResponseEntity.ok("Conexión con backend exitosa!");
    }
}
