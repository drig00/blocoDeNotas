package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	NoteRepository noterepository;
	
	public List<Note> getAllNotes(){
		return noterepository.findAll();
	}
	
	public Optional<Note> getNoteById(Long id) {
		return noterepository.findById(id);
	}
	
	public Note saveNote(Note note) {
		return noterepository.save(note);
	}
	
	public void deleteNote(Long id) {
		noterepository.deleteById(id);
	}
	
	public Note UpdatedNote(Long id, Note updatedNote) {
		Optional<Note> existingNote = noterepository.findById(id);
		Note note = existingNote.get();
		note.setId(updatedNote.getId());
		note.setContent(updatedNote.getContent());
		return noterepository.save(note);
	}
	
	public Optional<Note> getNoteByName(String name){
		return noterepository.findByName(name);
	}
	
	public long noteQuantity() {
		return noterepository.count();
	}
	
	public List<Note> getAllByName(String name){
		return noterepository.findAllByName(name);
	}
}
