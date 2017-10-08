import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

class Word {

    public String get() {
        String word = "";

        try {
            URL url = new URL("http://setgetgo.com/randomword/get.php");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            word = in.readLine().trim();

            in.close();
            con.disconnect();
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }

        return word;
    }
}