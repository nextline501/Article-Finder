import { createStore } from 'vuex'

const state = {
    articles: [], 
    currentArticle: {},
    similarArticles: []
}
const mutations = {

    setArticles(state, articles){
        state.articles = articles
    },
    setCurrentArticle(state, article){
        state.currentArticle = article
    },
    setSimilarArticles(state, similarArticles){
        state.similarArticles = similarArticles
    }

}

const actions = {


}


export default createStore({state, mutations, actions})