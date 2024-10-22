import jakarta.validation.constraints.AssertTrue;
import org.example.Model.Deltager;
import org.example.Repository.DeltagerRepo;
import org.example.Service.PaameldingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    DeltagerRepo deltagerRepo;

    @InjectMocks
    PaameldingService paameldingService;



    Deltager e1 = new Deltager("12345678", "Test", "Testesen", "kvinne");
    Deltager e2 = new Deltager("87654321", "Kari", "Nordmann", "kvinne");
    Deltager e3 = new Deltager("12341234", "Ikke", "Med", "kvinne");

    @Test
    void finnBruker() {

        //Arrange
        when(deltagerRepo.findAll()).thenReturn(List.of(e1, e2));

        //Act
        List<Deltager> resultat = paameldingService.finnAlleDeltagere();

        //Assert
        assertEquals(2, resultat.size());
        assertTrue(resultat.contains(e2));
        assertFalse(resultat.contains(e3));

    }
    @Test
    void lagreBruker(){

        //Arrange
        when(deltagerRepo.save(e3)).thenReturn(e3);

        //Act
        Deltager saveDeltager = paameldingService.nyDeltager(e3);


        //Asert
        assertSame(saveDeltager, e3);
    }
    @Test
    void eksistererBruker(){
        //Arrange
        when(deltagerRepo.existsById("12341234")).thenReturn(true);

        //Act
        boolean idRiktig = paameldingService.eksistererDeltager("12341234");
        boolean idFeil = paameldingService.eksistererDeltager("88997766");

        //Assert
        assertTrue(idRiktig);
        assertFalse(idFeil);

    }










}
