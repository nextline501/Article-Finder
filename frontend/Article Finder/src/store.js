import { createStore } from 'vuex'

const state = {
    articles: [
        {
            id: "1",
            text: "test",
            tokentree: "Token",
            path: "Hard Coded Link",
            title: "Article Title",
            summary: "Article Summary"
        }
    ],  
}
const mutations = {

    setArticles(state, articles){
        state.articles = articles
    }
}

const actions = {


}


export default createStore({state, mutations, actions})