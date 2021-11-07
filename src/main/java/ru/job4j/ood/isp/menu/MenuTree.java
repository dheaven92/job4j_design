package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.List;

public class MenuTree implements Menu {

    private List<Node> items = new LinkedList<>();

    @Override
    public void add(String parentName, String childName, Action action) {
        Node existingItem = null;
        if (items.size() > 0) {
            for (Node item : items) {
                existingItem = findNodeByName(item, parentName);
            }
        }
        if (existingItem != null && childName != null) {
            existingItem.addChild(new Node(childName, action));
        } else {
            if (childName != null) {
                items.add(new Node(parentName, new Node(childName, action), action));
            } else {
                items.add(new Node(parentName, action));
            }
        }
    }

    @Override
    public Action select(String name) {
        Action action = null;
        Node foundItem = null;
        if (items.size() > 0) {
            for (Node item : items) {
                foundItem = findNodeByName(item, name);
            }
        }
        if (foundItem != null) {
            action = foundItem.action;
        }
        return action;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu\n");
        if (items.size() > 0) {
            for (Node item : items) {
                appendNode(sb, item, 1);
            }
        }
        return sb.toString();
    }

    private Node findNodeByName(Node item, String name) {
        if (item.name.equals(name)) {
            return item;
        }
        if (item.children.size() > 0) {
            for (Node child : item.children) {
                return findNodeByName(child, name);
            }
        }
        return null;
    }

    private void appendNode(StringBuilder sb, Node node, int indentation) {
        sb.append("---".repeat(indentation))
                .append(" ")
                .append(node.name)
                .append("\n");
        if (node.children.size() > 0) {
            indentation++;
            for (Node child : node.children) {
                appendNode(sb, child, indentation);
            }
        }
    }

    private static class Node {
        String name;
        List<Node> children = new LinkedList<>();
        Action action;

        Node(String name, Action action) {
            this.name = name;
            this.action = action;
        }

        Node(String name, Node child, Action action) {
            this.name = name;
            this.children.add(child);
            this.action = action;
        }

        void addChild(Node item) {
            this.children.add(item);
        }
    }
}
