import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapperMain {

	public String scrapeData(String brand, boolean detailed) throws IOException {
		// TODO Auto-generated method stub

		String url = "https://www.arabam.com/ikinci-el?searchText="+brand;
		Document document = Jsoup.connect(url).timeout(6000).get();
		
		Elements listing = document.select(".listing-list-item.should-hover.bg-white");
		
		StringBuilder result = new StringBuilder();
		result.append("SEARCHING AND SCRAPING FOR YOU\n\n");
		result.append("@ Brand @ @ Year/Price @\n");
		
		for(org.jsoup.nodes.Element ls : listing) {
			String titleSrc = ls.select(".listing-text-new.word-break.val-middle.color-black2018").text();
			if(detailed) {
				String modelYr = ls.select(".fade-out-content-wrapper").text();
				result.append(titleSrc).append(" - ").append(modelYr).append("\n");
			} else {
				String priceSrc = ls.select(".db.no-wrap.listing-price").text();
				result.append(titleSrc).append(" - ").append(priceSrc).append("\n");
			}
		}
		return result.toString();
	}

}
