package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.List;

public class MenuTree implements Menu {

    private List<Node> items = new LinkedList<>();

    @Override
    public void add(String parentName, String childName, Action action) {
        Node existingItem = findNodeByName(parentName);
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
        Node foundItem = findNodeByName(name);
        return foundItem != null ? foundItem.action : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu")
                .append(System.lineSeparator());
        for (Node item : items) {
            appendNode(sb, item, 1);
        }
        return sb.toString();
    }

    private Node findNodeByName(String name) {
        Node node = null;
        for (Node item : items) {
            Node itemNode = findNodeByName(item, name);
            if (itemNode != null) {
                node = itemNode;
                break;
            }
        }
        return node;
    }

    private Node findNodeByName(Node item, String name) {
        if (item.name.equals(name)) {
            return item;
        }
        if (item.children.size() > 0) {
            for (Node child : item.children) {
                Node childNode = findNodeByName(child, name);
                if (childNode != null) {
                    return childNode;
                }
            }
        }
        return null;
    }

    private void appendNode(StringBuilder sb, Node node, int indentation) {
        sb.append("---".repeat(indentation))
                .append(" ")
                .append(node.name)
                .append(System.lineSeparator());
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
