package mentees.service;

import java.util.List;

import mentees.entity.Mentor;
import mentees.repository.MentorRepository;

public class MentorService {
	private final static MentorRepository mentorRepository = new MentorRepository();
	
	public boolean insertMentor(Mentor mentor) {
		return mentorRepository.insert(mentor);
	}
	
	public List<Mentor> readMentorList() {
		return mentorRepository.readMentorList();
	}
	
	public List<Mentor> searchBySubject(String query) {
		return mentorRepository.searchBySubject(query);
	}
	
	public Mentor findById(int id) {
		return mentorRepository.findById(id);
	}
	
	public String findNameById(int id) {
		return mentorRepository.findNameById(id);
	}
	
	public boolean deleteById(int id) {
		return mentorRepository.deleteById(id);
	}
	
	public boolean update(int id, String title, String subject, String content) {
		return mentorRepository.update(id, title, subject, content);
	}
}