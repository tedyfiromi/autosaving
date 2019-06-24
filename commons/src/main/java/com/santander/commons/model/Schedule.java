package com.santander.commons.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="schedule")
@Getter @Setter
public class Schedule implements Serializable{

	private static final long serialVersionUID = -6269203956709434839L;
	@Id
	private String id;
	private String label;
	
}
