import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com.br/");
		System.out.println(wd.getTitle());
	}
}
