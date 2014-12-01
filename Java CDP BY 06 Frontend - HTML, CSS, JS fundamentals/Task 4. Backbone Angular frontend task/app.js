
var model = {
};

angular
.module("todoApp", [])
.run(function($http){
	$http
		.get("items.json")
		.success(function(data) {
			model.items = data;
		});
})
.controller("todoCtrl", function($scope) {
	$scope.todo = model;

	$scope.addNewBookmark = function(bookmarkId, bookmarkURL, bookmarkTitle, bookmarkTags) {
		if (bookmarkId === undefined){
			$scope.todo.items.push({
				url: bookmarkURL,
				title: bookmarkTitle,
				tags: bookmarkTags
			});
		}else{
			$scope.todo.items[bookmarkId].url= bookmarkURL;
			$scope.todo.items[bookmarkId].title = bookmarkTitle;
			$scope.todo.items[bookmarkId].tags = bookmarkTags;
		}
		
		$scope.clearInput();
		$scope.updateTagsMap();
	}
	
	$scope.clearInput = function() {
		$scope.bookmarkId = undefined,
		$scope.bookmarkURL = "",
		$scope.bookmarkTitle = "",
		$scope.bookmarkTags = ""
	}
	
	$scope.removeBookmark = function(item) {
		$scope.todo.items.splice($scope.todo.items.indexOf(item), 1);
		$scope.updateTagsMap();
	}
	
	$scope.editBookmark = function(item) {
		$scope.bookmarkId = $scope.todo.items.indexOf(item);
		$scope.bookmarkURL = item.url;
		$scope.bookmarkTitle = item.title;
		$scope.bookmarkTags = item.tags;
		$scope.updateTagsMap();
	}
	
	$scope.updateTagsMap = function() {
		var tagsMap = {};
		
		for (var item of $scope.todo.items) {
			for (var tag of item.tags) {
				if (tagsMap[tag] === undefined){
					tagsMap[tag] = [];
				}
				tagsMap[tag].push(item);
			}
		}
		$scope.todo.tagsMap = tagsMap;
	}
	
	$scope.filterByTag = function(item) {
		return ($scope.todo.tagFilter === undefined || item.tags.indexOf($scope.todo.tagFilter) !== -1) ? true : undefined;
	}
	
	$scope.setTagFilter = function(key) {
		$scope.todo.tagFilter = key;
	}
	
	$scope.init = function () {
		$scope.updateTagsMap();
		$scope.clearInput();
	}
})
