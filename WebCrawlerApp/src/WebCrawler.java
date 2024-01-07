
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Queue;

public class WebCrawler {
    private Queue<String> urlsQueue;
    private Parser parser;
    private HttpClient httpClient;
    private Scheduler scheduler; // To avoid reate limiting and DoS
    private DataStore dataStore;


    public WebCrawler(Queue<String> urlsQueue, Parser parser, HttpClient httpClient, Scheduler scheduler, DataStore dataStore) {
        this.urlsQueue = urlsQueue;
        this.parser = parser;
        this.httpClient = httpClient;
        this.scheduler = scheduler;
        this.dataStore = dataStore;
    }


    public void crawl(String seedUrl) {
        urlsQueue.add(seedUrl);
        while (!urlsQueue.isEmpty()) {
            String url = urlsQueue.poll();
            HttpResponse response = HttpRequest.newBuilder().uri(URI.create(url)).build();
            Data data = parser.parseData(response);
            dataStore.store(data);
            scheduler.delay();// to avoid DoS
            for (String link : parser.extractLinks(response)) {
                urlsQueue.add(link);
            }


        }

    }


}
