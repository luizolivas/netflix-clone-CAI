package response;

import api.HttpApi;
import entities.Filme;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FilmeResponse {

    private HttpApi Api = new HttpApi();

    public JSONArray trendingMovies(Integer id) {
        try {
            // Get movies
            JSONArray movies = Api.findMovie("/trending/all/week", "&language=pt-BR");

            // Get user with 'token'
            JSONObject user = getUserByHTTP(id);

            // FIlter result age User and return result
            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray netflixOriginalsMovies(Integer id) {
        try {
            JSONArray movies = Api.findMovie("/discover/tv", "&language=pt-BR&with_networks=213");

            JSONObject user = getUserByHTTP(id);

            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray topRatedMovies(Integer id) {
        try {
            JSONArray movies = Api.findMovie("/movie/top_rated", "&language=pt-BR");

            JSONObject user = getUserByHTTP(id);

            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray comedyMovies(Integer id) {
        try {
            JSONArray movies = Api.findMovie("/discover/tv", "&language=pt-BR&with_genres=35");

            JSONObject user = getUserByHTTP(id);

            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray romanceMovies(Integer id) {
        try {
            JSONArray movies = Api.findMovie("/discover/tv", "&language=pt-BR&with_genres=10749");

            JSONObject user = getUserByHTTP(id);

            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray documentaryMovies(Integer id) {
        try {
            JSONArray movies = Api.findMovie("/discover/tv", "&language=pt-BR&with_genres=99");

            JSONObject user = getUserByHTTP(id);

            return filterMoviesAge(user, movies);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Helper's
    private JSONObject getUserByHTTP(Integer id) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/auth/session?id=" + id); // our endpoint to find user with 'token'

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            return jsonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONArray filterMoviesAge(JSONObject user, JSONArray movies) {
        // If user is not adult
        if (((Long) user.get("age")).intValue() < 18) {
            JSONArray filteredMovies = new JSONArray();

            for (Object movie : movies) {
                JSONObject movieJSON = (JSONObject) movie;

                Object adultField = movieJSON.get("adult");

                // Get filter become with movies
                if (adultField == null || !(boolean) adultField) {
                    filteredMovies.add(movie);
                } else {
                    return null;
                }
            }

            return filteredMovies;
        }

        return movies;
    }

}