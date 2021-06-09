# Article-Finder
This is an application that gives you the opportunity to match text and return a list of articles from database that matches the input.
When you choose an article from the result you also get a suggestion on similar articles.
It´s possible to add a new article with URL and title into the database. (It has to be a PDF file)
NLP SpaCy then breaks down the PDF to string text and summarizes the text into a shorter paragraph.

#Project setup (Windows)
* Springboot, Sanic and VUE needs to be up and running for the app to work.

Terminal 1 (Frontend server)
1. cd frontend
2. cd "article finder"
3. npm install
4. npm run dev

Terminal 2 (Sanic server)
1. cd nlpApi
2. python main.py

Springboot server
* Article-Finder\src\main\java\com\grupp3\article_finder
* Run "ArticleFinderApplication" in your IDE

Api testning
1. npm install -g newman
2. cd testsPostman
3. newman run AllTests.postman_collection.json

Dependencies
* pip install -r requirements.txt
