package clinica.service.impl;

import clinica.exceptions.ResourceNotFoundException;
import clinica.model.DomicilioDTO;
import clinica.model.PacienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
  @Autowired
  private PacienteService pacienteService;
  private PacienteDTO paciente;
  
  @BeforeEach
  void setUp() {
    paciente = new PacienteDTO("Alejo", "Corti", "12345678", LocalDate.now());
    DomicilioDTO domicilio = new DomicilioDTO("Corrientes", 6787, "CABA", "BS AS");
    paciente.setDomicilio(domicilio);
  }
  
  @Test
  void guardar() throws Exception {
    PacienteDTO pacienteGuardado = pacienteService.guardar(paciente);
    assertNotNull(pacienteService.buscar(pacienteGuardado.getId()));
  }
  
  @Test
  void buscar() throws Exception {
    PacienteDTO pacienteGuardado = pacienteService.guardar(paciente);
    PacienteDTO pacienteBuscado = pacienteService.buscar(pacienteGuardado.getId());
    assertEquals(pacienteGuardado, pacienteBuscado);
  }
  
  @Test
  void actualizar() throws Exception {
    PacienteDTO pacienteGuardado = pacienteService.guardar(paciente);
    pacienteGuardado.setNombre("Alejo");
    pacienteGuardado.setApellido("Corti");
    pacienteGuardado.setCedula("87654321");
    pacienteGuardado.setFechaDeIngreso(LocalDate.now());
    pacienteGuardado.getDomicilio().setCalle("Corrientes");
    pacienteGuardado.getDomicilio().setNumero(6787);
    pacienteGuardado.getDomicilio().setLocalidad("CABA");
    pacienteGuardado.getDomicilio().setProvincia("BS AS");
    PacienteDTO pacienteActualizado = pacienteService.actualizar(pacienteGuardado);
    assertEquals(pacienteGuardado, pacienteActualizado);
  }
  
  @Test
  void eliminar() throws Exception {
    PacienteDTO pacienteGuardado = pacienteService.guardar(paciente);
    pacienteService.eliminar(pacienteGuardado.getId());
    assertThrows(ResourceNotFoundException.class, () -> pacienteService.buscar(pacienteGuardado.getId()));
  }
  
  @Test
  void buscarTodos() throws Exception {
    pacienteService.guardar(paciente);
    assertNotEquals(0, pacienteService.buscarTodos().size());
  }
}