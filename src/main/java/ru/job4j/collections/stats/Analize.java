package ru.job4j.collections.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int addCount = 0;
        int modCount = 0;
        int delCount = 0;
        Map<Integer, User> prevMap = new HashMap<>();
        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }
        for (User currUser : current) {
            User prevUser = prevMap.remove(currUser.getId());
            if (prevUser == null) {
                addCount++;
            } else if (!prevUser.equals(currUser)) {
                modCount++;
            }
            delCount = prevMap.size();
        }
        return new Info(addCount, modCount, delCount);
    }
}
