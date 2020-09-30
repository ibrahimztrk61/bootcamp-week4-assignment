package com.ibrahim.bootcampweek4assignment.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Track {
    private String name;
    private String length;
    private String artist;

}
