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
        String jsonInputString = "{\"idToken\":\"eyJhbGciOiJSUzI1NiIsImtpZCI6InRCME0yQSJ9.eyJpc3MiOiJodHRwczovL3Nlc3Npb24uZmlyZWJhc2UuZ29vZ2xlLmNvbS90aW5nZXNvLTU1ODgwIiwibmFtZSI6ImFsYW4gYmFyYWhvbmEgcnVpeiIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHaVJrMW9nTHRoU3JjS01neGtKam5QamRKUEdSa2dVcnp5S0habWxsZ1x1MDAzZHM5Ni1jIiwiYXVkIjoidGluZ2Vzby01NTg4MCIsImF1dGhfdGltZSI6MTYxMTUxMTQxNywidXNlcl9pZCI6IlhGUElSTXVmUHViVmp1eEtJVm9lUjJ2YkxvazEiLCJzdWIiOiJYRlBJUk11ZlB1YlZqdXhLSVZvZVIydmJMb2sxIiwiaWF0IjoxNjExNTExNDE5LCJleHAiOjE2MTE5NDM0MTksImVtYWlsIjoiYWxhbi5iYXJhaG9uYUB1c2FjaC5jbCIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7Imdvb2dsZS5jb20iOlsiMTE0NDg4ODI2OTUwNTU0MjE2MTgyIl0sImVtYWlsIjpbImFsYW4uYmFyYWhvbmFAdXNhY2guY2wiXX0sInNpZ25faW5fcHJvdmlkZXIiOiJnb29nbGUuY29tIn19.aumLMvuPEnZaWPMBom6Zl0WuSU-Uva9QgbiG7JD8LZ8VBoYYun2GHCtpw4KIESVwy22RanlCNK2gQ7J4Qsf11Ar0adQcacAWjpaQ6-vkT7VIeZI0CUQZW22qKheQH2DWDE4lWwSF4M5xAG54J-Rgt1i6qGJOj-OaocaBGjiCquoU2XmH-5C3XUQV8ugCfxmUBFyeIN5J3Lr2FVWvyi9SE34hGfugGt2c7NXO6-eU5ozOcvndY7Un5RR1L-NTynQ-bCrNa-_GErEUMz3CyMGorqXzbuwyI6WRC_8Ouaji8HtrpN3BWW17dx4niUA1bQfwmzj4JvM-uqFqQ6RZ-hW0tQ\"}";
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