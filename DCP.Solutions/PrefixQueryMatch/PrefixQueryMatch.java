package PrefixQueryMatch;

import java.util.Arrays;

/**
 * The trie tree is often used for search tips.
 * For example, when entering a web address (query string), possible choices can be automatically searched out.
 * When there is no exact matching search result, the most similar prefix may be returned.
 * */

public class PrefixQueryMatch {
	
	public PrefixQueryMatch() {}

	public static void main(String[] args) {
		String[] data = new String[] {"dog", "deer", "dee", "deal"};
		Trie trie = new Trie(Arrays.asList(data));
		//trie.search("de").forEach(System.out::println);
		trie.search("do").forEach(System.out::println);
	}

}
