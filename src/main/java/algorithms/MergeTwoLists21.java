package algorithms;

public class MergeTwoLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = list1.val < list2.val ? list1 : list2;
        printListNode(res);
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean push(ListNode listNode, int val) {
        ListNode newNode = new ListNode(val);
        if (listNode != null) {
            ListNode cur = listNode;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        return false;
    }

    public static void printlnListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void printListNode(ListNode listNode) {
        System.out.print("[ ");
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        push(list1, 2);
        push(list1, 4);

        ListNode list2 = new ListNode(1);
        push(list2, 3);
        push(list2, 4);

        mergeTwoLists(list1, list2);

//        printlnListNode(mergeTwoLists(list1, list2));
    }


}
