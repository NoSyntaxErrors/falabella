package com.falabella.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String message;
    private Object response;
}
