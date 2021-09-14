package ru.job4j.collections.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int addCount = 0;
        int modCount = 0;
        int delCount = 0;
        Map<Integer, User> currMap = new HashMap<>();
        for (User user : current) {
            currMap.put(user.getId(), user);
        }
        Map<Integer, User> prevMap = new HashMap<>();
        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }
        for (User prevUser : previous) {
            User currUser = currMap.get(prevUser.getId());
            if (currUser == null) {
                delCount++;
            } else if (!currUser.equals(prevUser)) {
                modCount++;
            }
        }
        for (User currUser : current) {
            User prevUser = prevMap.get(currUser.getId());
            if (prevUser == null) {
                addCount++;
            }
        }
        return new Info(addCount, modCount, delCount);
    }
}
