package com.bookmarkmanager.repository;

import java.util.Collection;

import com.bookmarkmanager.data.Bookmark;

public interface BookmarkRepository {

	Long saveBookmark(Bookmark bookmark);
	
	Bookmark getBookmarkById(Long id);
	
	Collection<Bookmark> getBookmarks();

	void removeBookmarkById(Long id);
}
