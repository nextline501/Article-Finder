import urllib.request
import os
import pdfminer

from io import StringIO
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfdocument import PDFDocument
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.pdfparser import PDFParser




# New entry in DB
# The idea is to send a title and pdf-path as obj from Vue --> Spring --> Sanic --> Spacy (title + generated: text tokentree summary) --> Spring --> DB

def download_file(download_url, filename):

    response = urllib.request.urlopen(download_url)    
    file = open(filename + ".pdf", 'wb')
    file.write(response.read())
    file.close()


def pdf_to_string():

    output_string = StringIO()
    with open('test.pdf', 'rb') as in_file:
        parser = PDFParser(in_file)
        doc = PDFDocument(parser)
        rsrcmgr = PDFResourceManager()
        device = TextConverter(rsrcmgr, output_string, laparams=LAParams())
        interpreter = PDFPageInterpreter(rsrcmgr, device)
        for page in PDFPage.create_pages(doc):
            interpreter.process_page(page)

    text = output_string.getvalue()
    text = text.replace("\n", " ")
    text = text.replace("<", "&lt;")
    print(text)
    return text


def delete_created_file():
    if os.path.exists("test.pdf"):
        os.remove("test.pdf")
    else:
        print("The file does not exist")

# Run this! Returns a 'str'
def pdf_to_string_process(path):

    download_file(path,"test")
    content = pdf_to_string()
    delete_created_file()
    return content


# Run below to test
# path = "https://arxiv.org/pdf/1309.0238.pdf"
# pdf_to_string_process(path)
