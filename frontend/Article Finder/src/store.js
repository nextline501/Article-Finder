import { createStore } from 'vuex'

const state = {
    articles: [
        {
            id: "1",
            text: "test",
            tokentree: "Token",
            path: "Hard Coded Link",
            title: "NLP grupp 3",
            summary: "This is a summary"
        }
    ],  
}
const mutations = {


}

const actions = {
    

}


export default createStore({state, mutations, actions})