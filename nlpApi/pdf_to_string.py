import PyPDF2 
import urllib.request
import os

# New entry in DB
# The idea is to send a title and pdf-path as obj from Vue --> Spring --> Sanic --> Spacy (title + generated: text tokentree summary) --> Spring --> DB

def download_file(download_url, filename):
    response = urllib.request.urlopen(download_url)    
    file = open(filename + ".pdf", 'wb')
    file.write(response.read())
    file.close()


def pdf_to_string(pdfReader):
    page_content=""               
    for page_number in range(pdfReader.numPages):
        page = pdfReader.getPage(page_number)
        page_content += page.extractText()  
    page_content = page_content.replace("\n", " ") 
    return page_content


def delete_created_file():
    if os.path.exists("test.pdf"):
        os.remove("test.pdf")
    else:
        print("The file does not exist")


def pdf_to_string_process(path):
    download_file(path,"test")
    pdfFileObj = open('test.pdf', 'rb')
    pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
    page_content = pdf_to_string(pdfReader)
    pdfFileObj.close()
    delete_created_file()
    print(page_content)

    return page_content


# Run below to test
# path = "https://arxiv.org/pdf/1309.0238.pdf"
# pdf_to_string_process(path)
