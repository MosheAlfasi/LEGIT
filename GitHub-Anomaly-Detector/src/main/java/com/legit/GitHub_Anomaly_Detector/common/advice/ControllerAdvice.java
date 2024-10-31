package com.legit.GitHub_Anomaly_Detector.common.advice;

import com.legit.GitHub_Anomaly_Detector.common.exeptions.AppException;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.ErrDTO;
import com.legit.GitHub_Anomaly_Detector.common.exeptions.ExceptionArea;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvice {

    private final Logger logger = LogManager.getLogger(ControllerAdvice.class.getName());

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<ErrDTO> handlerException(AppException e) {
        logger.error("App exception thrown, err message: {}", e.getMessage());
        ErrDTO errDTO = new ErrDTO(e.getExceptionArea().getAreaName(), e.getMessage());

        return new ResponseEntity<>(errDTO, e.getHttpStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrDTO> handlerException(Exception e) {
        logger.error("Exception thrown, err message: {}", e.getMessage());
        ErrDTO errDTO = new ErrDTO(ExceptionArea.GENERAL.getAreaName(), e.getMessage());

        return new ResponseEntity<>(errDTO, HttpStatus.BAD_REQUEST);
    }
}
