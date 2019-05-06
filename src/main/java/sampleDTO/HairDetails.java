package sampleDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HairDetails {
    @JsonProperty("colour")
    private String colour;
    @JsonProperty("id")
    private int id;
}
