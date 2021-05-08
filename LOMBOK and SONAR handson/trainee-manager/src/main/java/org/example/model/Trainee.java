package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Trainee {
	private String email;
	private String name;
	private String cohortCode;
	private String empId;
}
