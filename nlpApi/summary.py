import spacy
from collections import Counter
from heapq import nlargest

# nlp = spacy.load('en_core_web_sm')
# nlp = spacy.load('en_core_web_md')
nlp = spacy.load('en_core_web_lg')
# nlp = spacy.load('en_core_web_trf')

def preprocessing_article(article):

    doc = nlp(article)

    with doc.retokenize() as retokenizer:
        for ent in doc.ents:
            retokenizer.merge(doc[ent.start:ent.end])

    doc_cleaned = [token.lemma_ for token in doc if not token.is_stop and not token.is_punct]

    not_wanted = ['\n','\x02']
    list = []

    for text in doc_cleaned:
        if text not in not_wanted:
            list.append(text)

    return ' '.join(list)



def get_summary(article, limit):
    # Remove line breaks
    clean_text = article.replace("\n", " ")
    # Transform to doc object for spacy
    doc = nlp(clean_text)
    # Create list of keywords
    keyword =[]
    for token in doc:
        if (token.is_stop or token.is_punct):
            continue
        if (token.pos_ in ['PROPN','NOUN','ADJ','VERB']):
            keyword.append(token.text)

    # Ranking of keywords
    freq_word = Counter(keyword)
    max_freq = Counter(keyword).most_common(1)[0][1]
    for word in freq_word.keys():
        freq_word[word] = (freq_word[word]/max_freq)
    # Assign weight to the sentences
    sent_weight ={}
    for sent in doc.sents:
        for word in sent:
            if word.text in freq_word.keys():
                if sent in sent_weight.keys():
                    sent_weight[sent] += freq_word[word.text]
                else:
                    sent_weight[sent] = freq_word[word.text]

    # Get the sentences with highest weigth - "limit" - integer that gives number of sentences
    summerized_sents = nlargest(limit, sent_weight, key=sent_weight.get)
    # Joining the list of sentence to a string
    final_sents = [ word.text for word in summerized_sents]
    summary = " ".join(final_sents)
    return summary