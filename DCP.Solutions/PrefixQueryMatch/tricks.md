# Tricks

- extend `TreeMap<Character, TrieNode>` for TrieNode

- convert Array to Iterable: `Arrays.asList(array)`

- `map.computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`: if can't find a value with key = `key`, then execute the `mappingFunction(key, object)`

- `forEach(Consumer<? super T> action)` and `Map.forEach(BiConsumer<? super K, ? super V> action)`

- double colon (::) operator: `<Class name>::<method name>`