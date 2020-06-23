
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URISyntaxException;

public class requests{

  // Functions
  public static String GET(URI url){
    /* As input, GET take an URI object. It does a GET request and returns
    the response as String if status is 200. If not, returns status code as string*/

    String body = "";

    try{
      // Http client object
      HttpClient client = HttpClient.newHttpClient();
      // HttpRequest object from uri
      HttpRequest request = HttpRequest.newBuilder(url).GET().build();
      // HttpResponse
      HttpResponse<String> response = client.send(request,  HttpResponse.BodyHandlers.ofString());
      // Get status code
      int status = response.statusCode();
      // Take response body if status code is ok!
      if(status==200){
        body = response.body();
      }else{
       body = "Bad Status Code. It's " + Integer.toString(status);
      }
    }catch(IOException err){
      err.printStackTrace();
    }catch(InterruptedException err){
      err.printStackTrace();
    }

    return body;
  }

  public static String POST(URI url){
    /* As input, GET take an URI object. It does a GET request and returns
    the response as String if status is 200. If not, returns status code as string*/

    String body = "";

    try{
      // Http client object
      HttpClient client = HttpClient.newHttpClient();
      // HttpRequest object from uri
      HttpRequest request = HttpRequest.newBuilder(url).POST(HttpRequest.BodyPublishers.ofString("ok")).build();
      // HttpResponse
      HttpResponse<String> response = client.send(request,  HttpResponse.BodyHandlers.ofString());
      // Get status code
      int status = response.statusCode();
      // Take response body if status code is ok!
      if(status==200){
        body = response.body();
      }else{
       body = "Bad Status Code. It's " + Integer.toString(status);
      }
    }catch(IOException err){
      err.printStackTrace();
    }catch(InterruptedException err){
      err.printStackTrace();
    }

    return body;

  }

  // App
  public static void main(String[] Args){

    // Host Server Settings and Uris
    String host = "http://192.168.1.168";
    String UriToGETData = "http://192.168.1.168/Data/Current";
    String UriToPOSTData = "http://192.168.1.168/Data/Update";

    try{
      /*** 1. GET requests to get data ***/
      // Construct uri
      URI uri = new URI(UriToGETData + "?Id=Fire1&Spec=All");
      // Get request to Host
      String response = GET(uri);
      // Log response
      System.out.println(response);

      /*** 2. POST request to update data ***/
      // Construct uri
      URI uri_v2 = new URI(UriToPOSTData + "?Id=Fire1&Spec=Level&Value=6");
      // Get request to Host
      String response_v2= POST(uri_v2);
      // Log response
      System.out.println(response_v2);

    }catch(URISyntaxException urierr){
      urierr.printStackTrace();
    }

  }

}
