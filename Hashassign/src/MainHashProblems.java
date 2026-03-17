import java.util.*;

public class MainHashProblems {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==== HASH TABLE PROBLEMS MENU ====");
            System.out.println("1. Username Checker");
            System.out.println("2. Flash Sale Inventory");
            System.out.println("3. DNS Cache");
            System.out.println("4. Plagiarism Detection");
            System.out.println("5. Web Analytics");
            System.out.println("6. Rate Limiter");
            System.out.println("7. Autocomplete");
            System.out.println("8. Parking Lot");
            System.out.println("9. Two Sum");
            System.out.println("10. Multi-Level Cache");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: usernameChecker(); break;
                case 2: flashSale(); break;
                case 3: dnsCache(); break;
                case 4: plagiarism(); break;
                case 5: analytics(); break;
                case 6: rateLimiter(); break;
                case 7: autocomplete(); break;
                case 8: parking(); break;
                case 9: twoSum(); break;
                case 10: cache(); break;
                case 0: return;
            }
        }
    }

    // 1 Username Checker
    static void usernameChecker() {
        HashMap<String, Integer> users = new HashMap<>();
        HashMap<String, Integer> attempts = new HashMap<>();

        users.put("john", 1);

        String name = "john";

        attempts.put(name, attempts.getOrDefault(name, 0) + 1);

        if (users.containsKey(name)) {
            System.out.println("Taken");
            System.out.println("Suggestions: " + name + "1, " + name + "2");
        } else {
            System.out.println("Available");
        }
    }

    // 2 Flash Sale
    static void flashSale() {

        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("iphone", 2);

        for (int i = 1; i <= 3; i++) {

            if (stock.get("iphone") > 0) {
                stock.put("iphone", stock.get("iphone") - 1);
                System.out.println("Purchased. Left: " + stock.get("iphone"));
            } else {
                System.out.println("Out of stock → Waiting");
            }
        }
    }

    // 3 DNS Cache
    static void dnsCache() {

        HashMap<String, Long> cache = new HashMap<>();

        String domain = "google.com";

        if (cache.containsKey(domain) && cache.get(domain) > System.currentTimeMillis()) {
            System.out.println("Cache HIT");
        } else {
            System.out.println("Cache MISS → Fetching...");
            cache.put(domain, System.currentTimeMillis() + 5000);
        }
    }

    // 4 Plagiarism
    static void plagiarism() {

        String d1 = "java is programming";
        String d2 = "java is powerful programming";

        Set<String> s1 = new HashSet<>(Arrays.asList(d1.split(" ")));
        Set<String> s2 = new HashSet<>(Arrays.asList(d2.split(" ")));

        s1.retainAll(s2);

        System.out.println("Common words: " + s1.size());
    }

    // 5 Analytics
    static void analytics() {

        HashMap<String, Integer> views = new HashMap<>();
        views.put("/home", 0);

        views.put("/home", views.getOrDefault("/home", 0) + 1);
        views.put("/home", views.getOrDefault("/home", 0) + 1);

        System.out.println("Views: " + views);
    }

    // 6 Rate Limiter
    static void rateLimiter() {

        HashMap<String, Integer> limit = new HashMap<>();
        String user = "A";

        limit.put(user, 3);

        for (int i = 0; i < 5; i++) {

            if (limit.get(user) > 0) {
                limit.put(user, limit.get(user) - 1);
                System.out.println("Allowed");
            } else {
                System.out.println("Blocked");
            }
        }
    }

    // 7 Autocomplete
    static void autocomplete() {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("java", 10);
        map.put("javascript", 5);

        String prefix = "jav";

        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                System.out.println(key);
            }
        }
    }

    // 8 Parking Lot
    static void parking() {

        String[] spots = new String[5];

        String car = "ABC";

        int index = Math.abs(car.hashCode()) % 5;

        while (spots[index] != null) {
            index = (index + 1) % 5;
        }

        spots[index] = car;

        System.out.println("Parked at: " + index);
    }

    // 9 Two Sum
    static void twoSum() {

        int[] arr = {300, 200, 500};
        int target = 500;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            if (map.containsKey(target - num)) {
                System.out.println("Pair: " + num + " + " + (target - num));
            }

            map.put(num, 1);
        }
    }

    // 10 Multi-Level Cache
    static void cache() {

        LinkedHashMap<String, String> L1 = new LinkedHashMap<>(5, 0.75f, true);
        HashMap<String, String> L2 = new HashMap<>();

        String video = "vid1";

        if (L1.containsKey(video)) {
            System.out.println("L1 HIT");
        } else if (L2.containsKey(video)) {
            System.out.println("L2 HIT → Move to L1");
            L1.put(video, L2.get(video));
        } else {
            System.out.println("DB HIT → Add to L2");
            L2.put(video, "data");
        }
    }
}
