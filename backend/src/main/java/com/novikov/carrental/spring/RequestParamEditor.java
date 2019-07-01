package com.novikov.carrental.spring;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;

/**
 * Класс для разбора JSON параметров
 */
@Slf4j
@RequiredArgsConstructor
public class RequestParamEditor extends PropertyEditorSupport {
    private final Class targetClass;
    private final ObjectMapper objectMapper;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        JsonFactory jsonFactory = objectMapper.getFactory();

        try {
            JsonParser jsonParser = jsonFactory.createParser(text);
            setValue(objectMapper.readValue(jsonParser, targetClass));
        } catch (Exception e) {
            log.error(String.format("Can not parse %s from value: %s", targetClass.getName(), text), e);
        }
    }

    @Override
    public String getAsText() {
        try {
            return new ObjectMapper().writeValueAsString(getValue());
        } catch (JsonProcessingException e) {
            log.error("Can not convert param to json", e);
            return "";
        }
    }
}
