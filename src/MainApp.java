import java.net.*;
import java.io.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	public static void main(String args[]) {
		String projectId;
		
		String html = "http://localhost/FrontPage." + projectId + ".SuiteRegressionTesting";
		try {
			Document doc = Jsoup.connect(html).get();
			Elements tableElements = doc.select("table");

			Elements tableRowElements = tableElements.select(":not(thead) tr");

			for (int i = 2; i < tableRowElements.size(); i++) {
				Element row = tableRowElements.get(i);
				System.out.println("row: " + i);
				Elements rowItems = row.select("td");
				for (int j = 0; j < rowItems.size(); j++) {
					if ("<td>Automated?</td>".equals(tableRowElements.get(0).select("td").get(j).toString())
							|| "<td>Test Case Readiness</td>".equals(tableRowElements.get(0).select("td").get(j).toString()))
						System.out.println(rowItems.get(j).text());
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
