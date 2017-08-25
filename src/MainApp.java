import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	public static void main(String args[]) {
		List<String> urls = new ArrayList<>();

		String url = "http://localhost/FrontPage.SuitProject002";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements tableElements = doc.select("table");

			Elements tableRows = tableElements.select(":not(thead) tr");

			for (int i = 1; i < tableRows.size(); i++) {
				Element row = tableRows.get(i);
				Elements rowItems = row.select("td");

				urls.add(rowItems.get(0).text().substring(1));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < urls.size(); i++) {

			try {
				Document doc = Jsoup.connect(url + "." + urls.get(i)).get();
				Elements tableElements = doc.select("table");
				System.out.println(url + "." + urls.get(i));
				Elements tableRowElements = tableElements.select(":not(thead) tr");

				for (int j = 2; j < tableRowElements.size(); j++) {
					Element row = tableRowElements.get(j);
					System.out.println("row: " + j);
					Elements rowItems = row.select("td");
					for (int k = 0; k < rowItems.size(); k++) {
						if ("<td>Automated?</td>".equals(tableRowElements.get(0).select("td").get(k).toString())
								|| "<td>Test Case Readiness</td>"
										.equals(tableRowElements.get(0).select("td").get(k).toString()))
							System.out.println(rowItems.get(k).text());
					}
					System.out.println();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
