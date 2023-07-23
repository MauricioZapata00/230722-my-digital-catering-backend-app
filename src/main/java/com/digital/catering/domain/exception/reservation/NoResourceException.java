package com.digital.catering.domain.exception.reservation;

import lombok.Getter;

@Getter
public class NoResourceException extends RuntimeException{

    public enum NoResourceType{
        NO_RESOURCE_FOUND("No resource found");
        private final String message;

        public NoResourceException build(Throwable throwable){
            return new NoResourceException(this, throwable);
        }

        NoResourceType(String message){
            this.message = message;
        }
    }

    private final NoResourceType type;

    private NoResourceException(NoResourceType noResourceType, Throwable throwable){
        super(noResourceType.message, throwable);
        this.type = noResourceType;
    }
}
