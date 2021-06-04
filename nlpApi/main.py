from sanic import Sanic, response as res
from sanic.exceptions import NotFound
import time
from matcher import match_rank_articles, match_rank_articles2
from summary import preprocessing_article, get_summary
from pdf_to_string import pdf_to_string_process

# instantiate the app object
app = Sanic("app") # __name__


@app.post('/nlpPost')
async def nlpPost(req):

    start = time.time()

    message = req.json
    article_list = message['dataBaseArticles']
    searchText = message['searchText']
    typeOfSearch = message['typeOfSearch']
    result = ''

    if typeOfSearch == 1:
        result = match_rank_articles(searchText, article_list)
        
    elif typeOfSearch == 2:
        result = match_rank_articles2(searchText, article_list)

    dictionary = {'result': result}
    end = time.time()
    print(f"Total time in python: {end - start:.2f} s")

    return res.json(dictionary)


@app.post('/articlePost')
async def articlePost(req):

    start = time.time()

    article = req.json
    article_text = pdf_to_string_process(article['path'])

    article['text'] = article_text
    article['tokentree'] = preprocessing_article(article_text)
    article['summary'] = get_summary(article_text, 10)

    end = time.time()
    print(f"Total time in python create new article: {end - start:.2f} s")

    return res.json(article)


# start the server
if __name__ == "__main__":
  app.run(port=5000)