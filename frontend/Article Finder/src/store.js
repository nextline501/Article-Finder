import { createStore } from 'vuex'

const state = {
    articles: [], 
    currentArticle: {}
}
const mutations = {

    setArticles(state, articles){
        state.articles = articles
    },
    setCurrentArticle(state, article){
        state.currentArticle = article
    }
}

const actions = {


}


export default createStore({state, mutations, actions})