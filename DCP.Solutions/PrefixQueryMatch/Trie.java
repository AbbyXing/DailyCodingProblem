package PrefixQueryMatch;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public Trie(Iterable<String> data) {
		this();
		data.forEach(this::insert);
	}
	
	public void insert(String query) {
		TrieNode current = root;
		for(int i = 0; i < query.length(); i++) {
			current = current.computeIfAbsent(query.charAt(i), newNode -> new TrieNode());
		}
		current.isEnd = true;
	}
	
	public List<String> search(String query) {
		List<String> prefixMatchList = new ArrayList<>();
		TrieNode targetNode = findTrieNode(query);
		if(targetNode == null)
			return prefixMatchList;
		findAllPrefixWords(prefixMatchList, targetNode, new StringBuilder(query));
		return prefixMatchList;
	}
	
	// find the node whose key is the last char of query
	public TrieNode findTrieNode(String query) {
		TrieNode current = root;
		for(int i = 0; i < query.length(); i++) {
			current = current.get(query.charAt(i));
			if(current == null)
				return null;
		}
		return current;
	}
	
	// start from the found node, recursively explore all words start from that node
	public void findAllPrefixWords(List<String> result, TrieNode current, StringBuilder prefix) {
		current.forEach((Character c, TrieNode child) -> {
			StringBuilder word = new StringBuilder(prefix).append(c);
			if(child.isEnd)
				result.add(word.toString());
			findAllPrefixWords(result, child, word);
		});
	}
}
