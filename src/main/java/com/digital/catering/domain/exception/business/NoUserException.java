package com.digital.catering.domain.exception.business;

import lombok.Getter;

@Getter
public class NoUserException extends RuntimeException{
    public enum NoUserType {
        PERSON_NOT_FOUND("Person does not exist");

        private final String message;

        public NoUserException build(Throwable throwable){
            return new NoUserException(this, throwable);
        }

        NoUserType(String message){
            this.message = message;
        }
    }

    private final NoUserType type;

    private NoUserException(NoUserType businessType, Throwable throwable){
        super(businessType.message, throwable);
        this.type = businessType;
    }
}
