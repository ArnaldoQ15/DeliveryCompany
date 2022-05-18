package com.deliverycompany.api.exceptionhandler;

import java.io.Serial;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L; // Permite a serialização e desserialização do objeto.
    // Basicamente gera um código único que é o serial para a classe

    public BusinessException(String message) {
        super(message);
    }

}
