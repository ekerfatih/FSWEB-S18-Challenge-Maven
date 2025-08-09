package com.workintech.fswebs18challengemaven.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardErrorResponse {
    int status;
    String message;
    long timeStamp;

    public CardErrorResponse(String message) {
        this.message = message;
    }
}
