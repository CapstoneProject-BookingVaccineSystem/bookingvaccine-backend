package com.altera.capstone.bookingvaccine.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NewsVaccineDto {

    private Long id_news_vaccine;

    @ApiModelProperty(notes = "Judul berita", example = "Pemberitahuan tentang kesehatan")
    private String titleNewsVaccine;

    @ApiModelProperty(notes = "Author berita", example = "Admin")
    private String authorNewsVaccine;

    @ApiModelProperty(notes = "Image berita", example = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")
    private String imageNewsVaccine;

    @ApiModelProperty(notes = "Isi berita", example = "Pemberitahuan tentang kesehatan")
    private String contentNewsVaccine;
}
