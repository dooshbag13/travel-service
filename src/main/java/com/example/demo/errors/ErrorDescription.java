package com.example.demo.errors;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonPropertyOrder({"timestamp", "errorMessage", "errorCode", "messages"})
@ToString
public class ErrorDescription {

    @ApiModelProperty(position = 1)
    private String timestamp;

    @ApiModelProperty(position = 2)
    private String errorMessage;

    @ApiModelProperty(position = 3)
    private Integer errorCode;

    @ApiModelProperty(position = 3)
    private List<String> messages;
}
