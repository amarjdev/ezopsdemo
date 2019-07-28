package com.ezops.ezopsDemo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author mundlamuri
 *
 */
@Entity
@Table(name = "titanic")
public class Passenger implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "passenger_id")
	private Integer passengerId;
	private int pclass;
	private String name;
    private String sex;
    private int age;
    @Column(name = "sib_sp")
    private int sibSp;
    private int parch;
    private String ticket;
    private Float fare;
    private String cabin;
    private String embarked;
    
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public int getPclass() {
		return pclass;
	}
	public void setPclass(int pclass) {
		this.pclass = pclass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSibSp() {
		return sibSp;
	}
	public void setSibSp(int sibSp) {
		this.sibSp = sibSp;
	}
	public int getParch() {
		return parch;
	}
	public void setParch(int parch) {
		this.parch = parch;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getEmbarked() {
		return embarked;
	}
	public void setEmbarked(String embarked) {
		this.embarked = embarked;
	}
    public int getPclassID() {
    	return this.pclass;
    }
    
}
