package com.rsg.conferenceboot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//This annotation ignore below property which were added by spring for eager and 
//lazy loading and other sql releated properties.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "sessions")
@Data
public class Session {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="session_id")
	private long sessionId;
	
	@Column(name ="session_name")
	private String sessionName;
	
	@Column(name ="session_description")
	private String sessionDescription;
	
	@Column(name ="session_length")
	private int sessionLength;

	@ManyToMany
	@JoinTable(
			name = "session_speakers",
			joinColumns = @JoinColumn(name = "session_id"),
			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	private List<Speaker> speakers;
	
	public Session() {
	}
	
}
