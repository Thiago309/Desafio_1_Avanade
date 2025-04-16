package restiapi.projeto1.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

/**
 * A GlobalExceptionHandler A classe GlobalExceptionHandler serve como um tratador global de exceções para a sua
 * aplicação. Isso significa que, quando ocorre um erro durante o processamento de uma requisição, essa classe
 * intercepta a exceção e retorna uma resposta HTTP apropriada ao cliente, evitando que detalhes técnicos sejam expostos.
 * Ela:
 * Torna o código dos controllers mais limpo.
 * Fornece respostas amigáveis e padronizadas para o cliente.
 * Evita que exceções sejam expostas de forma insegura.
*/

/* @RestControllerAdvice Marca a classe como um componente global de tratamento de exceções para os controllers REST.
   Funciona como um filtro de exceções lançadas nos endpoints.*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*  Indica qual exceção específica será tratada por cada metodo. Quando a aplicação lança um
        IllegalArgumentException (por exemplo, dados inválidos).*/
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        //  Retorna uma resposta com o erro (422 Unprocessable Entity) e a mensagem da exceção.
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    //  É executado quando um recurso não é encontrado no banco, geralmente com findById().
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        /*Retorna uma resposta com status 404 Not Found e uma mensagem padrão.*/
        return new ResponseEntity<>("ID do recurso não encontrado.", HttpStatus.NOT_FOUND);
    }

    //  Para qualquer exceção não tratada pelas anteriores.
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Erro inesperado do servidor, veja os logs.";
        //  Garante que a aplicação não quebre sem resposta, retornando 500 Internal Server Error
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}