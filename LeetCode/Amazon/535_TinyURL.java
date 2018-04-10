public class Codec {

    // Encodes a URL to a shortened URL.
    
    private final Map<String, String> longToShort = new HashMap<String, String>();
    private final Map<String, String> shortToLong = new HashMap<String, String>();
    private Integer urlNum = 0;
    
    private String newShortUrl(){
        String shortUrl = urlNum.toString();
        urlNum++;
        return shortUrl;
    }
    
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl))
            return longToShort.get(longUrl);
        
        String shortUrl = newShortUrl();
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));