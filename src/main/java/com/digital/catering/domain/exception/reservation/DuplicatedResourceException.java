package com.digital.catering.domain.exception.reservation;

import lombok.Getter;

@Getter
public class DuplicatedResourceException extends RuntimeException{

    public enum DuplicatedResourceType{
        RESOURCE_NAME_ALREADY_EXIST("Resource name already exists");
        private final String message;

        public DuplicatedResourceException build(Throwable throwable){
            return new DuplicatedResourceException(this, throwable);
        }

        DuplicatedResourceType(String message){
            this.message = message;
        }
    }

    private final DuplicatedResourceType type;

    private DuplicatedResourceException(DuplicatedResourceType duplicatedResourceType, Throwable throwable){
        super(duplicatedResourceType.message, throwable);
        this.type = duplicatedResourceType;
    }
}
