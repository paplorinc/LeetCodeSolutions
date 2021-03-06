package leetcode.encodeandDecodeTinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * <p>
 * Source: https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class Codec {
    Map<String, String> cache = new HashMap<>();
    String base = "http://tinyurl.com/";

    public String encode(String longUrl) {
        String hash = UUID.randomUUID().toString();
        cache.put(hash, longUrl);
        return base + hash;
    }

    public String decode(String shortUrl) {
        String hash = shortUrl.substring(base.length());
        return cache.get(hash);
    }
}
