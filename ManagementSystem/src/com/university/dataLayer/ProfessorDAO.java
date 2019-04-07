package com.university.datalayer;

import java.sql.ResultSet;

import com.university.model.Professor;

public interface ProfessorDAO {

	public void insertProfessor(Professor p);

	public void updateProfessor(Professor p, int id);

	public void deleteProfessor(String id);

	public int numberOfProfessors();

	public ResultSet readProfessors();

	public void close();

}
