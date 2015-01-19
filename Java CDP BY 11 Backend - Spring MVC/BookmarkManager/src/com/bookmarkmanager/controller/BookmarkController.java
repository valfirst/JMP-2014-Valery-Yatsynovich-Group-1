package com.bookmarkmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookmarkmanager.data.Bookmark;
import com.bookmarkmanager.repository.BookmarkRepository;

@Controller
public class BookmarkController {

	private BookmarkRepository bookmarkRepository;

	@RequestMapping("/")
	public ModelAndView showBookmarks() {
		
        ModelAndView mv = new ModelAndView("bookmark-manager");
        mv.addObject("new_bookmark", new Bookmark());
        mv.addObject("bookmarks", bookmarkRepository.getBookmarks());

		return mv;
	}
	
	@RequestMapping(value = "/addBookmark", method = RequestMethod.POST)
	public ModelAndView addBookmark(@ModelAttribute("new_bookmark")Bookmark bookmark, 
			ModelMap model) {

		bookmarkRepository.saveBookmark(bookmark);

		return showBookmarks();
	}
	
	@RequestMapping(value = "/removeBookmark/{id}", method = RequestMethod.POST)
	public ModelAndView removeBookmark(@PathVariable("id") Long id) {
		
		bookmarkRepository.removeBookmarkById(id);

		return showBookmarks();
	}
	
	@RequestMapping(value = "/editBookmark/{id}", method = RequestMethod.GET)
	public ModelAndView editBookmark(@PathVariable("id") Long id) {
		
		ModelAndView mv = new ModelAndView("edit");
        mv.addObject("bookmark", bookmarkRepository.getBookmarkById(id));
        
		return mv;
	}
	
	@RequestMapping(value = "/editBookmark", method = RequestMethod.POST)
	public ModelAndView editBookmark(@ModelAttribute("bookmark") Bookmark bookmark) {
		
		bookmarkRepository.saveBookmark(bookmark);
		return showBookmarks();
	}
	
	public void setBookmarkRepository(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}
}
