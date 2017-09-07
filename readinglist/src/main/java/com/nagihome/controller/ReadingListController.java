package com.nagihome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagihome.domain.Book;
import com.nagihome.repo.ReadingListRepository;

@Controller
@RequestMapping("/")
public class ReadingListController {

	private ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {

		List<Book> books = readingListRepository.findByReader(reader);
		model.addAttribute("books", books);
		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadersList(@PathVariable("reader") String reader, Book book) {

		book.setReader(reader);
		readingListRepository.save(book);

		return "redirect:/{reader}";
	}

}
