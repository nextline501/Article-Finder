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

    doc_cleaned = [token.lemma_ for token in doc if not token.is_stop and not token.is_punct and token.pos_ in ['PROPN','NOUN','ADJ','VERB']]

    not_wanted = ['\n','\x02']
    list = []

    for text in doc_cleaned:
        if text not in not_wanted:
            list.append(text)

    return ' '.join(list)



def get_summary(article, limit):
    # Remove line breaks
    clean_text = article.replace("\n", " ")
    clean_text = clean_text.replace("\x02", "")
    # Transform to doc object for spacy
    doc = nlp(clean_text)
    # Merge all different ents in to one token each, ex. Kalle Andersson becomes one token
    with doc.retokenize() as retokenizer:
        for ent in doc.ents:
            retokenizer.merge(doc[ent.start:ent.end])
    
    # Gather proper sentences
    # Some of doc.sents are not sentences that can be used to create a meaningful summary
    # So we start with removing those from our base. We define a proper sentence as having at least one 
    # noun and at least one verb.
    comp_sentences = []
    for sent in doc.sents:
        if sent[0].is_title and sent[-1].is_punct:
            contains_noun = 0
            contains_verb = 0
            for token in sent:
                if token.pos_ in ["NOUN", "PROPN", "PRON"]:
                    contains_noun += 1
                elif token.pos_ == "VERB":
                    contains_verb += 1
            if contains_noun > 0 and contains_verb > 0:
                 comp_sentences.append(sent)
    #new_sents = [ word.text for word in comp_sentences]
    #new_text = " ".join(new_sents)

    # Create list of keywords
    keyword =[]
    doc = nlp(" ".join([word.text for word in comp_sentences]))
    for token in doc:
        if (token.is_stop or token.is_punct):
            continue
        if (token.pos_ in ['PROPN','NOUN','ADJ','VERB']):   # Maybe remove since already added in preprocessing_article!!
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
    summary = summary.replace("<", "&lt;")
    return summary