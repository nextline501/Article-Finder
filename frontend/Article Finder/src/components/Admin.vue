<template>
  <div class="container">
    <div class="shadow form-group " id="textAreaForm">
      <div class="container" id="titleDescr">
        <h4>Admin</h4>
        <h5>Add article to database</h5>
      </div>

      <div class="form-group row" id="adminForm">
        <label for="inputTitle">Title</label>
        <div class="col-sm">
          <input
            class="form-control p-2 mb-4"
            id="inputTitle"
            placeholder="Article title"
            v-model="articleTitle"
          />
        </div>

        <div class="form-group">
          <label for="inputURL">URL</label>
          <div class="col-sm">
            <input
              class="form-control p-2 mb-4"
              id="inputURL"
              type="url"
              pattern="https?://.+.pdf"
              placeholder="https://example.com/example.pdf"
              v-model="articleUrl"
            />
          </div>
        </div>

        <div class="container d-grid gap-2" id="buttonArea">
          <button
            v-if="!showSpinner"
            id="postArticleText"
            @click="createNewArticleText"
            class="btn btn-dark btn-rounded"
            type="button"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="22"
              height="22"
              fill="currentColor"
              class="bi bi-check2-circle"
              viewBox="0 0 16 16"
            >
              <path
                d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"
              />
              <path
                d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"
              />
            </svg>
            SUBMIT
          </button>

          <button
            v-else
            id="postArticleText"
            class="btn btn-dark btn-rounded"
            type="button"
            disabled
          >
            <span
              class="spinner-border spinner-border-sm"
              role="status"
              aria-hidden="true"
            ></span>
            Processing...
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import Admin from "./Admin.vue"
import DataServices from "../services/DataServices";

export default {
  name: "Admin",

  data() {
    return {
      articleTitle: "",
      articleUrl: "",
      showSpinner: false,
    };
  },

  methods: {
    checkContent() {},
    createNewArticleText() {
      if ((this.articleUrl.includes(".pdf") != true) || (this.articleTitle === "")) {
        document.querySelector("#inputTitle").required = "true";
        document.querySelector("#inputTitle").placeholder =
          "Empty input!";
        document.querySelector("#inputURL").placeholder =
          "Invalid URL! ";
        document.querySelector("#inputURL").required = "true";
      } 
      else {
        this.showSpinner = true;
        let articleData = {
          text: "",
          tokentree: "",
          path: this.articleUrl,
          title: this.articleTitle,
          summary: "",
        };

        DataServices.addArticleAdmin(articleData).then((response) => {
          console.log(response);

          this.submitted = true;
          this.articleTitle = "";
          this.articleUrl = "";
          this.showSpinner = false;
          //alert("Article added to database")
        });
      }
    },
  },
};
</script>

<style scoped>
#titleDescr {
  margin-bottom: 40px;
}

label {
  font-size: 20px;
}

button {
  border: 0px;

  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease 0s;
  padding: 10px;
  font-family: "Open Sans", sans-serif;
  margin-top: 20px;
  border-radius: 10px;
}

button:hover {
  border: 0px;
  background-color: #00bfa5;
  box-shadow: 0px 15px 20px rgba(78, 78, 78, 0.4);
  color: #fff;
}

nav-link {
  text-decoration: none;
}

h4 {
  font-size: 28px;
  font-weight: bold;
}

#textAreaForm {
  margin-top: 40px;
  border: 1px solid rgb(223, 223, 223);
  padding: 40px;
  border-radius: 10px;
}

#buttonArea {
  margin-bottom: 40px;
}

#inputTitle {
  border-radius: 10px;
}

#inputURL {
  border-radius: 10px;
}

label {
  font-size: 18px;
  font-weight: bold;
}

.form-control:focus {
  border-color: #000000;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0);
}

.form-control:invalid {
  border-color: red;
}
</style>
