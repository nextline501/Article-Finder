from sanic import Sanic, response as res
from sanic.exceptions import NotFound
from time import time

# instantiate the app object
app = Sanic("app") # __name__

# API endpoint
@app.get('/nlpGet')
async def nlpGet(req):
    
    def stringTest(input):
        myString = input
        return myString
    
    return res.json({ "message": stringTest("yolo1nlp23232") })

@app.post('/nlpPost')
async def nlpPost(req):

    message = req.json
    print(message)
    print(message['dataBaseArticles'][0]['summary'])
    print(message['searchText'])
    # print(message['searchText']['searchText'])

    return res.json({"message": "Sanic POST OK!"})

# start the server
if __name__ == "__main__":
  app.run(port=5000)