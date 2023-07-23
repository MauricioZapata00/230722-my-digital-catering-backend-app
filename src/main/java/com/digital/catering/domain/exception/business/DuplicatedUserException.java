package com.digital.catering.domain.exception.business;

import lombok.Getter;

@Getter
public class DuplicatedUserException extends RuntimeException{

    public enum DuplicatedUserType {
        EMAIL_ALREADY_EXIST("Email already exists");

        private final String message;

        public DuplicatedUserException build(Throwable throwable){
            return new DuplicatedUserException(this, throwable);
        }

        DuplicatedUserType(String message){
            this.message = message;
        }
    }

    private final DuplicatedUserType type;

    private DuplicatedUserException(DuplicatedUserType duplicatedUserType, Throwable throwable){
        super(duplicatedUserType.message, throwable);
        this.type = duplicatedUserType;
    }
}
