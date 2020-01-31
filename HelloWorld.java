
import java.io.IOException;
public class HelloWorld {
    public static void main(String args[]) {
        String packageName = "me.codus.imazu";

        try {
            GooglePlayVersionNameParser.Result result = GooglePlayVersionNameParser.parse(packageName);
            System.out.println("got version= "+result.versionName);
            System.out.println("got updateInfos= "+result.updateInfos);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}