package com.digital.catering.domain.exception.reservation;

import lombok.Getter;

@Getter
public class NoValidResourceException extends RuntimeException{

    public enum NoValidResourceType{
        RESERVATION_DATE_NOT_VALID("Reservation date not valid"),
        GEOGRAPHIC_COORDINATE_NOT_VALID("Geographic coordinate not valid");
        private final String message;

        public NoValidResourceException build(Throwable throwable){
            return new NoValidResourceException(this, throwable);
        }

        NoValidResourceType(String message){
            this.message = message;
        }
    }

    private final NoValidResourceType type;

    private NoValidResourceException(NoValidResourceType noValidResourceType, Throwable throwable){
        super(noValidResourceType.message, throwable);
        this.type = noValidResourceType;
    }
}
