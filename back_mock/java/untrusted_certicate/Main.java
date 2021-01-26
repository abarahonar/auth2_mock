import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager ()}, new SecureRandom());
        SSLContext.setDefault(ctx);

        URL url = new URL("https://back.catteam.tk/authorize");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setHostnameVerifier((s, sslSession) -> true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"idToken\":\"...\"}";
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

    private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) { }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) { }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
