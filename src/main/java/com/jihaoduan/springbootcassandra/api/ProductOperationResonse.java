package com.jihaoduan.springbootcassandra.api;

import java.util.UUID;

public class ProductOperationResonse {
    private final String message;
    private final UUID productId;


    public ProductOperationResonse(String message, UUID productId) {
        this.message = message;
        this.productId = productId;
    }

    public String getMessage() {
        return this.message;
    }


    public UUID getProductId() {
        return this.productId;
    }


    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

}
