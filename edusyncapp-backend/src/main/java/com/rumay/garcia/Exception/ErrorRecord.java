package com.rumay.garcia.Exception;
import java.time.LocalDateTime;

public record ErrorRecord (LocalDateTime datetime, String message, String details){

}
