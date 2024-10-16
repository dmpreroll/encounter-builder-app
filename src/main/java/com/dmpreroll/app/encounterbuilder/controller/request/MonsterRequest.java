package com.dmpreroll.app.encounterbuilder.controller.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class MonsterRequest {
    ObjectMapper objectMapper = new ObjectMapper();

    String slug = null;
    Integer page = null;
    Integer limit = null;
    String challengeRating = null;
    String armorClass = null;
    String type = null;
    String name = null;
    String pageNo = null;
    String document = null;
    String documentSlug = null;
    String ordering = null;
    String search = null;

    @Override
    public String toString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
