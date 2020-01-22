
import java.io.IOException;
public class HelloWorld {
    public static void main(String args[]) {
        String packageName = "me.codus.imazu";

        try {
            String version = GooglePlayVersionNameParser.parse(packageName);
            System.out.println("got version= "+version);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}