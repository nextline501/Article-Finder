import spacy
from collections import Counter
from heapq import nlargest

nlp = spacy.load('en_core_web_trf')

text = """Social media is a way to digitally link people around the globe. Social media are the apps and
websites that enable the people to participate in social networking and can have online
communications. People can share their photographs, location, life events, and their activities
with other people instantly. It all started in 1844 when Samuel Morse promoted a long distance
communication by sending a telegraph from Washington and then in 1997 first website
SixDegrees was launched and then Friendster and Myspace followed in 2003 and 2005. In 2004
Mark Zukerberg launched Facebook which helped people communicate in a new way (Singh
Ricky, 2019). Every day we spend hours using social media apps without being aware of the
time we spend. Facebook has been most popular for long time. Now many other apps like
Instagram, Twitter, YouTube, and Snapchat have also risen in competition. Every young person
as well as people from all the age groups are fond of using the social media (Esteban OrtizOspina, 2019). In this critical coronavirus situation the governmental authorities are 
11
recommending the social distancing. The only way to maintain safe connections is through the
social media and e-commerce. Social media is considered as the hub for the latest news and
updates regarding current situation. Statistics show that in this situation the trend of getting the
news and updates from social media has increased manifold. It is observed that people prefer
searching online rather than sticking to TV and radio. When we talk about coronavirus it would
not be an exaggeration to say that social media is creating awareness, helping in spreading news
and opinions. This time is said to be the magic moment (Marco Muller, 2020) for social media as
all the activities are cancelled and everyone is bound to stay at home. And a lot of videos like
“plandemic” are being circulated around the social media those describe the pandemic situation
in a misleading and dramatic way. In this hysterical situation people are hungry for information
and if they fail to achieve it they would surf the whole internet and believe whatever they see.
The best thing that can be seen in this regard is that social media influencers, actors, athletes that
are role models for many people are speaking up and are urging people to practice social
distancing and staying safe. And it can be seen as the best way to analyze and gather what people
are thinking and how they are reacting in this situation. Along with that it can be seen that in
beginning when pandemic started, people started panic buying (Alejandro de la Garza, 2020). It
was majorly because of social media too as they used to see news about shortage of masks,
sanitizers, toilet rolls people started panic buying which created some problems.
On the other side, social media is also the source of misinformation. Especially, in the case of
coronavirus such news can be proven chaotic. Spreading this sort of news further without any
research can be problematic in that panic situation (Logan Godfrey, 2020)."""