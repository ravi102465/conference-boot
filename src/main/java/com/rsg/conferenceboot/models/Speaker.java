package com.rsg.conferenceboot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity(name = "Speakers")
public class Speaker {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "speaker_id")
	private long speakerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "title")
	private String title;
	@Column(name = "company")
	private String company;
	
	@Column(name = "speaker_bio")
	private String speakerBio;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "speaker_photo")
	private byte[] speakerPhoto;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "speakers")
	private List<Session> sessions;
	
	public Speaker() {
		
	}
	
	
}
