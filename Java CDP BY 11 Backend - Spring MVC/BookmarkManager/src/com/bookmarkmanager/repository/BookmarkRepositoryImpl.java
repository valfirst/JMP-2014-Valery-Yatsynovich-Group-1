package com.bookmarkmanager.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bookmarkmanager.data.Bookmark;

public class BookmarkRepositoryImpl implements BookmarkRepository{

	private long sequence = 0;
	
	private Map<Long, Bookmark> bookmarks = 
			new HashMap<Long, Bookmark>();
	
	@Override
	public Bookmark getBookmarkById(Long id) {
		return bookmarks.get(id);
	}
	
	@Override
	public Long saveBookmark(Bookmark bookmark) {
		
		Long id = bookmark.getId();
		
		if (id == null){
			id = nextId();
			bookmark.setId(id);
		}
		
		bookmarks.put(id, bookmark);

		return id;
	}

	@Override
	public void removeBookmarkById(Long id) {
		bookmarks.remove(id);	
	}

	@Override
	public Collection<Bookmark> getBookmarks() {
		return bookmarks.values();
	}

	private Long nextId(){
		return ++sequence;
	}
	

}
