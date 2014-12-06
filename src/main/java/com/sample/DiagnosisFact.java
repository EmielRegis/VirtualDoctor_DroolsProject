package com.sample;


public class DiagnosisFact {
	private String name;
	private Question status = Question.NOT_ASKED;
	private String expansion;
	
	public DiagnosisFact(String name)
	{
		this.name = name;
	}
	
	public DiagnosisFact(String name, Question status)
	{
		this.name = name;
		this.status = status;
	}
	
	public DiagnosisFact(String name, boolean status)
	{
		this.name = name;
		this.status = (status) ? Question.TRUE : Question.FALSE;
	}
	
	public DiagnosisFact(String name, String expansion)
	{
		this.name = name;
		this.expansion = expansion;
	}
	
	public DiagnosisFact(String name, Question status, String expansion)
	{
		this.name = name;
		this.status = status;
		this.expansion = expansion;
	}
	
	public DiagnosisFact(String name, boolean status, String expansion)
	{
		this.name = name;
		this.status = (status) ? Question.TRUE : Question.FALSE;
		this.expansion = expansion;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Question getStatus() {
		return status;
	}
	public void setStatus(Question status) {
		this.status = status;
	}

	public String getExpansion() {
		return expansion;
	}

	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}

}
