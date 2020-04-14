package PrefixQueryMatch;

import java.util.TreeMap;


public class TrieNode extends TreeMap<Character, TrieNode> {
	public boolean isEnd;
	
	public TrieNode() {
		this.isEnd = false;
	}
}
