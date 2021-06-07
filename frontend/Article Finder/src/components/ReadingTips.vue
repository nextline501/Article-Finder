<template>
  <div class="container" id="readingTipsComp">
    <div class="container" id="headline">
      <h4>Similar articles</h4>
    </div>
    <!-- what happens if there are no similar articles is not fixed yet. Code below does not work if we get empty list back -->
    <template v-if="!similarArticles.length">
      <div class="d-flex align-items-left">
        <strong>Loading...</strong>
        <div
          class="spinner-border ms-auto"
          role="status"
          aria-hidden="true"
        ></div>
      </div>
    </template>
    <template v-else>
      <table class="table" id="resultsTable">
        <tbody>
          <div class="col" id="readingTipsCol">
            <div v-for="(article, i) in similarArticles" :key="i">
              <th scope="row">{{ i + 1 + "." }}</th>
              <td>
                <router-link
                  to="/Summary"
                  @click="setCurrentArticle(similarArticles[i].article)"
                  class="nav-link"
                >
                  {{ similarArticles[i].article.title }}
                </router-link>
              </td>
            </div>
          </div>
        </tbody>
      </table>
    </template>
  </div>
</template>

<script>
import DataServices from "../services/DataServices";

export default {
  name: "ReadingTips",

  computed: {
    similarArticles() {
      return this.$store.state.similarArticles;
    },
  },
  methods: {
    setCurrentArticle(article) {
      this.$store.commit("setCurrentArticle", article);
      this.$store.commit("setSimilarArticles", []);
      this.sendArticleId(article);
    },
    sendArticleId(article) {
      DataServices.sendArticleId(article.id.toString()).then((response) => {
        console.log(response);
        this.storeResponse = response.data.result;
        // This can't be used for render since it will take a couple of seconds to
        // for data to come. Maybe with actions (async ability) it will handle the delay??
        this.$store.commit("setSimilarArticles", response.data.result);
      });
    },
  },
};
</script>

<style scoped>
div {
  margin-left: px;
}

#headline {
  margin-top: 10px;
  margin-bottom: 10px;
  border-bottom: 1px solid rgb(180, 180, 180);
  text-align: left;
}

.nav-link {
  text-decoration: none;
  color: black;
}

.nav-link:hover {
  color: #00bfa5;
  text-decoration: underline;
}

#readingTipsCol {
  text-align: left;
}

#readingTipsComp {
  margin-top: 20px;
}
</style>
