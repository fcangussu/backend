package br.com.fiap.api.repository;

import br.com.fiap.api.model.Mensagem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class MensagemRepositoryTest {

    AutoCloseable openMock;
    @Mock
    private MensagemRepository mensagemRepository;

    @BeforeEach
    void setup() {
        openMock = MockitoAnnotations.openMocks(this); //vai INICIAR todos mocks desta classe - quem possui a anotacao @Mock.
    }

    @AfterEach
    void tearDown() throws Exception {
        openMock.close();
    }

    @Test
    void devePermitirRegistarMensagem() {
        //Arrange
        var mensagem = Mensagem.builder()
                .id(UUID.randomUUID())
                .usuario("Jose")
                .conteudo("1. CONTEUDO DA MENSAGEM")
                .build();

        when(mensagemRepository.save(any(Mensagem.class))).thenReturn(mensagem);
        //Act
        var mensagemRegistrada = mensagemRepository.save(mensagem);
        //Assert
         assertThat (mensagemRegistrada).isNotNull().isEqualTo(mensagem);

         verify(mensagemRepository,times(1)).save(any(Mensagem.class));

    }

    @Test
    void devePermitirAlterarMensagem() {
        fail(" *********** 2.TESTE NAO IMPLMENTADO !!!  *********** \n");
    }

    @Test
    void devePermitirRemoverMensagem() {
        fail(" *********** 3.TESTE NAO IMPLMENTADO !!!  *********** \n");
    }

    @Test
    void devePermitirBuscarMensagem() {
        fail(" *********** 4.TESTE NAO IMPLMENTADO !!!  *********** \n");
    }

}
