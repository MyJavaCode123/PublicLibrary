# PublicLibrary
To Test the api's

http://localhost:8091/api/library/2
GET 
for getting book data for a library



http://localhost:8091/api/Books
POST Call
{
		"title":"JAVA",
		"author" : "David",
		"description" : "Introduction to JAVA",
		"publishedVersion" : "1.1",
		"libraryData":{
				"libraryName" : "Central Library",
				"libraryId" :1
		}
	}


http://localhost:8091/api/Books
PUT : 

{
	"id":4,
    "title":"JAVA",
    "author" : "Merlin",
    "description" : "Introduction to JAVA",
    "publishedVersion" : "1.1",
    "libraryData":{
			"libraryId" : 5,
            "libraryName" : "Central Library"
		}
}


delete 
http://localhost:8091/api/Books?id=3
