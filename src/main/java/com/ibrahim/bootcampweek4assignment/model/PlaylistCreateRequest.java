package com.ibrahim.bootcampweek4assignment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistCreateRequest {

    private String name;
    private String userId;
    private String description;
}


