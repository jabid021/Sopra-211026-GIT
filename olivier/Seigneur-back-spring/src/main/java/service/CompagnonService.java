package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CompagnonRepository;

@Service
public class CompagnonService {

	@Autowired
	private CompagnonRepository compagnonRepo;
	
	
}
