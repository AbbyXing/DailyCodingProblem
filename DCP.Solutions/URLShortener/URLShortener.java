package URLShortener;

import java.util.Vector;

/**
 * This problem can be used in database storing
 * 
 * Solution: assign an integer id to each URL and convert integer to 6 characters
 * long string.
 * 
 * Each character can have 26 + 26 + 10 = 62 options.
 * 
 * This problem becomes a convert decimal number to 62 base number
 * 
 * */

public class URLShortener {
	
	private Vector<String> db; // database
	private int capacity;
	private String code; // stores all available characters that can be used
	
	public URLShortener() {
		db = new Vector<>();
		capacity = (int) Math.pow(62, 6);
		code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	}
	
	public void shorten(String url) {
		// url is already in database, do nothing
		if(db.contains(url)) {
			int id = db.indexOf(url);
			System.out.println(convert(id));
			return;
		}
		// if reach the capacity
		if(db.size() == capacity) {
			System.out.println("No enough storage!");
			return;
		}
		// convert decimal id to short url and add url into db
		int id = db.size();
		System.out.println(convert(id));
		db.add(url);
	}
	
	// convert decimal id to short url
	private String convert(int id) {
		StringBuilder shortUrl = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			shortUrl.append(code.charAt(id % 62));
			id /= 62;
		}
		return shortUrl.toString();
	}
	
	public String restore(String shortUrl) {
		// convert short url to decimal id
		int id = 0;
		for(int i = 0; i < 6; i++) {
			id += code.indexOf(shortUrl.charAt(i)) * Math.pow(62, i);
		}
		// is in the db
		if(id < db.size()) {
			return db.get(id);
		}else { // not in the db
			return null;
		}
	}


	public static void main(String[] args) {
		URLShortener urlShortener = new URLShortener();
		urlShortener.shorten("www.abbyxing.com");
		System.out.println(urlShortener.restore("aaaaaa"));
		// shorten the same url multiple times will get the same short url
		urlShortener.shorten("www.abbyxing.com");
		System.out.println(urlShortener.restore("aaaaaa"));
		urlShortener.shorten("www.gap.com");
		System.out.println(urlShortener.restore("baaaaa"));
	}

}
