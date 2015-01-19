<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Bookmark Manager</title>
	</head>
	<body>
		<h2>Your Bookmarks</h2>
	
		<ul>
			<c:forEach items="${bookmarks}" var="bookmark">
				<li>
					<table>
						<tr>
							<form:form method="GET"
									action="/BookmarkManager/editBookmark/${bookmark.id}">
								<input type="submit" value="Edit"/>
							</form:form>
							<form:form method="POST"
									action="/BookmarkManager/removeBookmark/${bookmark.id}">
								<input type="submit" value="Remove"/>
							</form:form>
							<b> ${bookmark.name} - </b>
							<a href="${bookmark.url}">${bookmark.url}</a>
						</tr>
					</table>
				</li>
			</c:forEach>
		</ul>
	
		<form:form method="POST" modelAttribute="new_bookmark" action="/BookmarkManager/addBookmark">
			<form:input path="name" placeholder="Name" />
			<form:input path="url" placeholder="Url" />
			<input type="submit" value="Add bookmark"/>
		</form:form>
    
	</body>
</html>