import spacy
from spacy.matcher import PhraseMatcher

# nlp = spacy.load('en_core_web_sm')
# nlp = spacy.load('en_core_web_md')
nlp = spacy.load('en_core_web_lg')
# nlp = spacy.load("en_core_web_trf")


def preprocessing_article(article):

    doc = nlp(article)

    # Merge all different ents in to one token each, ex. Kalle Andersson becomes one token
    with doc.retokenize() as retokenizer:
        for ent in doc.ents:
            retokenizer.merge(doc[ent.start:ent.end])

    doc_cleaned = [token.lemma_ for token in doc if not token.is_stop and not token.is_punct]

    not_wanted = ['\n','\x02']
    list = []

    for text in doc_cleaned:
        if text not in not_wanted:
            list.append(text)

    return list


def find_matches(sample, article):

    patterns = [nlp.make_doc(text) for text in sample]
    matcher = PhraseMatcher(nlp.vocab, attr="LOWER")
    matcher.add('phrase_matcher', None, *patterns)

    article_tokentree = article['tokentree']

    # Matcher demands parameter as doc format, not possible to take doc_cleaned direct, must make it a doc once again
    doc = nlp(article_tokentree)

    char_matched= matcher(doc)
    match_text = []
    for match_id, start, end in char_matched:
        match = doc[start:end]
        match_text.append(match)


    match_dict = { 'article': article, 'nbr_words_match': len(match_text), 'percent_match': len(match_text) / len(doc) * 100}
    print(f"Nbr of words mathing: {match_dict['nbr_words_match']} , ----> {match_dict['percent_match']:.2f} %  ")

    return match_dict


def match_rank_articles(search_text, article_list):

    search_text_doc = preprocessing_article(search_text)
    match_results = []

    for article in article_list:
        match = find_matches(search_text_doc, article)
        match_results.append(match)

    #Sort from highest percent_match to lowest
    match_results.sort(key=myFunc, reverse=True)

    print(f"\nBest matching article: {match_results[0]['percent_match']} %   Nbr of articles matched: {len(match_results)}")

    # Return the 5 best matches
    if len(match_results) > 5:
        return match_results[0:5]
    else:
        return match_results

def myFunc(e):
    return e['percent_match']

