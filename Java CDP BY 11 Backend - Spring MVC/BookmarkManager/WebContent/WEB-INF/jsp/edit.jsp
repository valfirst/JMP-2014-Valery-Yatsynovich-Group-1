<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Bookmark Manager</title>
	</head>
	<body>
		<h2>Edit Bookmark</h2>

	<form:form method="POST" modelAttribute="bookmark" action="/BookmarkManager/editBookmark">
		<form:input path="id" type="hidden" />
		<form:input path="name" />
		<form:input path="url" />
		<input type="submit" value="Save bookmark"/>
	</form:form>
		
</body>
</html>