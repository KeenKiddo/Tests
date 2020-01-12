package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Top250Downloader {

	public static void main(String[] args) {
		
		List<Movie> movies = new ArrayList<Movie>();
		String url = "https://www.kinopoisk.ru/top/";
		Document doc;
		Date date =new java.sql.Date(System.currentTimeMillis());
		try {
			doc = Jsoup.connect(url).get();
			for (int i = 1; i <= 250; i++) {
				Element el = doc.getElementById("top250_place_" + i);
				
				Movie mov = new Movie(getMovieId(el), getOriginalName(el), getYear(el));
				movies.add(mov);

				MovieDao dao = new MovieDao();
				dao.addMovie(mov);
				Rating rat = new Rating(i, date, getVotes(el), mov);
				dao.addRating(rat);
			}

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static int getMovieId(Element el) {

			Elements links = el.select("a[href]");
			String link =  links.get(0).attr("href");
			link = link.replace("/film/", "").replace("/", "");
			int id = Integer.parseInt(link);
			return id;
			
	}

	public static String getOriginalName(Element el) {
		Elements spans = el.select("span");
		if (spans.size() == 2) {
			return spans.get(0).text();
		} else { //no english name
			Elements links = el.select("a[href]");
			if (links.size() > 0) {
				String nameAndYear = links.get(0).text();
				String name = nameAndYear.substring(0, nameAndYear.lastIndexOf(" "));
				return name;
			}
		}
		return null;
	}
	public static String getYear(Element el) {
		Elements links = el.select("a[href]");
		if (links.size() > 0) {
			String nameAndYear = links.get(0).text();
			String year = nameAndYear.substring(nameAndYear.lastIndexOf("(") + 1, nameAndYear.length() - 1);
			return year;
		}
		
		return null;
	}
	public static String getRating(Element el) {
		Elements links = el.select("a[href]");
		if (links.size() > 1) {
			String rating = links.get(1).text();
			return rating;
		}
		
		return null;
	}
	public static String getVotes(Element el) {
		Elements spans = el.select("span");
		String voteField = null;
		if (spans.size() > 1) {
			voteField = spans.get(1).text();
		} else 	if (spans.size() > 0) {
			voteField = spans.get(0).text();
		} 
		if (voteField != null) {
			voteField = voteField.substring(1, voteField.length() - 1);
		}
		return voteField;
	}
}


