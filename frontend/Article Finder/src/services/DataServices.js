import http from "../http-common";

class DataService {
  sendArticleText(data) {
    return http.post("/data", data)
  }
  
  sendArticleId(id) {
    return http.post("/read", id)
  }

  addArticleAdmin(data){
    return http.post("/articles", data)
  }

  get(id) {
    return http.get(`/tutorials/${id}`);
  }

  create(data) {
    return http.post("/majsmajs", data);
  }

  update(id, data) {
    return http.put(`/tutorials/${id}`, data);
  }

  delete(id) {
    return http.delete(`/tutorials/${id}`);
  }

  deleteAll() {
    return http.delete(`/tutorials`);
  }

  findByTitle(title) {
    return http.get(`/tutorials?title=${title}`);
  }
}

export default new DataService();