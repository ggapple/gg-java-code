package TH_tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class  BTreePrinter {
    
public static void printNode(node root) {
    int maxLevel = maxLevel(root);
    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
}

private static void printNodeInternal(List<node> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || isAllElementsNull(nodes)) 
        return;

    int floor = maxLevel - level;
    int Lines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

    printWhitespaces(firstSpaces);

    List<node> newNodes = new ArrayList<node>();
    for (node node : nodes) {
        if (node != null) {
            System.out.print(node.data);
            newNodes.add(node.left);
            newNodes.add(node.right);
        } else {
            newNodes.add(null);
            newNodes.add(null);
            System.out.print(" ");
        }

        printWhitespaces(betweenSpaces);
    }
    System.out.println("");

    for (int i = 1; i <= Lines; i++) {
        for (int j = 0; j < nodes.size(); j++) {
            printWhitespaces(firstSpaces - i);
            if (nodes.get(j) == null) {
                printWhitespaces(Lines + Lines + i + 1);
                continue;
            }

            if (nodes.get(j).left != null)
                System.out.print("/");
            else
                printWhitespaces(1);

            printWhitespaces(i + i - 1);

            if (nodes.get(j).right != null)
                System.out.print("\\");
            else
                printWhitespaces(1);

            printWhitespaces(Lines + Lines - i);
        }

        System.out.println("");
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
}

private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++)
        System.out.print(" ");
}

private static int maxLevel(node node) {
    if (node == null)
        return 0;
    return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
}

private static boolean isAllElementsNull(List<node> list) {
    for (Object object : list) {
        if (object != null)
            return false;
    }
    return true;
}
}