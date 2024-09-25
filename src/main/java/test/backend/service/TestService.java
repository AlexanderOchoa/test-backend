package test.backend.service;

import org.springframework.stereotype.Service;
import test.backend.repository.TestRepository;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * Servicio para probar que la conexión a backend y a la bd funciona correctamente.
     *
     * @return
     */
    public void testDB() throws Exception {
        try {
            testRepository.findById(1L).orElseThrow();
        } catch (Exception e) {
            throw new Exception("Base de datos no inicializada");
        }

    }
}
