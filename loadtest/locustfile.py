from locust import HttpUser, task, between

class SearchUser(HttpUser):
    host = "https://www.n11.com"
    wait_time = between(1, 3)

    @task(3)
    def search_valid(self):
        self.client.get("/arama", params={"q": "laptop"})

    @task(1)
    def search_empty(self):
        self.client.get("/arama", params={"q": ""})

    @task(1)
    def search_no_results(self):
        self.client.get("/arama", params={"q": "asdfghjklqwerty123456"})
