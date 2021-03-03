import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException{

        URL url = new URL("https://back.catteam.tk/authorize");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        String jsonInputString = String.format("{\"idToken\": \"%s\"}", args[0]);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}
