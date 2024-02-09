/*
 * Course: Course: stop yelling at me checkstyle
 */
package bridge;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.net.ssl.SSLContext;
public class Test {
        public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
            // Disable SSL certificate check
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, TrustAllManager.getTrustManagers(), new java.security.SecureRandom());
            String encoding = Base64.getEncoder().encodeToString(("yoder" + ":" + args[0]).getBytes());

            // Create a custom HttpClient with the disabled certificate check
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            // Make the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dh-ood.hpc.msoe.edu/node/dh-node4.hpc.msoe.edu/5000/greet?username=Blah"))
                    .setHeader("Authorization", "Basic " + encoding).build()
                    ;

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.statusCode());
                System.out.println(response.body());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

/**
 * im sure this is important
 */
    class TrustAllManager {
        public static javax.net.ssl.TrustManager[] getTrustManagers() {
            return new javax.net.ssl.TrustManager[]{
                    new javax.net.ssl.X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
            };
        }
    }

